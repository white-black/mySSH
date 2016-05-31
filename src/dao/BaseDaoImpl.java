package dao;

import java.util.List;
import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class<T> clazz;
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	@Resource
	private SessionFactory sessionFactory;
	private Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public void save(T entity) {
		this.getSession().save(entity);
	}
	@Override
	public void update(T entity) {
		this.getSession().update(entity);
	}

	@Override
	public void delete(Integer id) {
		if(findById(id) != null){
			this.getSession().delete(this.findById(id));			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Integer id) {
		return (T) this.getSession().get(this.clazz, id);
	}

	@Override
	public List<T> findByHQL(String hql, int pageNumber, int pageSize) {
		Query query = this.getSession().createQuery(hql);
		query.setFirstResult(pageNumber * pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	@Override
	public int getTotal(String hql) {
		int total = 0;
		Query query = this.getSession().createQuery(hql);
		total = ((Long)query.iterate().next()).intValue();
		return total;
	}
	@Override
	public List<T> findBySQL(String sql, int pageNumber, int pageSize) {
		Query query = this.getSession().createSQLQuery(sql);
		query.setFirstResult(pageNumber * pageSize);
		query.setMaxResults(pageSize);
		
		return query.list();
	}
	@Override
	public List<T> findByHQL(String hql) {
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}
	@Override
	public void merge(T entity) {
		this.getSession().merge(entity);
	}
	
}
