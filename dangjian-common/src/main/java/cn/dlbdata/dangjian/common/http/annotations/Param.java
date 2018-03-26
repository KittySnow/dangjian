package cn.dlbdata.dangjian.common.http.annotations;

import java.lang.annotation.*;

/**
 * @Author: linfujun
 * @Description: 请求参数注释，标注在属性上方重写key可以将参数的key值改变
 * @Date: Created on 23:58 2017/12/14
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Param {
    String key() default "";
    int min() default Integer.MIN_VALUE;
    int max() default Integer.MAX_VALUE;
    int arraySizeMin() default -1;
    int arraySizeMax() default -1;
    boolean required() default false;
}
