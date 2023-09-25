package com.amor.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieReviewController {

	@RequestMapping("myAmor/reviewTemp.do")
	public String reviewWrite() {
		return "/user/myAmor/tempReview";
	}	
}


