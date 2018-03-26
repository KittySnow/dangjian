package cn.dlbdata.dangjian.thirdparty.mp.sdk.service;
// ======================================================================
//
//      Copyright (C) 北京国双科技有限公司
//                    http://www.gridsum.com
//
//      保密性声明：此文件属北京国双科技有限公司所有，仅限拥有由国双科技
//      授予了相应权限的人所查看和所修改。如果你没有被国双科技授予相应的
//      权限而得到此文件，请删除此文件。未得国双科技同意，不得查看、修改、
//      散播此文件。
//
//
// ======================================================================

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.http.annotations.AnnotationExplainer;
import cn.dlbdata.dangjian.common.rest.HttpWebApi;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseParam;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.BaseMpApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static cn.dlbdata.dangjian.common.http.ErrorHandler.missingRequiredParam;

public abstract class BaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    private HttpWebApi client;

    public BaseService(HttpWebApi client) {
        this.client = client;
    }

    protected <R extends BaseMpApiResponse, P extends BaseParam> R getResponse(String url, P param, Class<R> responseType) throws DangjianException {
        Map<String, Object> paramMap = AnnotationExplainer.explainParamMap(param);
        R response = client.getForObject(url, paramMap, responseType);
        return response;
    }

    protected <R extends BaseMpApiResponse, P extends BaseParam> R postEntity(String url, P param, Class<R> responseType) throws DangjianException {
        if (param == null) {
            LOGGER.error("==========创建的实体不能为空==========");
            throw missingRequiredParam();
        }
        Map<String, Object> paramMap = AnnotationExplainer.explainParamMap(param);
        return client.postForObject(url, paramMap, responseType);
    }

}
