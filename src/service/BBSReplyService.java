package service;

import entity.BBSReply;

public interface BBSReplyService extends BaseService<BBSReply>{
	public void save(String title,String content);
}
