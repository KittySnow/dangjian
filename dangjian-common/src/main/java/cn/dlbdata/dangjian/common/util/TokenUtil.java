package cn.dlbdata.dangjian.common.util;

import sun.security.krb5.internal.crypto.Aes128;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class TokenUtil {
    /**
     * 获取 token 信息
     *
     * @param userAgent
     * @param userId
     * @return
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws UnsupportedEncodingException
     */
    public static String token(String userAgent, int userId) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        String token;
        String signature;

        token = createToken(userAgent, userId);
        signature = createSignature(token);

        return URLEncoder.encode(token + "." + signature, "utf-8");
    }

    /**
     * 创建token, token定义规则为：userAgent={userAgent},userId={userId}
     *
     * @param userAgent
     * @param userId
     * @return
     * @throws NoSuchPaddingException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     */
    private static String createToken(String userAgent, int userId) throws NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        // TODO: 加入时效信息, 失效时间
        Long currentTime = System.currentTimeMillis();
        String originalEncrypt = "userAgent=" + userAgent + ",userId=" + userId + ",time=" + currentTime.toString();

        return AESUtil.encrypt(originalEncrypt);
    }

    /**
     * 创建 签名，签名定义规则为：{token},{salt}; salt不能修改
     *
     * @param token
     * @return
     * @throws NoSuchPaddingException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     */
    private static String createSignature(String token) throws NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidKeyException {
        String salt = "IV2M*lSm@Gkny%o!";

        String originalSignature = token + "," + salt;

        return AESUtil.encrypt(originalSignature);
    }
}
