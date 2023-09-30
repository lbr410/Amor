package com.amor.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amor.storePayment.service.StorePaymentService;

@Controller
public class StoreListController {

	@Autowired
	private StorePaymentService storePaymentService;
	
	@RequestMapping("admin/store/storeList.do")
	public ModelAndView storeListForm() {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/admin/store/storeList");
		return mav;
	}
}
