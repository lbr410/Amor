package com.amor.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalesController {
	@RequestMapping("admin/sales/sales.do")
	public String salesForm(@RequestParam(value = "startd", defaultValue = "") String startd,
							@RequestParam(value = "endd", defaultValue = "") String endd,
							@RequestParam(value = "category", defaultValue = "") String category,
							@RequestParam(value = "kind", defaultValue = "") String kind) {
		System.out.println("startd = "+startd);
		System.out.println("endd = "+endd);
		System.out.println("category = "+category);
		System.out.println("kind = "+kind);
		
		return "admin/sales/sales";
	}
}