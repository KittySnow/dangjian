package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.req;

/**
 * ClassName: VoiceMessage
 * @Description: 语音消息
 * @author XiaoJiu
 * @date 2017-10-18
 */
public class VoiceMessage extends BaseMessage {
	// 媒体 ID   
    private String MediaId;  
    // 语音格式   
    private String Format;
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}  
}
