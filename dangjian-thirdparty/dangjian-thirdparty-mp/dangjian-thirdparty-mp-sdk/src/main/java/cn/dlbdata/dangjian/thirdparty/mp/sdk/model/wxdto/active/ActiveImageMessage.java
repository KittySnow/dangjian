package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.wxdto.active;


import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common.ConstantUtil;

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
		this.setMsgtype(ConstantUtil.WX_MSG_TYPE.image.toString());
	}

	public ActiveImage getImage() {
		return image;
	}

	public void setImage(ActiveImage image) {
		this.image = image;
	}

}
