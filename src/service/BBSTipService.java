package service;

import entity.BBSTip;

public interface BBSTipService extends BaseService<BBSTip>{
	public void save(String title,String content);
}
