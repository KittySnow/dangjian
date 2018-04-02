package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.http.annotations.AnnotationExplainer;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseParam;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseMpApiResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.TokenBasedHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;
import static cn.dlbdata.dangjian.common.http.ErrorHandler.missingRequiredParam;

/**
 * @Author: linfujun
 * @Description: 服务基类
 * @Date: Created on 18:24 2017/12/13
 */
public abstract class TokenBasedService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenBasedService.class);

    private TokenBasedHttpClient client;

    public TokenBasedService(TokenBasedHttpClient client) {
        this.client = client;
    }

    protected <R extends BaseMpApiResponse, P extends BaseParam> R getResponse(String url, P param, Class<R> responseType) throws DangjianException {
        if (param == null) {
            LOGGER.error("Get entity param cannot be null.");
            throw missingRequiredParam();
        }
        Map<String, Object> paramMap = AnnotationExplainer.explainParamMap(param);
        R response = client.getResponseInJson(url, paramMap, responseType);
        return response;
    }

    protected <R extends BaseMpApiResponse, P> R getAtomEntity(String url, P param, Class<R> responseType) throws DangjianException {
        if (param == null) {
            LOGGER.error("Get entity param cannot be null.");
            throw missingRequiredParam();
        }
        Map<String, Object> paramMap = AnnotationExplainer.explainParamMap(param);
        R response = client.getResponseInJson(url, paramMap, responseType);
        return response;
    }



    protected <R extends BaseMpApiResponse, P extends BaseParam> R postEntity(String url, P param, Class<R> responseType) throws DangjianException {
        if (param == null) {
            LOGGER.error("Post entity param cannot be null.");
            throw missingRequiredParam();
        }
        Map<String, Object> paramMap = AnnotationExplainer.explainParamMap(param);
        return client.postEncodeEntryAndResponseInJson(url, paramMap, responseType);
    }

    protected <R extends BaseMpApiResponse, P> R postAtomEntity(String url, P param, Class<R> responseType) throws DangjianException {
        if (param == null) {
            LOGGER.error("Post entity param cannot be null.");
            throw missingRequiredParam();
        }
        return client.postAtomEntity(url, param, responseType);
    }
}


