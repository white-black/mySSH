package action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import service.BBSTipService;
import service.BBSUserService;

import com.opensymphony.xwork2.ActionSupport;
@Controller("deleteEntity")
public class DeleteEntityAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int id;
	private BBSUserService us;
	private BBSTipService ts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String deleteUser(){
		us.delete(id);
		return SUCCESS;
	}
	public String deleteTip(){
		ts.delete(id);
		return SUCCESS;
	}
	
}
