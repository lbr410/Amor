package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.amor.banner.model.BannerDTO;
import com.amor.banner.service.BannerService;

import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class BannerController {

	@Autowired
	private BannerService bannerservice;
	
	@RequestMapping("admin/banner/bannerList.do")
	public ModelAndView bannerList(HttpSession session, @CookieValue(value = "autologin", required = false)String autologin) {
		ModelAndView mav = new ModelAndView();
		
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			List<BannerDTO> lists = bannerservice.bannerList();
			String btnOk="";
			if(lists.size() == 2) {
				btnOk = "bothLock";
			}
			else if(lists.size() == 1) {
				if(lists.get(0).getBanner_idx() == 1) {
					btnOk = "mainLock";
				}else if(lists.get(0).getBanner_idx() == 2){
					btnOk = "sideLock";
				}
			}else if(lists.size() == 0) {
				btnOk = "bothOpen";
			}else {
				btnOk = "alreadyExists";
			}
			
			mav.addObject("btnOk",btnOk);
			mav.addObject("lists",lists);
			mav.setViewName("admin/banner/bannerList");
		}
		return mav;
	}
	@RequestMapping(value="admin/banner/bannerAdd.do", method = RequestMethod.GET)
	public ModelAndView bannerAddForm(int banner_idx, HttpSession session, @CookieValue(value = "autologin", required = false)String autologin) {
		ModelAndView mav = new ModelAndView();
		
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			mav.addObject("banner_idx",banner_idx);
			mav.setViewName("admin/banner/bannerAdd");
		}
		return mav;
	}
	
	
	@RequestMapping(value = "admin/banner/bannerAdd.do", method=RequestMethod.POST)
	public ModelAndView bannerAddSubmit(BannerDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = bannerservice.bannerAdd(dto);
		String msg = result > 0 ? "등록 성공":"등록 실패";
		mav.addObject("msg", msg);
		mav.addObject("href","/amor/admin/banner/bannerList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping(value = "admin/banner/bannerUpdate.do", method = RequestMethod.GET)
	public ModelAndView bannerUpdateForm(int banner_idx, HttpSession session, @CookieValue(value = "autologin", required = false)String autologin) {
		ModelAndView mav = new ModelAndView();
		
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			BannerDTO dto = bannerservice.bannerUpdate1(banner_idx);
			mav.addObject("dto",dto);
			mav.setViewName("admin/banner/bannerUpdate");
		}
		return mav;
	}
	
	@RequestMapping(value = "admin/banner/bannerUpdate.do", method = RequestMethod.POST)
	public ModelAndView bannerUpdateSubmit(BannerDTO dto) {
		ModelAndView mav = new ModelAndView();
		int result = bannerservice.bannerUpdate2(dto);
		String msg = result > 0 ? "수정 성공" : "수정 실패";
		mav.addObject("msg", msg);
		mav.addObject("href","/amor/admin/banner/bannerList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/banner/bannerDelete.do")
	public ModelAndView bannerDelete(int banner_idx, HttpSession session, @CookieValue(value = "autologin", required = false)String autologin) {
		ModelAndView mav = new ModelAndView();
		
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			int result = bannerservice.bannerDelete(banner_idx);
			String msg = result > 0 ? "삭제 성공" : "삭제 실패";
			mav.addObject("msg", msg);
			mav.addObject("href","/amor/admin/banner/bannerList.do");
			mav.setViewName("admin/msg/adminMsg");
		}
		return mav;
	}
}
