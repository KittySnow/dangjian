package cn.dlbdata.dangjian.common.rest;

/**
 * @Author: linfujun
 * @Description: 预先检查器
 * @Date: Created on 14:18 2018/2/26
 */
public class Preconditions {

    /**
     * 检查是否不为NULL，为NULl抛出NullPointerException
     * @param reference
     * @param <T>
     * @return
     */
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        } else {
            return reference;
        }
    }
}
