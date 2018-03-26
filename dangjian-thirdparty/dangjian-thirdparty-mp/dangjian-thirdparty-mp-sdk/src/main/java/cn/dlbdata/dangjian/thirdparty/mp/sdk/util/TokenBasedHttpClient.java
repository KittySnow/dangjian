package cn.dlbdata.dangjian.thirdparty.mp.sdk.util;

import cn.dlbdata.dangjian.common.IValueObject;
import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.rest.HttpParamUtil;
import cn.dlbdata.dangjian.common.rest.HttpWebApi;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.common.AccessTokenProvider;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static cn.dlbdata.dangjian.common.http.ErrorHandler.missingRequiredParam;


/**
 * @Author: linfujun
 * @Description: Http客户端，带oauth2的token
 * @Date: Created on 18:07 2017/12/27
 */
@Component
public class TokenBasedHttpClient {

    private final HttpWebApi httpWebApi;

    private AccessTokenProvider accessTokenProvider;

    public TokenBasedHttpClient(AccessTokenProvider accessTokenProvider, HttpWebApi httpWebApi) {
        this.accessTokenProvider = accessTokenProvider;
        this.httpWebApi = httpWebApi;
    }

    protected boolean hasAccessTokenProviderBeenSet() {
        return !Objects.isNull(accessTokenProvider);
    }

    public <T extends IValueObject> T getResponseInJson(String url, Map<String, Object> params, Class<T> responseType) throws DangjianException {
        params = appendAccessTokenToParam(params);
        return httpWebApi.getForObject(url, params, responseType);
    }

    public <T extends IValueObject> T postEncodeEntryAndResponseInJson(String url, Map<String, Object> params, Class<T> responseType) throws DangjianException {
        Map<String, Object> tokenParam = new HashMap<>(3);
        tokenParam = appendAccessTokenToParam(tokenParam);
        String formatUrl = HttpParamUtil.formatUrl(url, tokenParam);
        return httpWebApi.postForObject(formatUrl, params, responseType);
    }

    public <T extends IValueObject> T postAtomEntity(String url, Object param, Class<T> responseType) throws DangjianException {
        Map<String, Object> tokenParam = new HashMap<>(3);
        tokenParam = appendAccessTokenToParam(tokenParam);
        String formatUrl = HttpParamUtil.formatUrl(url, tokenParam);
        return httpWebApi.postForObject(formatUrl, param, responseType);
    }

    public <T extends IValueObject> T postMultipartEntryWithFile(String url, Map<String, Object> params, String fileKey, File file, Class<T> responseType) throws DangjianException {
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        MultiValueMap<String, Object> multiParams = new LinkedMultiValueMap<>();
        multiParams.add(fileKey, fileSystemResource);
        params.forEach((key, value)->multiParams.add(key, value));

        Map<String, Object> tokenParam = new HashMap<>(3);
        tokenParam = appendAccessTokenToParam(tokenParam);
        String formatUrl = HttpParamUtil.formatUrl(url, tokenParam);
        return  httpWebApi.postForObject(formatUrl,multiParams,responseType);
    }

    protected Map<String, Object> appendAccessTokenToParam(Map<String, Object> params) throws DangjianException {
        if (!hasAccessTokenProviderBeenSet()) {
            throw ErrorHandler.accessTokenNotSet();
        }
        String accessToken = accessTokenProvider.getAccessToken();
        params.put("access_token", accessToken);
        return params;
    }

}
