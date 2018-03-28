package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.res;

/**
 * ClassName: TextMessage
 * @Description: 文本消息消息体
 * @author XiaoJiu
 * @date 2017-10-18
 */
public class TextMessage extends BaseMessage {
	// 回复的消息内容   
    private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}  
}
