package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;

import entity.BBSUser;
@Service("bbsUserService")
@Transactional
public class BBSUserServiceImpl extends BaseServiceImpl<BBSUser> implements BBSUserService{
	@Resource(name="bbsuserdao")
	public void setDao(BaseDao<BBSUser> dao){
		super.setDao(dao);
	}
}
