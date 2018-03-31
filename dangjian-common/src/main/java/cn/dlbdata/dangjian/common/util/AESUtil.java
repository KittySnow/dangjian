package cn.dlbdata.dangjian.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESUtil {
    private static Logger logger = LoggerFactory.getLogger(AESUtil.class);

    private static final String password = "SW1$EgHgK4e!GsE^";

    private static SecretKeySpec getKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        KeyGenerator kgen;
        SecureRandom secureRandom;

        kgen = KeyGenerator.getInstance("AES");

        secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes("utf-8"));

        kgen.init(128, secureRandom);

        SecretKey secretKey = kgen.generateKey();

        byte[] enCodeFormat = secretKey.getEncoded();

        return new SecretKeySpec(enCodeFormat, "AES");
    }

    /**
     * 加密方法
     *
     * @param content
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws UnsupportedEncodingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String encrypt(String content) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec key = getKey();

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] byteContent = content.getBytes("utf-8");
        byte[] result = cipher.doFinal(byteContent);

        return new BASE64Encoder().encode(result);
    }

    /**
     * 解密方法
     *
     * @param content
     * @return
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IOException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public static String decrypt(String content) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec key = getKey();

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decordedValue = new BASE64Decoder().decodeBuffer(content);

        return new String(cipher.doFinal(decordedValue), "utf-8");
    }

    public static void main(String[] argv) {
        String test = "adfa334sdfasfdasf多字节字符";

        try {
            String encryptString = encrypt(test);
            System.out.println(encryptString);

            System.out.println(decrypt(encryptString));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
