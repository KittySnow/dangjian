package cn.dlbdata.dangjian.common.rest;

import cn.dlbdata.dangjian.common.DangjianException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 15:44 2018/2/26
 */
@Component
public class RestTemplateHttpWebApi implements HttpWebApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpWebApi.class);
    @Autowired
    private RestTemplate restTemplate;

    /**
     * GET请求，可以传入参数也可以不传，返回解析好的实体类
     *
     * @param url          目标url
     * @param params       参数
     * @param responseType 返回实体类对象
     * @param <T>
     * @return
     */
    @Override
    public <T> T getForObject(String url, Map<String, Object> params, Class<T> responseType) throws DangjianException {

        URI uri = HttpParamUtil.formatUrlToUri(url, params);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        LOGGER.debug("GET url : {}", uri.toString());

        HttpEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, entity, responseType);
        return response.getBody();

    }

    @Override
    public <T> T getForObject(String url, Map<String, Object> params, Map<String, String> headerParams, Class<T> responseType) throws DangjianException {
        URI uri = HttpParamUtil.formatUrlToUri(url, params);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setAll(headerParams);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        LOGGER.debug("GET url : {}", uri.toString());

        HttpEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, entity, responseType);
        return response.getBody();
    }


    /**
     * GET请求，传入参数，返回解析好的实体类列表
     *
     * @param url          目标url
     * @param params       参数
     * @param listElementType
     * @return
     */
    @Override
    public List getForObjectList(String url, Map<String, Object> params, Type listElementType) throws DangjianException {
        Type[] types = new Type[1];
        types[0] = listElementType;
        ParameterizedTypeImpl parameterizedType = ParameterizedTypeImpl.make(List.class, types, List.class.getDeclaringClass());
        ParameterizedTypeReference<List> typeRef = new ParameterizedTypeReference<List>() {
            @Override
            public Type getType() {
                return parameterizedType;
            }
        };

        URI uri = HttpParamUtil.formatUrlToUri(url, params);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        LOGGER.debug("GET url : {}", uri.toString());

        ResponseEntity<List> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, typeRef);
        return responseEntity.getBody();
    }

    @Override
    public <TRequest, TResponse> TResponse postForObject(String url, TRequest params, Class<TResponse> responseType) throws DangjianException {
        ResponseEntity<TResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(params), responseType);
        return responseEntity.getBody();
    }
}
