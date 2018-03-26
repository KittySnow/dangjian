package cn.dlbdata.dangjian.admin.service.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 15:06 2018/3/25
 */
public class DangjianUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(DangjianUtil.class);

    private static String bytesToHex(byte[] md5Array) {
        BigInteger bigInt = new BigInteger(1, md5Array);
        return bigInt.toString(16);
    }

    public static String getMD5(final String message)	{
        String md5Str	= "";
        try	{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] input= message.getBytes();
            byte[] buf	= md.digest(input);
            md5Str	= bytesToHex(buf);
        } catch (Exception ex)	{
            LOGGER.error(ex.getMessage());
        }

        return md5Str;
    }
}
