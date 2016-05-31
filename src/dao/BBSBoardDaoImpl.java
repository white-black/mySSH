package dao;

import org.springframework.stereotype.Repository;

import entity.BBSBoard;
@Repository(value = "bbsboarddao")
public class BBSBoardDaoImpl extends BaseDaoImpl<BBSBoard> implements BBSBoardDao{

}
