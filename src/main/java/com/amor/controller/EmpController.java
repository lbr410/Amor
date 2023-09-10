package com.amor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amor.emp.model.EmpDAO;
import com.amor.emp.model.EmpDTO;

@Controller
public class EmpController {
	@Autowired
	private EmpDAO empDao;
	
	@RequestMapping("emp.do")
	public String emp() {
		return "emp/emp";
	}
	
	@RequestMapping("empAdd.do")
	public ModelAndView empAdd(EmpDTO dto) {
		int result = empDao.EmpAdd(dto);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("emp/emp");
		
		return mav;
	}
}