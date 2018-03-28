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
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { //自定义菜单 View 事件
        }

        return null;
    }
}
