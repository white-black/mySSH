package service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;
import entity.BBSBoard;
import entity.BBSTip;
import entity.BBSUser;

@Service("bbsTipService")
@Transactional
public class BBSTipServiceImpl extends BaseServiceImpl<BBSTip> implements BBSTipService{
	private BaseDao<BBSTip> dao;
	@Resource(name="bbstipdao")
	public void setDao(BaseDao<BBSTip> dao){
		super.setDao(dao);
		this.dao = dao;
	}
	public void save(String title,String content){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		BBSTip tip = new BBSTip();
		tip.setTitle(title);
		tip.setContent(content);
		
		tip.setUser((BBSUser) session.getAttribute("user"));
		tip.setBoard((BBSBoard) session.getAttribute("board"));
		dao.merge(tip);
	}
}
