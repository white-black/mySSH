package dao;

import org.springframework.stereotype.Repository;

import entity.BBSUser;

@Repository(value = "bbsuserdao")
public class BBSUserDaoImpl extends BaseDaoImpl<BBSUser> implements BBSUserDao{

}
