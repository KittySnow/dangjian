package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.req;

/**
 * ClassName: ImageMessage
 * @Description: 图片消息
 * @author XiaoJiu
 * @date 2017-10-18
 */
public class ImageMessage extends BaseMessage{
	// 图片链接
    private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
}
