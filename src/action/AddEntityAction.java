package action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import service.BBSReplyService;
import service.BBSTipService;
import service.BBSUserService;

import com.opensymphony.xwork2.ActionSupport;

import entity.BBSReply;
import entity.BBSTip;
import entity.BBSUser;
@Controller("addEntity")
public class AddEntityAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private BBSTip tip;
	private BBSTipService ts;
	private BBSReply reply;
	private BBSReplyService rs;
	private BBSUser user;
	private BBSUserService us;
	public BBSTip getTip() {
		return tip;
	}
	public void setTip(BBSTip tip) {
		this.tip = tip;
	}
	public BBSTipService getTs() {
		return ts;
	}
	@Resource(name="bbsTipService")
	public void setTs(BBSTipService ts) {
		this.ts = ts;
	}
	public BBSReply getReply() {
		return reply;
	}
	public void setReply(BBSReply reply) {
		this.reply = reply;
	}
	public BBSReplyService getRs() {
		return rs;
	}
	@Resource(name="bbsReplyService")
	public void setRs(BBSReplyService rs) {
		this.rs = rs;
	}
	public BBSUser getUser() {
		return user;
	}
	public void setUser(BBSUser user) {
		this.user = user;
	}
	public BBSUserService getUs() {
		return us;
	}
	@Resource(name="bbsUserService")
	public void setUs(BBSUserService us) {
		this.us = us;
	}
	public String addTip(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String requestPathAll=request.getHeader("referer");
		String requestPath = requestPathAll.substring(requestPathAll.indexOf("ssh/")+4);
		session.setAttribute("requestPath", requestPath);
		ts.save(tip.getTitle(), tip.getContent());
		return SUCCESS;
	}
	public String addReply(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String requestPathAll=request.getHeader("referer");
		String requestPath = requestPathAll.substring(requestPathAll.indexOf("ssh/")+4);
		session.setAttribute("requestPath", requestPath);
		rs.save(reply.getTitle(), reply.getContent());
		return SUCCESS;
	}
}
