package com.amor.userController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.storePayment.model.MyPageStorePaymentDTO;
import com.amor.storePayment.service.StorePaymentService;

@Controller
public class MyPageStoreHistoryController {

	@Autowired
	StorePaymentService storePaymentService;
	
	@RequestMapping("myAmor/storeHistory.do")
	public ModelAndView mypageStorePaymentList(HttpSession session,
			@RequestParam(value = "cp", defaultValue = "1")int cp) {
		int useridx = (int)session.getAttribute("sidx");
		ModelAndView mav = new ModelAndView();
		if(useridx > 0) {
			String pagename = "/amor/myAmor/storeHistory.do";
			int totalCnt = storePaymentService.userStoreListTotalCntY(useridx);
			int listSize = 5;
			int pageSize = 5;
			List<MyPageStorePaymentDTO> lists = storePaymentService.mypageStorePaymentList(useridx, listSize, cp);
			if(lists != null) {
				String page = com.amor.page.PageModule.makePage(pagename, totalCnt, listSize, pageSize, cp);
				mav.addObject("list", lists);
				mav.addObject("page", page);
				mav.setViewName("user/myAmor/storeHistory");
			}else {
				mav.addObject("list", null);
				mav.addObject("page", null);
				mav.setViewName("user/myAmor/storeHistory");
			}
		}else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
		}
		return mav;
	}
	
	@RequestMapping("myAmor/storeCancellation.do")
	public ModelAndView mypageStoreCancel(@RequestParam("paymentidx")int paymentidx) {
		ModelAndView mav = new ModelAndView();
		int result = storePaymentService.mypageStoreCancel(paymentidx);
		if(result == 1) {
			mav.addObject("msg", "상품이 취소되었습니다.");
			mav.addObject("goUrl","/amor/myAmor/storeHistory.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}else {
			mav.addObject("msg", "상품취소가 불가합니다.(관리자 문의부탁드립니다.)");
			mav.addObject("goUrl","/amor/myAmor/storeHistory.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}
	}
	
	@RequestMapping("myAmor/storeCancelList.do")
	public ModelAndView storeCancelList(HttpSession session,
			@RequestParam(value = "cp", defaultValue = "1")int cp) {
		int useridx = (int)session.getAttribute("sidx");
		ModelAndView mav = new ModelAndView();
		if(useridx > 0) {
			String pagename = "/amor/myAmor/storeCancelList.do";
			int totalCnt = storePaymentService.userStoreListTotalCntN(useridx);
			int listSize = 5;
			int pageSize = 5;
			List<MyPageStorePaymentDTO> lists = storePaymentService.mypageStoreCancelList(useridx,listSize,cp);
			if(lists != null) {
				String page = com.amor.page.PageModule.makePage(pagename, totalCnt, listSize, pageSize, cp);
				mav.addObject("list", lists);
				mav.addObject("page", page);
				mav.setViewName("user/myAmor/storeCancelList");
				return mav;
			}else {
				mav.addObject("list", null);
				mav.addObject("page", null);
				mav.setViewName("user/myAmor/storeCancelList");
				return mav;
			}
		}else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}
	}
}
