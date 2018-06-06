package cn.dlbdata.dangjian.admin.dao.vo;

import java.util.Date;

public class PScorePartyVo {
	private Float score;
	private Date scoreTime;
	private String title;
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public Date getScoreTime() {
		return scoreTime;
	}
	public void setScoreTime(Date scoreTime) {
		this.scoreTime = scoreTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
