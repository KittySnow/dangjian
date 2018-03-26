package cn.dlbdata.dangjian.common.rest;

import cn.dlbdata.dangjian.common.DangjianException;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @Author: linfujun
 * @Description: 封装了Http REST 请求
 * @Date: Created on 10:56 2018/2/26
 */
public interface HttpWebApi {

    /**
     * GET请求，可以传入参数也可以不传，返回解析好的实体类
     *
     * @param url          目标url
     * @param params       参数
     * @param responseType 返回实体类对象
     * @param <T>
     * @return
     */
    public <T> T getForObject(String url, Map<String, Object> params, Class<T> responseType) throws DangjianException;

    /**
     * GET请求，可以传入参数也可以不传，返回解析好的实体类
     *
     * @param url          目标url
     * @param params       参数
     * @param headerParams header中的参数
     * @param responseType 返回实体类对象
     * @param <T>
     * @return
     * @throws DangjianException
     */
    public <T> T getForObject(String url, Map<String, Object> params, Map<String, String> headerParams, Class<T> responseType) throws DangjianException;

    /**
     * GET请求，传入参数，返回解析好的实体类列表
     *
     * @param url
     * @param params
     * @param listElementType
     * @return
     */
    public List getForObjectList(String url, Map<String, Object> params, Type listElementType) throws DangjianException;

    /**
     * POST请求，带传参，返回解析好的实体类
     *
     * @param url
     * @param params
     * @param responseType
     * @param <TResponse>
     * @return
     */
    public <TRequest, TResponse> TResponse postForObject(String url, TRequest params, Class<TResponse> responseType) throws DangjianException;
}
