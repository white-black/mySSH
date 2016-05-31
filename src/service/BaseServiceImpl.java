package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T> dao;
	@Resource
	public void setDao(BaseDao<T> dao){
		this.dao = dao;
	}
	@Override
	public void save(T entity) {
		dao.save(entity);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public T findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<T> findByHQL(String hql, int pageNumber, int pageSize) {
		return dao.findByHQL(hql, pageNumber , pageSize);
	}
	@Override
	public int getTotal(String hql) {
		return dao.getTotal(hql);
	}
	@Override
	public List<T> findBySQL(String sql, int pageNumber, int pageSize) {
		return dao.findBySQL(sql, pageNumber, pageSize);
	}
	@Override
	public List<T> findByHQL(String hql) {
		return dao.findByHQL(hql);
	}
	@Override
	public void merge(T entity) {
		dao.merge(entity);
	}
	
}
