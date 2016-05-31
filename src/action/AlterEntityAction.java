package action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import service.BBSUserService;

import com.opensymphony.xwork2.ActionSupport;

import entity.BBSUser;
@Controller("alterEntity")
public class AlterEntityAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private BBSUser bbsuser;
	private BBSUserService us;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BBSUser getBbsuser() {
		return bbsuser;
	}
	public void setBbsuser(BBSUser bbsuser) {
		this.bbsuser = bbsuser;
	}
	public BBSUserService getUs() {
		return us;
	}
	@Resource(name="bbsUserService")
	public void setUs(BBSUserService us) {
		this.us = us;
	}
	public String toAlterUserPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		username = us.findById(id).getUsername();
		session.setAttribute("username", username);
		return SUCCESS;
	}
	public String alterUser(){
		BBSUser user = us.findById(id);
		user.setPassword(bbsuser.getPassword());
		us.update(user);		
		return SUCCESS;
	}
}
