package service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;

import entity.BBSReply;
import entity.BBSTip;
import entity.BBSUser;
@Service("bbsReplyService")
@Transactional
public class BBSReplyServiceImpl extends BaseServiceImpl<BBSReply> implements BBSReplyService{
	private BaseDao<BBSReply> dao;
	@Resource(name="bbsreplydao")
	public void setDao(BaseDao<BBSReply> dao){
		super.setDao(dao);
		this.dao = dao;
	}
	public void save(String title,String content){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		BBSReply reply = new BBSReply();
		reply.setTitle(title);
		reply.setContent(content);
		reply.setUser((BBSUser) session.getAttribute("user"));
		reply.setTip((BBSTip) session.getAttribute("tip"));
		dao.merge(reply);
	}
}
