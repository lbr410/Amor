package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amor.ads.service.AdsService;

@Controller
public class AdsController {
	
	@Autowired
	private AdsService adsservice;

	@RequestMapping("admin/ads/adsList.do")
	public ModelAndView adsList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/ads/adsList");
		return mav;
	}
	
	@RequestMapping("admin/ads/adsAdd.do")
	public ModelAndView adsAdd() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/ads/adsAdd");
		return mav;
	}
	
	@RequestMapping("admin/ads/adsUpdate.do")
	public ModelAndView adsUpdate() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/ads/adsUpdate");
		return mav;
	}
	
	@RequestMapping("admin/ads/adsDelete.do")
	public ModelAndView adsDelete() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/ads/adsDelete");
		return mav;
	}
}
