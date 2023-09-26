package com.amor.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SalesController {
	@RequestMapping("admin/sales/sales.do")
	public String salesForm() {
		return "admin/sales/sales";
	}
}