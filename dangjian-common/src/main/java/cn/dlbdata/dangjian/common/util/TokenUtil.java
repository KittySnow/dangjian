package cn.dlbdata.dangjian.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.krb5.internal.crypto.Aes128;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);

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
     * 验证 token 是否合法
     *
     * @param token
     * @param userId
     * @return
     */
    public static boolean checkToken(String token, String userId) {
        String decryptToken;
        try {
            decryptToken = URLDecoder.decode(token, "utf-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("Token URLDecoder.decode error.", e);

            return false;
        }

        String[] decryptTokens = decryptToken.split("\\.");
        if (decryptTokens.length != 2) {
            logger.info("Illegal token, tokens length not equal to 2.");

            return false;
        }

        boolean checkSignature = checkSignature(decryptTokens[0], decryptTokens[1]);
        if (!checkSignature) {
            logger.info("Illegal signature.");

            return false;
        }

        return checkTokenData(decryptTokens[0], userId);
    }

    /**
     * 签名验证
     *
     * @param token
     * @param signature
     * @return
     */
    private static boolean checkSignature(String token, String signature) {
        String reckonSignature;

        try {
            reckonSignature = createSignature(token);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | UnsupportedEncodingException | IllegalBlockSizeException e) {
            logger.error("create signature error.", e);

            return false;
        }

        return signature.equals(reckonSignature);
    }

    /**
     * 验证加密数据内容是否一致
     *
     * @param token
     * @param userId
     * @return
     */
    private static boolean checkTokenData(String token, String userId) {
        String originalToken;
        try {
            originalToken = AESUtil.decrypt(token);
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error("AES Decrypt error.", e);

            return false;
        }

        Map<String, String> paris = parserOriginalEncryptString(originalToken);

        String checkUserId = paris.get("userId");
        if (null == checkUserId || !userId.equals(checkUserId)) {
            logger.info("Token data userId is not equal to request userId, check failed.");
            return false;
        }

        // TODO: 可增加 token 时效验证
        // TODO: 可增加 userAgent 串验证

        return true;
    }

    /**
     * 解析原始 token 为 map
     *
     * @param originalToken
     * @return
     */
    private static Map<String, String> parserOriginalEncryptString(String originalToken) {
        String[] tokens = originalToken.split(",");

        Map<String, String> pairs = new HashMap<>(tokens.length);

        for (String token : tokens) {
            String[] pair = token.split("=");
            pairs.put(pair[0].trim(), pair[1].trim());
        }

        return pairs;
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
