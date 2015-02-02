package com.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.util.ObjUtil;

@Repository
public class BaseDao {

	@Resource
	private JdbcTemplate jdbcTemplateEx;

	@Resource
	private SessionFactory sessionFactory;

	public Session openSession() {
		return sessionFactory.openSession();
	}

	public Object get(Class<?> cls, Serializable id) {
		return openSession().get(cls, id);
	}

	public Object load(Class<?> cls, Serializable id) {
		return openSession().load(cls, id);
	}

	public void saveOrUpdate(Object o) {
		if (o != null)
			openSession().saveOrUpdate(o);
	}

	public void delete(Object o) {
		if (o != null)
			openSession().delete(o);
	}

	public void deleteAll(Collection<?> entities) {
		if (!ObjUtil.isNullOrEmpty(entities)) {
			for (Object o : entities) {
				openSession().delete(o);
			}
		}
	}

	public List<?> findMany(String sql) {
		Query query = openSession().createQuery(sql);
		return query.list();
	}

	public List<?> findMany(String sql, Object[] values) {
		Query query = openSession().createQuery(sql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.list();
	}

	public List<?> findMany(String sql, int limit, int page) {
		Query query = openSession().createQuery(sql);
		query.setFirstResult((page - 1) * limit);
		query.setMaxResults(limit);
		return query.list();
	}

	public List<?> findMany(String sql, int limit, int page, Object[] values) {
		Query query = openSession().createQuery(sql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.setFirstResult((page - 1) * limit);
		query.setMaxResults(limit);
		return query.list();
	}

	public int count(String sql) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select count(*) ").append(sql);
		List<?> list = this.findMany(sql);
		return ((Long) list.get(0)).intValue();
	}

	public int count(String sql, Object[] values) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select count(*) ").append(sql);
		List<?> list = this.findMany(sql, values);
		return ((Long) list.get(0)).intValue();
	}

	public int update(String sql) {
		return jdbcTemplateEx.update(sql);
	}

	public List<?> queryMany(String sql) {
		return jdbcTemplateEx.queryForList(sql);
	}

	public List<?> queryMany(String sql, Object[] values) {
		return jdbcTemplateEx.queryForList(sql, values);
	}

	public List<?> queryMany(String sql, int limit, int page) {
		return this.queryMany(sql, limit, page, null);
	}

	public List<?> queryMany(String sql, int limit, int page, Object[] values) {
		int first = (page - 1) * limit;
		String str = sql + " limit " + first + "," + limit;
		return jdbcTemplateEx.queryForList(str, values);
	}

	@SuppressWarnings("deprecation")
	public int queryCount(String sql) {
		return jdbcTemplateEx.queryForInt(sql);
	}

	@SuppressWarnings("deprecation")
	public int queryCount(String sql, Object[] values) {
		return jdbcTemplateEx.queryForInt(sql, values);
	}
}
