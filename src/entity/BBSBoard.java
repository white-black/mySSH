package entity;

import java.util.HashSet;
import java.util.Set;

public class BBSBoard {
	private int boardId;
	private String boardname;
	private int parentId;
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	private Set<BBSTip> tips = new HashSet<BBSTip>();
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	
	public Set<BBSTip> getTips() {
		return tips;
	}
	public void setTips(Set<BBSTip> tips) {
		this.tips = tips;
	}
	
}
