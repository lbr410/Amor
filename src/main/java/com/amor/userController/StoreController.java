package com.amor.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController {

	@RequestMapping("store.do")
	public String storeForm() {
		return "/user/store/store";
	}
}
