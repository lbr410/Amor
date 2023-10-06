package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amor.banner.service.BannerService;

@Controller
public class BannerController {

	@Autowired
	private BannerService bannerservice;
	
	@RequestMapping("admin/banner/bannerList.do")
	public ModelAndView bannerList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/banner/bannerList");
		return mav;
	}
	
	@RequestMapping("admin/banner/bannerAdd.do")
	public ModelAndView bannerAdd() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/banner/bannerAdd");
		return mav;
	}
	
	@RequestMapping("admin/banner/bannerUpdate.do")
	public ModelAndView bannerUpdate() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/banner/bannerAdd");
		return mav;
	}
	
	@RequestMapping("admin/banner/bannerDelete.do")
	public ModelAndView bannerDelete() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/banner/bannerDelete");
		return mav;
	}
}
