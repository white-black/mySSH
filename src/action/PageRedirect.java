package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
@Controller("pageRedirect")
public class PageRedirect {
	HttpServletRequest request = null;
	String requestPath = null;
	HttpSession session = null;
	HttpServletResponse response = null;
	PrintWriter out;
	public void afterRequest(){
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		requestPath=request.getHeader("referer");
		session.setAttribute("requestPath", requestPath);
		System.out.println(requestPath);
		/*response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//out.print("<script>window.location.href='"+requestPath+"'</script>");
*/	}
}
