package cn.dlbdata.dangjian.common.secret;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 * @Author: linfujun
 * @Description: Encryptor工厂类，用于加密密码等
 * @Date: Created on 14:59 2018/2/13
 */
public class EncryptorFactory {
    /**
     * 这里的password类似于salt,不要写在外部文件
     */
    private static final String MASTER_PASSWORD = "gridsum";
    private static final String ALGORITHM = "PBEWithMD5AndDES";
    private static final String KEY_OBTENTION_ITERATIONS = "1000";
    private static final String POOL_SIZE = "1";
    /**
     * sunJce工具进行加密解密
     */
    private static final String PROVIDER_NAME = "SunJCE";
    private static final String STRING_OUTPUT_TYPE = "base64";

    public static StringEncryptor newStringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(MASTER_PASSWORD);
        config.setAlgorithm(ALGORITHM);
        config.setKeyObtentionIterations(KEY_OBTENTION_ITERATIONS);
        config.setPoolSize(POOL_SIZE);
        config.setProviderName(PROVIDER_NAME);
        config.setStringOutputType(STRING_OUTPUT_TYPE);
        encryptor.setConfig(config);
        return encryptor;
    }

    public static void main(String[] args) {
    	System.out.println(EncryptorFactory.newStringEncryptor().encrypt("123456"));
        System.out.println(EncryptorFactory.newStringEncryptor().decrypt("ETWygv0bn5NoUv2V96KGbXgPbzxqxvRz"));
    }
}
