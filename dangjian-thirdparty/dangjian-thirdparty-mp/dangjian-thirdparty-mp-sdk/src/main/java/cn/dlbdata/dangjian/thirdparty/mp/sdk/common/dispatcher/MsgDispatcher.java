package cn.dlbdata.dangjian.thirdparty.mp.sdk.common.dispatcher;



import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.res.TextMessage;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.MessageUtil;

import java.util.Date;
import java.util.Map;

/**
 * ClassName: MsgDispatcher
 * @Description: 消息业务处理分发器
 * @author XiaoJiu
 * @date 2017-10-18
 */

public class MsgDispatcher {
    public static String processMessage(Map<String, String> map) throws Exception {
    	
	    	String openId = map.get("FromUserName"); //用户 openid
	    	String mPid = map.get("ToUserName");   //公众号原始 ID
	    	String content = map.get("Content");
	    	String msgType = map.get("MsgType");
        if (MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msgType)) { // 文本消息
        	TextMessage txtMsg = new TextMessage();
			txtMsg.setToUserName(openId);
			txtMsg.setFromUserName(mPid);
			txtMsg.setCreateTime(new Date().getTime());
			txtMsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        	if("1".equals(content)){
        		txtMsg.setContent(DispatcherMessage.getMovieMenu());
        	}
        	else if("2".equals(content)){
        		txtMsg.setContent(DispatcherMessage.getGoodsMenu());
        	}
        	else if("3".equals(content)){
        		txtMsg.setContent(DispatcherMessage.getChatMenu());
        	}
        	else if(content.startsWith("电影")){
        		//txtMsg.setContent(DispatcherMessage.getMovie(content));
        	}
        	else if(content.startsWith("聊天")){
        		//return DispatcherMessage.getChat(openId, mPid, content);
        	}
        	else {
        		txtMsg.setContent(DispatcherMessage.getMainMenu());
			}
        	return MessageUtil.textMessageToXml(txtMsg);
        	
        }

        if (MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(msgType)) { // 图片消息
            System.out.println("==============这是图片消息！");
        }

        if (MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(msgType)) { // 链接消息
            System.out.println("==============这是链接消息！");
        }

        if (MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(msgType)) { // 位置消息
            System.out.println("==============这是位置消息！");
        }

        if (MessageUtil.REQ_MESSAGE_TYPE_VIDEO.equals(msgType)) { // 视频消息
            System.out.println("==============这是视频消息！");
        }

        if (MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msgType)) { // 语音消息
            System.out.println("==============这是语音消息！");
        }

        return "";
    }
    
}