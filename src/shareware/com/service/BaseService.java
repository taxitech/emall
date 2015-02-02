package com.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaseDao;

@Service
public class BaseService {

	@Resource
	private BaseDao baseDao;

	public Object get(Class<?> cls, Serializable id) {
		return baseDao.get(cls, id);
	}

	public Object load(Class<?> cls, Serializable id) {
		return baseDao.load(cls, id);
	}

	public void saveOrUpdate(Object o) {
		baseDao.saveOrUpdate(o);
	}

	public void delete(Object o) {
		baseDao.delete(o);
	}

	public void deleteAll(Collection<?> entities) {
		baseDao.deleteAll(entities);
	}

	public List<?> findMany(String sql) {
		return baseDao.findMany(sql);
	}

	public List<?> findMany(String sql, Object[] values) {
		return baseDao.findMany(sql, values);
	}

	public List<?> findMany(String sql, int limit, int page) {
		return baseDao.findMany(sql, limit, page);
	}

	public List<?> findMany(String sql, int limit, int page, Object[] values) {
		return baseDao.findMany(sql, limit, page, values);
	}

	public int count(String sql) {
		return baseDao.count(sql);
	}

	public int count(String sql, Object[] values) {
		return baseDao.count(sql, values);
	}

	public int update(String sql) {
		return baseDao.update(sql);
	}

	public List<?> queryMany(String sql) {
		return baseDao.queryMany(sql);
	}

	public List<?> queryMany(String sql, Object[] values) {
		return baseDao.queryMany(sql, values);
	}

	public List<?> queryMany(String sql, int limit, int page) {
		return baseDao.queryMany(sql, limit, page);
	}

	public List<?> queryMany(String sql, int limit, int page, Object[] values) {
		return baseDao.queryMany(sql, limit, page, values);
	}

	public int queryCount(String sql) {
		return baseDao.queryCount(sql);
	}

	public int queryCount(String sql, Object[] values) {
		return baseDao.queryCount(sql, values);
	}
}
