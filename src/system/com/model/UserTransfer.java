package com.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.model.po.SysUser;
import com.model.vo.SysUserVo;
import com.util.ObjUtil;

public class UserTransfer {

	public static List<SysUserVo> poToVo(Collection<SysUser> poList) {
		List<SysUserVo> voList = new ArrayList<SysUserVo>();
		if (!ObjUtil.isNullOrEmpty(poList)) {
			Iterator<SysUser> it = poList.iterator();
			while (it.hasNext()) {
				SysUser po = it.next();
				voList.add(poToVo(po));
			}
		}
		return voList;
	}

	public static SysUserVo poToVo(SysUser po) {
		SysUserVo vo = new SysUserVo();
		if (!ObjUtil.isNullOrEmpty(po)) {
			vo.setUserId(po.getUserId());
			vo.setUserCode(po.getUserCode());
			vo.setUserName(po.getUserName());
			vo.setPassword(po.getPassword());
			vo.setCreateDate(po.getCreateDate());
		}
		return vo;
	}
	

	public static List<SysUser> voToPo(Collection<SysUserVo> voList) {
		List<SysUser> poList = new ArrayList<SysUser>();
		if (!ObjUtil.isNullOrEmpty(voList)) {
			Iterator<SysUserVo> it = voList.iterator();
			while (it.hasNext()) {
				SysUserVo vo = it.next();
				poList.add(voToPo(vo));
			}
		}
		return poList;
	}

	public static SysUser voToPo(SysUserVo vo) {
		SysUser po = new SysUser();
		if (!ObjUtil.isNullOrEmpty(vo)) {
			po.setUserId(vo.getUserId());
			po.setUserCode(vo.getUserCode());
			po.setUserName(vo.getUserName());
			po.setPassword(vo.getPassword());
			po.setCreateDate(vo.getCreateDate());
		}
		return po;
	}
}
