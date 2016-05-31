package action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import service.BBSUserService;

import com.opensymphony.xwork2.ActionSupport;

import entity.BBSUser;
@Controller("register")
public class RegisterAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private BBSUser user;
	private BBSUserService bus;
	public BBSUser getUser() {
		return user;
	}
	public void setUser(BBSUser user) {
		this.user = user;
	}
	public BBSUserService getBus() {
		return bus;
	}
	@Resource(name="bbsUserService")
	public void setBus(BBSUserService bus) {
		this.bus = bus;
	}
	public String execute(){
		try {
			bus.save(user);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return INPUT;
	}
	public String toRegister(){
		return SUCCESS;
	}
}
