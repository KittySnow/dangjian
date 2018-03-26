package cn.dlbdata.dangjian.thirdparty.mp.sdk.service.impl;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.CustomMenuService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.SendOutMobileMessageService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.TokenBasedService;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Service;

public class SendOutMobileMessageServiceImpl extends TokenBasedService implements SendOutMobileMessageService {

    @Override
    public String sendOutTextGroupMessage(Map<String, String> map, String content) {
        // 获取对应微信id
        List<String> touser = this.getAttentionUserOpenId(map);
        if (touser == null || touser.size() == 0) {
            //logger.info("没有关注者,取消文本消息发送！");
            return "{\"errcode\":没有关注者,取消文本消息发送！}";
        }
        GroupTextMessage textMessage = new GroupTextMessage();
        textMessage.setTouser(touser);
        GroupText text = new GroupText();
        text.setContent(content);
        textMessage.setText(text);
        try {
            int pharmacyId = Integer.valueOf(map.get("pharmacyId"));
            String accessToken = mobileUserUserMapperBiz.getAccessToken(pharmacyId);
            JSONObject jsonObject = HttpUtil.httpPost(sendOutGroupURL+accessToken, textMessage);
            //logger.info("群发文本消息发送返回码："+jsonObject);
            return jsonObject.toString();
        } catch (Exception e) {
            //logger.error("群发文本消息失败："+e);
            return "{\"errcode\":消息发送失败！}";
        }
    }

    @Override
    public String sendOutImageGroupMessage(Map<String, String> map, String pid) {
        try {
            // 获取对应微信id
            List<String> touser = this.getAttentionUserOpenId(map);
            if (touser == null || touser.size() == 0) {
                logger.info("没有关注者,取消文本消息发送！");
                return "{\"errcode\":\"没有关注者,取消文本消息发送！\"}";
            }
            int pharmacyId = Integer.valueOf(map.get("pharmacyId"));
            String accessToken = mobileUserUserMapperBiz.getAccessToken(pharmacyId);
            MobileImg mobileImg = mobileImgMapperBiz.getMobileImgById(pid);
            String mediaId = mobileImgMapperBiz.updateMobileImgMediaId(mobileImg, accessToken);
            if (StringUtil.isBlank(mediaId)) {
                return "{\"errcode\":\"消息发送失败！\"}";
            }
            GroupImageMessage imageMessage = new GroupImageMessage();
            imageMessage.setTouser(touser);
            GroupImage image = new GroupImage();
            image.setMedia_id(mobileImg.getMediaId());
            imageMessage.setImage(image);
            JSONObject jsonObject = HttpUtil.httpPost(sendOutGroupURL+accessToken, imageMessage);
            logger.info("群发图片消息发送返回码："+jsonObject);
            return jsonObject.toString();
        } catch (Exception e) {
            logger.error("群发图片消息失败："+e);
            return "{\"errcode\":\"消息发送失败！\"}";
        }
    }

    @Override
    public String sendOutNewsGroupMessage(Map<String, String> map,
                                          String activeArticleid) {
        try {
            // 获取对应微信id
            List<String> touser = this.getAttentionUserOpenId(map);
            if (touser == null || touser.size() == 0) {
                logger.info("没有关注者,取消文本消息发送！");
                return "{\"errcode\":没有关注者,取消文本消息发送！}";
            }
            int pharmacyId = Integer.valueOf(map.get("pharmacyId"));
            MobileAtiveArticles mobileAtiveArticles = mobileAtiveArticlesMapperBiz.getMobileAtiveArticlesById(activeArticleid);
            if (mobileAtiveArticles == null) {
                throw new RuntimeException("不能获取图文 by id："+activeArticleid);
            }
            String mediaId = mobileAtiveArticlesMapperBiz.getMobileAtiveArticlesMediaId(mobileAtiveArticles, pharmacyId);
            if (StringUtil.isBlank(mediaId)) {
                logger.info("mediaId获取失败！");
                return "{\"errcode\":消息发送失败！}";
            }

            logger.error("mediaId----------"+mediaId);
            GroupNewsMessage newsMessage = new GroupNewsMessage();
            newsMessage.setTouser(touser);
            GroupNews mpnews = new GroupNews();
            mpnews.setMedia_id(mediaId);
            newsMessage.setMpnews(mpnews);
            String accessToken = mobileUserUserMapperBiz.getAccessToken(pharmacyId);
            logger.error("accessToken---------"+accessToken);
            JSONObject jsonObject = HttpUtil.httpPost(sendOutGroupURL + accessToken, newsMessage);
            if (jsonObject.getString("errcode") == null || jsonObject.getString("errcode").equals("0")) {
                logger.error("群发图文消息发送返回码："+jsonObject);
                return jsonObject.toString();
            } else {
                logger.error("群发图文消息发送失败："+jsonObject.getString("errcode"));
                throw new RuntimeException();
            }
        } catch (Exception e) {
            logger.error("群发图文消息失败："+e);
            return "{\"errcode\":消息发送失败！}";
        }
    }

    /**
     * 获取微信关注者openid
     *
     * @param map
     * @return
     */
    private List<String> getAttentionUserOpenId(Map<String, String> map) {
        List<String> touser = new ArrayList<String>();
        MobileWxAttentionUser mobileWxAttentionUser = new MobileWxAttentionUser();
        if (StringUtil.isNotBlank(map.get("groupId"))) {
            mobileWxAttentionUser.setGroupId(map.get("groupId"));
        }
        int sex = 0;
        if (StringUtil.isNotBlank(map.get("sex"))) {
            sex = Integer.valueOf(map.get("sex"));
        }
        if (sex != 0) {
            mobileWxAttentionUser.setSex(sex);
        }
        if (StringUtil.isNotBlank(map.get("pharmacyId"))) {
            mobileWxAttentionUser.setPharmacyId(Integer.valueOf(map.get("pharmacyId")));
        }
        mobileWxAttentionUser.setIsSubscribe(1);
        List<MobileWxAttentionUser> wxAttentionUserList = mobileWxAttentionUserMapperBiz.selectMobileWxAttentionUser(mobileWxAttentionUser);
        if (wxAttentionUserList == null || wxAttentionUserList.size() == 0) {
            return touser;
        }
        for (MobileWxAttentionUser mobileWxAttentionUser2 : wxAttentionUserList) {
            touser.add(mobileWxAttentionUser2.getOpenid());
        }
        return touser;
    }
}
