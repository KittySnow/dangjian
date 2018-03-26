package cn.dlbdata.dangjian.common.http;

import cn.dlbdata.dangjian.common.DangjianException;

/**
 * @Author: linfujun
 * @Description: 统一的异常处理
 * @Date: Created on 21:36 2017/12/12
 */
public class ErrorHandler {

    public static final int PARSE_TO_JSON_ERROR = 100000;
    public static final int ENCODING_ERROR = 100001;
    public static final int MISSING_REQUIRED_PARAM = 100002;
    public static final int ERROR_PARAM = 100003;
    public static final int ANNOTATION_ERROR = 100004;

    public static DangjianException getCustomTsaException(int code, String msg) {
        return new DangjianException(code, msg);
    }

    public static DangjianException parseToJsonError() {
        return new DangjianException(PARSE_TO_JSON_ERROR, "Parse to json error");
    }

    public static DangjianException errorParam(String message) {
        return new DangjianException(ERROR_PARAM, message);
    }

    public static DangjianException encodingError() {
        return new DangjianException(ENCODING_ERROR, "Encoding error");
    }

    public static DangjianException missingRequiredParam() {
        return new DangjianException(MISSING_REQUIRED_PARAM, "This method is missing required params");
    }

    public static DangjianException missingRequiredParam(String paramName) {
        return new DangjianException(MISSING_REQUIRED_PARAM, "This method is missing required params：" + paramName);
    }

    public static DangjianException annotationError(String massage) {
        return new DangjianException(ANNOTATION_ERROR, massage);
    }

}
