package cn.dlbdata.dangjian.thirdparty.mp.sdk.common.dispatcher;

import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.res.TextMessage;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.MessageUtil;

import java.util.Date;
import java.util.Map;

/**
 * ClassName: EventDispatcher
 * @Description: 事件消息业务分发器
 * @author XiaoJiu
 * @date 2017-10-18
 */

public class EventDispatcher {
    public static String processEvent(Map<String, String> map) {
    	
    	String openId = map.get("FromUserName"); //用户 openid
    	String mPid = map.get("ToUserName");   //公众号原始 ID
    	
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { //关注事件
            TextMessage txtMsg = new TextMessage();
			txtMsg.setToUserName(openId);
			txtMsg.setFromUserName(mPid);
			txtMsg.setCreateTime(new Date().getTime());
			txtMsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			txtMsg.setContent(DispatcherMessage.getMainMenu());
			return MessageUtil.textMessageToXml(txtMsg);
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { //取消关注事件
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { //扫描二维码事件
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { //位置上报事件
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { //自定义菜单点击事件

            TextMessage textMessage = new TextMessage();

            textMessage.setToUserName(openId);
            textMessage.setFromUserName(mPid);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            String eventKey = map.get("EventKey");

            String respContent = "";

            if (eventKey.equals("11")) {
                respContent = openId+"欢迎您访问陆家嘴金领驿站积分系统，<a href=\"http://dj.dlbdata.cn/?openId="+openId+"\">免密登录请点击</a>";
            } else if (eventKey.equals("12")) {
                respContent = "公交查询菜单项被点击！";
            } else if (eventKey.equals("13")) {
                respContent = "周边搜索菜单项被点击！";
            } else if (eventKey.equals("14")) {
                respContent = openId+"欢迎您访问陆家嘴金领驿站积分系统，<a href=\"http://dj.dlbdata.cn/?openId="+openId+"\">免密登录请点击</a>";
            } else if (eventKey.equals("21")) {
                respContent = openId+"欢迎您访问陆家嘴金领驿站积分系统，\n<a href=\"http://dj.dlbdata.cn/?openId="+openId+"\">免密登录请点击</a>";
            } else if (eventKey.equals("22")) {
                respContent = "经典游戏菜单项被点击！";
            } else if (eventKey.equals("23")) {
                respContent = "美女电台菜单项被点击！";
            } else if (eventKey.equals("24")) {
                respContent = "人脸识别菜单项被点击！";
            } else if (eventKey.equals("25")) {
                respContent = "聊天唠嗑菜单项被点击！";
            } else if (eventKey.equals("31")) {
                respContent = "Q友圈菜单项被点击！";
            } else if (eventKey.equals("32")) {
                respContent = "电影排行榜菜单项被点击！";
            } else if (eventKey.equals("33")) {
                respContent = "幽默笑话菜单项被点击！";
            }

            textMessage.setContent(respContent);
            return MessageUtil.textMessageToXml(textMessage);
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单 View 事件
        }

        return null;
    }
}
