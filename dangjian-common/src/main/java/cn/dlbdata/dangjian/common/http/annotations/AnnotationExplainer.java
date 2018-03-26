package cn.dlbdata.dangjian.common.http.annotations;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.http.ErrorHandler;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author: linfujun
 * @Description: 注释解释器
 * @Date: Created on 10:06 2017/12/15
 */
public class AnnotationExplainer {
    /**
     * 将参数实体类标注了@Param的解析出来放入参数表map
     *
     * @param param 参数实体类对像
     * @param <T>
     * @return 参数表map
     * @throws IllegalAccessException
     */
    public static <T> Map<String, Object> explainParamMap(T param) throws DangjianException {
        if (!isPassRequiredCheck(param)) {
            throw ErrorHandler.missingRequiredParam();
        }
        if (!checkParamValid(param)) {
            throw ErrorHandler.errorParam("Param is invalid");
        }
        Map<String, Object> paramMap = new HashMap<>();
        List<Field> concatFields = getFieldsAndSuperFields(param);
        for (Field field : concatFields) {
            if (field.isAnnotationPresent(Param.class)) {
                try {
                    Param paramAnnotation = field.getAnnotation(Param.class);
                    String key = paramAnnotation.key();
                    if (key == null || StringUtils.isEmpty(key)) {
                        key = field.getName();
                    }
                    field.setAccessible(true);
                    Object value = field.get(param);
                    if (key != null && value != null) {
                        paramMap.put(key, value);
                    }
                } catch (IllegalAccessException e) {
                    throw ErrorHandler.annotationError("No access to field : " + field.getName());
                }
            }
        }
        return paramMap;
    }

    /**
     * 检查参数是否符合要求
     *
     * @param param 参数实体类对像
     * @param <T>
     * @return 是否符合
     * @throws DangjianException
     */
    public static <T> Boolean checkParamValid(T param) throws DangjianException {
        if (!isMinMaxValid(param)) {
            return false;
        }
        if (!isArraySizeMinMaxValid(param)) {
            return false;
        }
        return true;
    }

    /**
     * 检查标注为notNull=true的参数是否为null
     * @param param 参数
     * @param <T>
     * @return
     * @throws DangjianException
     */
    public static <T> Boolean isPassRequiredCheck(T param) throws DangjianException {
        List<Field> concatFields = getFieldsAndSuperFields(param);
        Boolean valid = true;
        for (Field field : concatFields) {
            if (field.isAnnotationPresent(Param.class)) {
                try {
                    Param paramAnnotation = field.getAnnotation(Param.class);
                    Boolean required = paramAnnotation.required();
                    if (required) {
                        field.setAccessible(true);
                        Object value = field.get(param);
                        if (value == null) {
                            valid = false;
                            break;
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw ErrorHandler.annotationError("No access to field : " + field.getName());
                }

            }
        }
        return valid;
    }

    public static <T> Boolean isMinMaxValid(T param) throws DangjianException {
        List<Field> concatFields = getFieldsAndSuperFields(param);
        Boolean valid = true;
        for (Field field : concatFields) {
            if (field.isAnnotationPresent(Param.class)) {
                try {
                    Param paramAnnotation = field.getAnnotation(Param.class);
                    Integer min = paramAnnotation.min();
                    Integer max = paramAnnotation.max();
                    field.setAccessible(true);
                    Object value = field.get(param);
                    if (value == null) {
                        continue;
                    }
                    if (min != Integer.MIN_VALUE || max != Integer.MAX_VALUE) {
                        if (min != Integer.MIN_VALUE && value instanceof Integer) {
                            int compareFlag = min.compareTo((Integer) value);
                            if (compareFlag > 0) {
                                valid = false;
                                break;
                            }
                        }
                        if (max != Integer.MAX_VALUE && value instanceof Integer) {
                            int compareFlag = max.compareTo((Integer) value);
                            if (compareFlag < 0) {
                                valid = false;
                                break;
                            }
                        }
                        if (!(value instanceof Integer)) {
                            throw ErrorHandler.annotationError("Annotation used erroneously in max or min" );
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw ErrorHandler.annotationError("No access to field : " + field.getName());
                }

            }
        }
        return valid;
    }

    public static <T> Boolean isArraySizeMinMaxValid(T param) throws DangjianException {
        List<Field> concatFields = getFieldsAndSuperFields(param);
        Boolean valid = true;
        for (Field field : concatFields) {
            if (field.isAnnotationPresent(Param.class)) {
                try {
                    Param paramAnnotation = field.getAnnotation(Param.class);
                    Integer arraySizeMin = paramAnnotation.arraySizeMin();
                    Integer arraySizeMax = paramAnnotation.arraySizeMax();
                    field.setAccessible(true);
                    Object value = field.get(param);
                    if (value == null) {
                        continue;
                    }
                    if (arraySizeMin != -1 || arraySizeMax != -1) {
                        int arraySize = ((Collection) value).size();
                        if (arraySizeMin != -1 && value instanceof Collection) {
                            if (arraySize < arraySizeMin) {
                                valid = false;
                                break;
                            }
                        }
                        if (arraySizeMax != -1 && value instanceof Collection) {
                            if (arraySize > arraySizeMax) {
                                valid = false;
                                break;
                            }
                        }
                        if (!(value instanceof Collection)) {
                            throw ErrorHandler.annotationError("Annotation used erroneously in arrayMin or arrayMax");
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw ErrorHandler.annotationError("No access to field : " + field.getName());
                }

            }
        }
        return valid;
    }

    private static <T> List<Field> getFieldsAndSuperFields(T param) {
        List<Field> concatFields = new ArrayList<>();
        Class paramClass = param.getClass();
        Field[] fields = paramClass.getDeclaredFields();
        concatFields.addAll(Arrays.asList(fields));
        Class superclass = paramClass.getSuperclass();
        while(superclass != null) {
            if("java.lang.Object".equals(superclass.getName())){
                break;
            }
            Field[] superFields = superclass.getDeclaredFields();
            concatFields.addAll(Arrays.asList(superFields));
            superclass = superclass.getSuperclass();
        }
        return concatFields;
    }
}
