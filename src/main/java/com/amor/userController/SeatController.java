package com.amor.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeatController {
	@RequestMapping("ticketing/seat.do")
	public String SeatForm() {
		return "user/ticketing/seat";
	}
}