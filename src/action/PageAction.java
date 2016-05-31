package action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import service.BBSBoardService;
import service.BBSReplyService;
import service.BBSTipService;
import service.BBSUserService;

import com.opensymphony.xwork2.ActionSupport;


@Controller("page")
public class PageAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int pageNumber;
	private int totalPage;
	private int pageSize;
	private int boardId;	//从index.jsp页面传过来(到tip.jsp中)
	private String boardname;
	private int tipId;	//从tip.jsp页面中传过来(到reply.jsp中)
	private String tipTitle;
	private BBSBoardService bs;
	private BBSUserService us;
	private BBSTipService ts;
	private BBSReplyService rs;
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getTipTitle() {
		return tipTitle;
	}
	public void setTipTitle(String tipTitle) {
		this.tipTitle = tipTitle;
	}
	public int getTipId() {
		return tipId;
	}
	public void setTipId(int tipId) {
		this.tipId = tipId;
	}
	public BBSBoardService getBs() {
		return bs;
	}
	@Resource(name="bbsBoardService")
	public void setBs(BBSBoardService bs) {
		this.bs = bs;
	}
	public BBSUserService getUs() {
		return us;
	}
	@Resource(name="bbsUserService")
	public void setUs(BBSUserService us) {
		this.us = us;
	}
	public BBSTipService getTs() {
		return ts;
	}
	@Resource(name="bbsTipService")
	public void setTs(BBSTipService ts) {
		this.ts = ts;
	}
	public BBSReplyService getRs() {
		return rs;
	}
	@Resource(name="bbsReplyService")
	public void setRs(BBSReplyService rs) {
		this.rs = rs;
	}
	public String userManage(){
		pageSize = 3;
		String hql = "select count(*) from BBSUser";
		int userTotal = us.getTotal(hql);
		this.totalPage = userTotal % pageSize == 0 ?(userTotal/pageSize):
			(userTotal/pageSize +1);
		if(this.pageNumber <= 0){
			this.pageNumber = 1;
		}
		if(this.pageNumber > totalPage){
			this.pageNumber = totalPage;
		}
		return SUCCESS;
	}
	public String tipManage(){
		pageSize = 3;
		String hql = "select count(*) from BBSTip";
		int tipTotal = ts.getTotal(hql);
		this.totalPage = tipTotal % pageSize == 0 ?(tipTotal/pageSize):
			(tipTotal/pageSize +1);
		if(this.pageNumber <= 0){
			this.pageNumber = 1;
		}
		if(this.pageNumber > totalPage){
			this.pageNumber = totalPage;
		}
		return SUCCESS;
	}
	public String indexToTip(){
		pageSize = 3;
		String hql = "select count(*) from BBSTip  where boardId = "+boardId;
		int tipTotal = ts.getTotal(hql);
		this.totalPage = tipTotal % pageSize == 0 ?(tipTotal/pageSize):
			(tipTotal/pageSize +1);
		if(this.pageNumber <= 0){
			this.pageNumber = 1;
		}
		if(this.pageNumber > totalPage){
			this.pageNumber = totalPage;
		}
		return SUCCESS;
	}
	public String tipToReply(){
		
		pageSize = 3;
		String hql = "select count(*) from BBSReply where tipId = "+tipId;
		int replyTotal = rs.getTotal(hql);
		this.totalPage = replyTotal % pageSize == 0 ?(replyTotal/pageSize):
			(replyTotal/pageSize +1);
		if(this.pageNumber <= 0){
			this.pageNumber = 1;
		}
		if(this.pageNumber > totalPage){
			this.pageNumber = totalPage;
		}
		return SUCCESS;
	}
}
