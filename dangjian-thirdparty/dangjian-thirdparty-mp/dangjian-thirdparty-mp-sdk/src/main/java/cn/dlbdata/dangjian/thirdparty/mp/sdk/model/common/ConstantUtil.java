package cn.dlbdata.dangjian.thirdparty.mp.sdk.model.common;

public class ConstantUtil {

	/**
	 * 移动类型
	 * 
	 * @author Administrator
	 * 
	 */
	public static enum MOBILE_TYPE {
		wx("微信"), ali("支付宝");

		private String name;

		MOBILE_TYPE(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}
	
// --------------------------------------------支付宝----------------------------------------------
	
	/**
	 * ali消息类型
	 * 
	 * @author lxl
	 * 
	 */
	public static enum ALI_MSG_TYPE {
		event("事件"), text("文本"), image("图片"), imagetext("image-text");

		private String name;

		ALI_MSG_TYPE(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	/**
	 * ali事件类型
	 * 
	 * @author lxl
	 * 
	 */
	public static enum ALI_EVENT_TYPE {
		follow("关注"), unfollow("取消关注"), enter("进入事件"), click("点击事件");

		private String name;

		ALI_EVENT_TYPE(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}
// --------------------------------------------支付宝----------------------------------------------
// --------------------------------------------微信----------------------------------------------
	/**
	 * 微信消息类型
	 * 
	 * @author lxl
	 * 
	 */
	public static enum WX_MSG_TYPE {
		text("文本"), image("图片"), voice("语音"), video("视频"), location("地理位置"), link(
				"链接"), event("事件"), music("音乐"), news("普通图文"), mpnews("群发图文");

		private String name;

		WX_MSG_TYPE(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	/**
	 * 微信事件类型
	 * 
	 * @author lxl
	 * 
	 */
	public static enum WX_EVENT_TYPE {
		subscribe("订阅"), unsubscribe("取消订阅"), SCAN("已关注"), LOCATION("地理位置"), CLICK(
				"点击菜单"), VIEW("跳转链接"),MASSSENDJOBFINISH("接收结果事件");

		private String name;

		WX_EVENT_TYPE(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}
	// --------------------------------------------微信----------------------------------------------
	
	public static enum IN_OR_OUT {
		in(1),out(2),vlue(0);
		
		private int inOrOut;
		
		IN_OR_OUT(int inOrOut) {
			this.inOrOut = inOrOut;
		}

		public int getInOrOut() {
			return inOrOut;
		}
		
	}
	
	public static enum isDelete {
		y(1),n(0);
		
		private int isDelete;
		
		isDelete(int isDelete) {
			this.isDelete = isDelete;
		}

		public int getIsDelete() {
			return isDelete;
		}
		
	}
	
}
