package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.group;

import com.yimi.mobile.common.ConstantUtil.WX_MSG_TYPE;

/**
 * 主动文本消息
 * 
 * @author Administrator
 *
 */
public class GroupNewsMessage extends GroupBaseMessage {
	
	// 回复的消息内容
	private GroupNews mpnews;

	public GroupNewsMessage() {
		this.setMsgtype(WX_MSG_TYPE.mpnews.toString());
	}

	public GroupNews getMpnews() {
		return mpnews;
	}

	public void setMpnews(GroupNews mpnews) {
		this.mpnews = mpnews;
	}

}
