package com.action;

import java.io.Serializable;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.service.BaseService;
import com.util.ExcelUtil;
import com.util.ObjUtil;

@Controller
public class BaseAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	@Resource
	private BaseService baseService;

	public Object get(Class<?> cls, Serializable id) {
		return baseService.get(cls, id);
	}

	public Object load(Class<?> cls, Serializable id) {
		return baseService.load(cls, id);
	}

	public void saveOrUpdate(Object o) {
		baseService.saveOrUpdate(o);
	}

	public void delete(Object o) {
		baseService.delete(o);
	}

	public void deleteAll(Collection<?> entities) {
		baseService.deleteAll(entities);
	}

	public List<?> findMany(String sql) {
		return baseService.findMany(sql);
	}

	public List<?> findMany(String sql, Object[] values) {
		return baseService.findMany(sql, values);
	}

	public List<?> findMany(String sql, int limit, int page) {
		return baseService.findMany(sql, limit, page);
	}

	public List<?> findMany(String sql, int limit, int page, Object[] values) {
		return baseService.findMany(sql, limit, page, values);
	}

	public int count(String sql) {
		return baseService.count(sql);
	}

	public int count(String sql, Object[] values) {
		return baseService.count(sql, values);
	}

	public int update(String sql) {
		return baseService.update(sql);
	}

	public List<?> queryMany(String sql) {
		return baseService.queryMany(sql);
	}

	public List<?> queryMany(String sql, Object[] values) {
		return baseService.queryMany(sql, values);
	}

	public List<?> queryMany(String sql, int limit, int page) {
		return baseService.queryMany(sql, limit, page);
	}

	public List<?> queryMany(String sql, int limit, int page, Object[] values) {
		return baseService.queryMany(sql, limit, page, values);
	}

	public int queryCount(String sql) {
		return baseService.queryCount(sql);
	}

	public int queryCount(String sql, Object[] values) {
		return baseService.queryCount(sql, values);
	}

	public HashMap<String, Object> convertParams(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String o = e.nextElement();
			map.put(o, request.getParameter(o.toString()));
		}
		return map;
	}

	public void export(HttpServletRequest request,
			HttpServletResponse response, Collection<?> collections)
			throws Exception {
		HashMap<String, Object> params = this.convertParams(request);
		String hs = ObjUtil.strValue(params.get("headers"));
		String[] headers = hs.split(",");
		String fs = ObjUtil.strValue(params.get("fields"));
		String[] fields = fs.split(",");
		response.reset();
		response.addHeader("Content-Disposition",
				"attachment;filename=export.xls");
		response.setContentType("application/download");
		ExcelUtil.exportExcel(headers, fields, collections,
				response.getOutputStream());
		response.flushBuffer();
	}

}
