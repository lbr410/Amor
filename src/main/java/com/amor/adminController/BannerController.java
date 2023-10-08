package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amor.banner.model.BannerDTO;
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
	@RequestMapping(value="admin/banner/bannerAdd.do", method = RequestMethod.GET)
	public ModelAndView bannerAddForm(int banner_idx) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("banner_idx",banner_idx);
		mav.setViewName("admin/banner/bannerAdd");
		return mav;
	}
	
	
	@RequestMapping(value = "admin/banner/bannerAdd.do", method=RequestMethod.POST)
	public ModelAndView bannerAddSubmit(BannerDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = bannerservice.bannerAdd(dto);
		String msg = result > 0 ? "성공":"실패";
		mav.addObject("msg", msg);
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/banner/bannerUpdate.do")
	public ModelAndView bannerUpdate() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/banner/bannerUpdate");
		return mav;
	}
	
	@RequestMapping("admin/banner/bannerDelete.do")
	public ModelAndView bannerDelete() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/banner/bannerDelete");
		return mav;
	}
}
