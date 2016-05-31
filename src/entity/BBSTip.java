package entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class BBSTip {
	private int tipId;
	private String title;
	private String content;
	private Date publishtime;
	private String realfile;
	private String makefile;
	private BBSUser user;
	private BBSBoard board;
	private Set<BBSReply> replys = new HashSet<BBSReply>();
	public int getTipId() {
		return tipId;
	}
	public void setTipId(int tipId) {
		this.tipId = tipId;
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
	public BBSBoard getBoard() {
		return board;
	}
	public void setBoard(BBSBoard board) {
		this.board = board;
	}
	public Set<BBSReply> getReplys() {
		return replys;
	}
	public void setReplys(Set<BBSReply> replys) {
		this.replys = replys;
	}	
}
