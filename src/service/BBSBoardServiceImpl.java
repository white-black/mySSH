package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;

import entity.BBSBoard;
@Service("bbsBoardService")
@Transactional
public class BBSBoardServiceImpl extends BaseServiceImpl<BBSBoard> implements BBSBoardService{
	@Resource(name="bbsboarddao")
	public void setDao(BaseDao<BBSBoard> dao){
		super.setDao(dao);
	}
}
