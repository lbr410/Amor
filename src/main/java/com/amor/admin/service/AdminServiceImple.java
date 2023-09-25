package com.amor.admin.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amor.admin.model.*;

public class AdminServiceImple implements AdminService {

	private AdminDAO adminDao;
	
	public AdminServiceImple(AdminDAO adminDao) {
		super();
		this.adminDao = adminDao;
	}


	@Override
	public Boolean adminLogin(AdminDTO dto) {
		Boolean result = adminDao.adminConection(dto);
		return result;
	}
}
