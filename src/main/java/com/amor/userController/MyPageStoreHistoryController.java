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
	public ModelAndView mypageStorePaymentList(HttpSession session) {
		String useridx = (String)session.getAttribute("sidx");
		ModelAndView mav = new ModelAndView();
		if(useridx != null) {
			int uidx = Integer.parseInt(useridx);
			List<MyPageStorePaymentDTO> lists = storePaymentService.mypageStorePaymentList(uidx);
			if(lists != null) {
				mav.addObject("list", lists);
				mav.setViewName("user/myAmor/storeHistory");
				return mav;
			}else {
				mav.addObject("list", null);
				mav.setViewName("user/myAmor/storeHistory");
				return mav;
			}
		}else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
			return mav;
		}
	}
	
	@RequestMapping("myAmor/storeCancellation.do")
	public ModelAndView mypageStoreCancell(@RequestParam("paymentidx")int paymentidx) {
		ModelAndView mav = new ModelAndView();
		int result = storePaymentService.mypageStoreCancell(paymentidx);
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
	
	@RequestMapping("myAmor/storeCancellList.do")
	public ModelAndView storeCancellList(HttpSession session) {
		int useridx = (int)session.getAttribute("sidx");
		ModelAndView mav = new ModelAndView();
		if(useridx > 0) {
			List<MyPageStorePaymentDTO> lists = storePaymentService.mypageStoreCancellList(useridx);
			if(lists != null) {
				mav.addObject("list", lists);
				mav.setViewName("user/myAmor/storeCancellList");
				return mav;
			}else {
				mav.addObject("list", null);
				mav.setViewName("user/myAmor/storeCancellList");
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
