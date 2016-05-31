package action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.BBSBoardService;
import service.BBSReplyService;
import service.BBSTipService;
import service.BBSUserService;

import entity.BBSBoard;
import entity.BBSReply;
import entity.BBSTip;
import entity.BBSUser;
@Controller("getEntity")
public class GetEntityAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int pageNumber;
	private int totalPage;
	private int pageSize;
	private String pageArg; //��ֵ���̨������棬��� �û���������ӹ���
	private int boardId;	
	private int tipId;
	private List<BBSUser> allUsers; //��̨���������û�
	private List<BBSTip> allTips;	//��̨������������
	private List<BBSBoard> allBoards; //��index����ʾ���
	private List<BBSTip> boardTips;	//��index��ת��tipҳ�������
	private List<BBSReply> tipReplys; //��tipҳ��ת��indexҳ�������
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
	
	public String getPageArg() {
		return pageArg;
	}
	public void setPageArg(String pageArg) {
		this.pageArg = pageArg;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getTipId() {
		return tipId;
	}
	public void setTipId(int tipId) {
		this.tipId = tipId;
	}
	public List<BBSUser> getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(List<BBSUser> allUsers) {
		this.allUsers = allUsers;
	}
	public List<BBSTip> getAllTips() {
		return allTips;
	}
	public void setAllTips(List<BBSTip> allTips) {
		this.allTips = allTips;
	}
	public List<BBSBoard> getAllBoards() {
		return allBoards;
	}
	public void setAllBoards(List<BBSBoard> allBoards) {
		this.allBoards = allBoards;
	}
	
	public List<BBSTip> getBoardTips() {
		return boardTips;
	}
	public void setBoardTips(List<BBSTip> boardTips) {
		this.boardTips = boardTips;
	}
	public List<BBSReply> getTipReplys() {
		return tipReplys;
	}
	public void setTipReplys(List<BBSReply> tipReplys) {
		this.tipReplys = tipReplys;
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
	//��̨����
	public String userManage(){
		pageArg="用户管理";
		String hql_user = "from BBSUser";
		allUsers = us.findByHQL(hql_user, pageNumber-1 , pageSize);
		return SUCCESS;
	}
	public String tipManage(){
		pageArg="帖子管理";
		String hql_tip = "from BBSTip";
		allTips = ts.findByHQL(hql_tip, pageNumber-1, pageSize);
		return SUCCESS;
	}
	//indexҳ��
	public String getBoards(){
		String hql_board = "from BBSBoard";
		allBoards = bs.findByHQL(hql_board, 0, 10);
		return SUCCESS;
	}
	//��indexҳ����ת��tipҳ��
	public String getTips(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		BBSBoard board = bs.findById(boardId);
		session.setAttribute("board", board);
		String hql_board_tip = "from BBSTip where boardId = "+boardId;
		boardTips =  ts.findByHQL(hql_board_tip, pageNumber-1, pageSize);
		return SUCCESS;
	}
	//��tipҳ��replyҳ��
	public String getReplys(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		BBSTip tip = ts.findById(tipId);
		session.setAttribute("tip", tip);
		String hql_tip_reply = "from BBSReply where tipId = "+tipId;
		tipReplys = rs.findByHQL(hql_tip_reply, pageNumber-1, pageSize);
		return SUCCESS;		
	}
}
