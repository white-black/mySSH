package entity;

import java.sql.Date;

public class BBSReply {
	private int replyId;
	private String title;
	private String content;
	private Date publishtime;
	private String realfile;
	private String makefile;
	private BBSUser user;
	private BBSTip tip;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	public String getRealfile() {
		return realfile;
	}
	public void setRealfile(String realfile) {
		this.realfile = realfile;
	}
	public String getMakefile() {
		return makefile;
	}
	public void setMakefile(String makefile) {
		this.makefile = makefile;
	}
	public BBSUser getUser() {
		return user;
	}
	public void setUser(BBSUser user) {
		this.user = user;
	}
	public BBSTip getTip() {
		return tip;
	}
	public void setTip(BBSTip tip) {
		this.tip = tip;
	}
	
}
