package cn.dlbdata.dangjian.common;

/**
 * @Author: linfujun
 * @Description: TSA异常
 * @Date: Created on 17:44 2017/12/12
 */
public class DangjianException extends Exception {
    private static final long serialVersionUID = 1L;

    private int errorCode;
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public DangjianException(int code, String msg) {
        super(msg);
        this.errorCode = code;
        this.errorMsg = msg;
    }
}
