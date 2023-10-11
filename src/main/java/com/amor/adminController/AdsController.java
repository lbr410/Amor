package com.amor.adminController;

import java.util.*;

import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.amor.ads.model.AdsDTO;
import com.amor.ads.service.AdsService;

@Controller
public class AdsController {
	
	@Autowired
	private AdsService adsservice;

	@RequestMapping("admin/ads/adsList.do")
	public ModelAndView adsList(HttpSession session, @CookieValue(value = "autologin", required = false)String autologin) {
		ModelAndView mav = new ModelAndView();
		
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			List<AdsDTO> lists = adsservice.adsList();
			String btnOk="";
			if(lists.size()==3) {
				btnOk = "AllLock";
			}else if(lists.size()==2) {
				if(lists.get(0).getAds_idx() == 1) {
					if(lists.get(1).getAds_idx() == 2) {
						btnOk = "tOpen";
					}else {
						btnOk = "sOpen";
					}
				}else if(lists.get(0).getAds_idx() == 2) {
					if(lists.get(1).getAds_idx() == 3) {
						btnOk = "fOpen";
					}
				}
			}else if(lists.size()==1) {
				if(lists.get(0).getAds_idx() == 1) {
					btnOk = "stOpen";
				}else if(lists.get(0).getAds_idx() == 2) {
					btnOk = "ftOpen";
				}else if(lists.get(0).getAds_idx() == 3) {
					btnOk = "fsOpen";
				}
			}else if(lists.size()==0) {
				btnOk = "allOpen";
			}else {
				btnOk = "alreadyExists";
			}
			mav.addObject("btnOk",btnOk);
			mav.addObject("lists",lists);
			mav.setViewName("admin/ads/adsList");
		}
		return mav;
	}
	
	@RequestMapping(value =  "admin/ads/adsAdd.do", method = RequestMethod.GET )
	public ModelAndView adsAddForm(int ads_idx, HttpSession session, @CookieValue(value = "autologin", required = false)String autologin) {
		ModelAndView mav = new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			mav.addObject("ads_idx",ads_idx);
			mav.setViewName("admin/ads/adsAdd");
		}
		
		return mav;
	}
	
	@RequestMapping(value =  "admin/ads/adsAdd.do", method = RequestMethod.POST )
	public ModelAndView adsAddSubmit(MultipartHttpServletRequest req) {
		MultipartFile upl = req.getFile("ads_filename");
		String upload = upl.getOriginalFilename();
		
		String noExt = upload.substring(0, upload.lastIndexOf("."));
		String ext = upload.substring(upload.lastIndexOf(".") + 1);

		String savePath = req.getRealPath("/resources/upload/ads/");
		String saveFileName = "";
		
		try {
			byte bytes[] = upl.getBytes();
			String filefull = savePath + upload;
			File f = new File(filefull);
			if(f.isFile()) {
				boolean ex = true;
				int index = 0;
				while(ex) {
					index++;
					saveFileName = noExt+"("+index+")."+ext;
					String dictFile = savePath + saveFileName;
					ex = new File(dictFile).isFile();
					f = new File(dictFile);
				}
			} else if(!f.isFile()) {
				saveFileName = upload;
			}
			
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AdsDTO dto = new AdsDTO();
		String ads_idx_s = req.getParameter("ads_idx");
		int ads_idx = Integer.parseInt(ads_idx_s);
		dto.setAds_idx(ads_idx);
		dto.setAds_name(req.getParameter("ads_name"));
		dto.setAds_url(req.getParameter("ads_url"));
		dto.setAds_filename(saveFileName);
		
		ModelAndView mav = new ModelAndView();
		int result = adsservice.adsAdd(dto);
		String msg = result > 0 ? "등록 성공":"등록 실패";
		mav.addObject("msg", msg);
		mav.addObject("href","/amor/admin/ads/adsList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping(value="admin/ads/adsUpdate.do",method = RequestMethod.GET)
	public ModelAndView adsUpdateForm(int ads_idx, HttpSession session, @CookieValue(value = "autologin", required = false)String autologin) {
		ModelAndView mav = new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			AdsDTO dto = adsservice.adsUpdate1(ads_idx);
			mav.addObject("dto",dto);
			mav.addObject("ads_idx", ads_idx);
			mav.setViewName("admin/ads/adsUpdate");
		}
		return mav;
	}
	
	@RequestMapping(value =  "admin/ads/adsUpdate.do",method = RequestMethod.POST)
	public ModelAndView adsUpdateSubmit(MultipartHttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		MultipartFile upl = req.getFile("ads_filename");
		String upload = upl.getOriginalFilename();
		
		String noExt = upload.substring(0, upload.lastIndexOf("."));
		String ext = upload.substring(upload.lastIndexOf(".") + 1);

		String savePath = req.getRealPath("/resources/upload/ads/");
		String saveFileName = "";
		
		try {
			byte bytes[] = upl.getBytes();
			String filefull = savePath + upload;
			File f = new File(filefull);
			if(f.isFile()) {
				boolean ex = true;
				int index = 0;
				while(ex) {
					index++;
					saveFileName = noExt+"("+index+")."+ext;
					String dictFile = savePath + saveFileName;
					ex = new File(dictFile).isFile();
					f = new File(dictFile);
				}
			} else if(!f.isFile()) {
				saveFileName = upload;
			}
			
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		AdsDTO dto = new AdsDTO();
		String ads_idx_s = req.getParameter("ads_idx");
		int ads_idx = Integer.parseInt(ads_idx_s);
		dto.setAds_idx(ads_idx);
		dto.setAds_name(req.getParameter("ads_name"));
		dto.setAds_url(req.getParameter("ads_url"));
		dto.setAds_filename(saveFileName);
		
		int result = adsservice.adsUpdate2(dto);
		String msg = result > 0 ? "수정 성공":"수정 실패";
		mav.addObject("msg", msg);
		mav.addObject("href","/amor/admin/ads/adsList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/ads/adsDelete.do")
	public ModelAndView adsDelete(int ads_idx, HttpSession session, @CookieValue(value = "autologin", required = false)String autologin) {
		ModelAndView mav = new ModelAndView();
		
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else{
			int result = adsservice.adsDelete(ads_idx);
			String msg = result > 0 ? "삭제 성공" : "삭제 실패";
			mav.addObject("msg", msg);
			mav.addObject("href","/amor/admin/ads/adsList.do");
			mav.setViewName("admin/msg/adminMsg");
		}
		return mav;
	}
}
