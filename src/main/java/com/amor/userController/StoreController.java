package com.amor.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amor.member.service.MemberService;
import com.amor.product.service.ProductService;

@Controller
public class StoreController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("store.do")
	public String storeForm() {
		return "/user/store/store";
	}
	
	
}
