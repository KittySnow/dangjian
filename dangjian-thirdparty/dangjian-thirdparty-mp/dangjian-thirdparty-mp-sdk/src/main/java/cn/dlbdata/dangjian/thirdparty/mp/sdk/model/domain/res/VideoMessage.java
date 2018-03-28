package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.domain.res;

/**
 * ClassName: VideoMessage
 * @Description: 视频消息
 * @author XiaoJiu
 * @date 2017-10-18
 */
public class VideoMessage extends BaseMessage{
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
}
