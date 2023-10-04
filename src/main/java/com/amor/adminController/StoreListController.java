package com.amor.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.storePayment.service.StorePaymentService;
import com.amor.storePayment.model.*;

@Controller
public class StoreListController {

	@Autowired
	private StorePaymentService storePaymentService;
	
	@RequestMapping("admin/store/storeList.do")
	public ModelAndView storeListForm(
			HttpSession session,
			@RequestParam(value="cp",defaultValue = "1")int cp) {
		int totalCnt=storePaymentService.storeListTotalCnt();
		int listSize=10;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/store/storeList.do", totalCnt, listSize, pageSize, cp);
				
		ModelAndView mav=new ModelAndView();
		if(session.getAttribute("data")==null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");			
		}else {
			List<StorePaymentDTO> lists=storePaymentService.storeList(cp, listSize);
			mav.addObject("lists", lists);
			mav.addObject("pageStr", pageStr);
			mav.setViewName("/admin/store/storeList");
		}
		return mav;
	}
	
	@RequestMapping("admin/store/storeListSubmit.do")
	public ModelAndView storeSubmit(
			@RequestParam("status")String status,
			@RequestParam(value="idx",defaultValue = "0")int idx) {
		int result=storePaymentService.storeListSubmit(status,idx);
		String msg=result>0?"수정 성공":"수정 실패";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/store/storeList");
		mav.setViewName("/admin/store/storeList");
		return mav;
	}
}
