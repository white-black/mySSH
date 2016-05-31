package service;

import java.util.List;

public interface BaseService<T> {
	public void save(T entity);
	public void update(T entity);
	public void delete(Integer id);
	public void merge(T entity);
	public T findById(Integer id);
	public List<T> findByHQL(String hql,int pageNumber, int pageSize);
	public List<T> findByHQL(String hql);
	public List<T> findBySQL(String sql,int pageNumber, int pageSize);
	public int getTotal(String hql);
}
