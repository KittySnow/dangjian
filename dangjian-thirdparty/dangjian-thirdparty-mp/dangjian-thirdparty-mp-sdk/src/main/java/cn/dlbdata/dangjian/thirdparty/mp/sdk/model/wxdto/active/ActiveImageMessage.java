package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.active;

import com.yimi.mobile.common.ConstantUtil.WX_MSG_TYPE;

/**
 * 主动图片消息
 * 
 * @author Administrator
 *
 */
public class ActiveImageMessage extends ActiveBaseMessage {
	
	// 回复的消息内容
	private ActiveImage image;

	public ActiveImageMessage() {
		this.setMsgtype(WX_MSG_TYPE.image.toString());
	}

	public ActiveImage getImage() {
		return image;
	}

	public void setImage(ActiveImage image) {
		this.image = image;
	}

}
