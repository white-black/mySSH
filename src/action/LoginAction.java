package action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.BBSUserService;
import entity.BBSUser;
@Controller("login")
public class LoginAction extends ActionSupport{
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
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestPathAll=request.getHeader("referer");
		String requestPath = requestPathAll.substring(requestPathAll.indexOf("ssh/")+4);
		HttpSession session = request.getSession();
		session.setAttribute("requestPath", requestPath);
		String hql = "from BBSUser";
		List<BBSUser> userFromDBs = bus.findByHQL(hql);
		for(BBSUser bbsuser : userFromDBs){
			if(bbsuser.getUsername().equals(user.getUsername()) && bbsuser.getPassword().equals(user.getPassword())){
				session.setAttribute("user", bbsuser);
				return SUCCESS;
			}
		} 
		return INPUT;		  
	}
}
