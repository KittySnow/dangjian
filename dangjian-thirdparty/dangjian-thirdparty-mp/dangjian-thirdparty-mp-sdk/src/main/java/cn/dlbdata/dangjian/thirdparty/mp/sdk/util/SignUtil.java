package cn.dlbdata.dangjian.thirdparty.mp.sdk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * ClassName: SignUtil
 * @Description: 请求校验工具类 
 * @author XiaoJiu
 * @date 2017-10-17
 */

public class SignUtil {  
    // 与接口配置信息中的 Token 要一致   
    private static String token = "xiaojiuWechat";  

    /**
     * @Description: 验证签名 
     * @param @param signature
     * @param @param timestamp
     * @param @param nonce
     * @param @return 
     * @author XiaoJiu
     * @date 2017-10-18
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {  
        String[] arr = new String[] { token, timestamp, nonce };  
        // 将 token、timestamp、nonce 三个参数进行字典序排序   
        Arrays.sort(arr);  
        StringBuilder content = new StringBuilder();  
        for (int i = 0; i < arr.length; i++) {  
            content.append(arr[i]);  
        }  
        MessageDigest md = null;  
        String tmpStr = null;  
        try {  
            md = MessageDigest.getInstance("SHA-1");  
            // 将三个参数字符串拼接成一个字符串进行 sha1 加密   
            byte[] digest = md.digest(content.toString().getBytes());  
            tmpStr = byteToStr(digest);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        content = null;  
        // 将 sha1 加密后的字符串可与 signature 对比，标识该请求来源于微信   
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;  
    }  

    /**
     * 
     * @Description: 将字节数组转换为十六进制字符串 
     * @param @param byteArray
     * @param @return
     * @author XiaoJiu
     * @date 2017-10-18
     */
    private static String byteToStr(byte[] byteArray) {  
        String strDigest = "";  
        for (int i = 0; i < byteArray.length; i++) {  
            strDigest += byteToHexStr(byteArray[i]);  
        }  
        return strDigest;  
    }  

    /**
     * @Description: 将字节转换为十六进制字符串 
     * @param @param mByte
     * @param @return
     * @author XiaoJiu
     * @date 2017-10-18
     */
    private static String byteToHexStr(byte mByte) {  
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] tempArr = new char[2];  
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
        tempArr[1] = Digit[mByte & 0X0F];  
        String s = new String(tempArr);  
        return s;  
    }  
}