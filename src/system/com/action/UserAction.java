package com.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.model.po.SysUser;
import com.service.UserService;

@Controller
@Namespace("/user")
@ParentPackage("struts-default")
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Resource
	private UserService userService;

	@Action(value = "regUser", results = {
			@Result(name = "success", location = "/login.jsp"),
			@Result(name = "input", location = "/WEB-INF/view/system/user/error.jsp") })
	public String regUser() {
		try {
			SysUser user = (SysUser) this.get(SysUser.class, "1");
			System.out.println(user.getUserCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
