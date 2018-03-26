package cn.dlbdata.dangjian.common.util;

import cn.dlbdata.dangjian.common.secret.EncryptorFactory;
import org.jasypt.encryption.StringEncryptor;

/**
 * @Author: linfujun
 * @Description: 基于密码加密的对称加密算法
 * @Date: Created on 15:16 2018/2/13
 */
public class PBEUtil {
    private final static StringEncryptor stringEncryptor = EncryptorFactory.newStringEncryptor();

    /**
     * 加密
     * @param var
     * @return
     */
    public static String encrypt(String var) {
        return stringEncryptor.encrypt(var);
    }

    /**
     * 解密
     * @param var
     * @return
     */
    public static String decrypt(String var) {
        return stringEncryptor.decrypt(var);
    }

    public static void main(String[] args) {
        System.out.println(PBEUtil.encrypt("71257125"));
    }
}
