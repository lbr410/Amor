package com.amor.userController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amor.storePayment.model.MyPageStorePaymentDTO;
import com.amor.storePayment.service.StorePaymentService;

@Controller
public class MyPageStorePaymentController {

	@Autowired
	StorePaymentService storePaymentService;
	
	@RequestMapping("myAmor/storePayment.do")
	public ModelAndView storePaymentList(HttpSession session) {
		int useridx = (int)session.getAttribute("sidx");
		ModelAndView mav = new ModelAndView();
		if(useridx > 0) {
			List<MyPageStorePaymentDTO> lists = storePaymentService.MypageStorePaymentList(useridx);
			if(lists != null) {
				mav.addObject("list", lists);
				mav.addObject("useridx", useridx);
				mav.setViewName("myAmor/storePayment");
				return mav;
			}else {
				mav.addObject("list", null);
				mav.setViewName("myAmor/storePayment");
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
