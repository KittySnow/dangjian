package cn.dlbdata.dangjian.common.rest;

import cn.dlbdata.dangjian.common.IValueObject;
import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.http.ErrorHandler;
import cn.dlbdata.dangjian.common.util.FastJsonConverter;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 15:54 2018/2/26
 */
public class HttpParamUtil {

    private static final String CHARSET = "UTF-8";

    /**
     * 格式化请求url
     * @param url 基础url
     * @param params uri传参
     * @return
     * @throws DangjianException
     */
    public static String formatUrl(String url, Map<String, Object> params) throws DangjianException {
        if (params != null && params.size() > 0) {
            String encodedParams = HttpParamUtil.encodeParameters(params);
            url = url + "?" + encodedParams;
        }
        return url;
    }


    public static URI formatUrlToUri(String url, Map<String, Object> params) throws DangjianException {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        if (params != null && params.size() > 0) {


            for (Map.Entry<String, Object> entry : params.entrySet()) {

                try {
                    builder.queryParam(entry.getKey(), convertObject(entry.getValue()) );
                } catch (IOException e) {
                    throw ErrorHandler.parseToJsonError();
                }

            }

        }
        return builder.build().encode().toUri();
    }

    /**
     * 对参数进行encode
     *
     * @param params
     * @return
     * @throws DangjianException
     */
    public static String encodeParameters(Map<String, Object> params) throws DangjianException {
        StringBuilder buf = new StringBuilder();
        int j = 0;
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            if (j != 0) {
                buf.append("&");
            }
            j++;
            try {
                buf.append(URLEncoder.encode(entry.getKey(), CHARSET)).append("=").append(convertObject(entry.getValue()));
            } catch (java.io.UnsupportedEncodingException ex) {
                throw ErrorHandler.encodingError();
            } catch (IOException e) {
                throw ErrorHandler.parseToJsonError();
            }
        }
        return buf.toString();
    }

    /**
     * 对Object类型对象进行转换
     *
     * @param object
     * @return
     * @throws IOException
     */
    private static String convertObject(Object object) throws IOException {
        if (object instanceof IValueObject || object instanceof Collection) {
            return FastJsonConverter.toJSONStr(object);
        } else {
            return String.valueOf(object);
        }
    }
}
