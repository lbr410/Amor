package com.amor.adminController;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.storePayment.model.StorePaymentDTO;
import com.amor.storePayment.service.StorePaymentService;
import com.amor.ticketing.model.TicketingDTO;
import com.amor.ticketing.service.TicketingService;

@Controller
public class SalesController {
	
	@Autowired
	private StorePaymentService storePaymentService;
	
	@Autowired
	private TicketingService ticketingService;
	
	@RequestMapping("admin/sales/sales.do")
	public ModelAndView salesForm() {		
		StorePaymentDTO aMonthAgo = storePaymentService.aMonthAgo();
		StorePaymentDTO twoMonthsAgo = storePaymentService.twoMonthsAgo();
		StorePaymentDTO threeMonthsAgo = storePaymentService.threeMonthsAgo();
		StorePaymentDTO fourMonthsAgo = storePaymentService.fourMonthsAgo();
		StorePaymentDTO fiveMonthsAgo = storePaymentService.fiveMonthsAgo();
		StorePaymentDTO sixMonthsAgo = storePaymentService.sixMonthsAgo();
		StorePaymentDTO aDayAgo = storePaymentService.aDayAgo();
		StorePaymentDTO twoDaysAgo = storePaymentService.twoDaysAgo();
		StorePaymentDTO threeDaysAgo = storePaymentService.threeDaysAgo();
		StorePaymentDTO fourDaysAgo = storePaymentService.fourDaysAgo();
		StorePaymentDTO fiveDaysAgo = storePaymentService.fiveDaysAgo();
		StorePaymentDTO sixDaysAgo = storePaymentService.sixDaysAgo();
		StorePaymentDTO sevenDaysAgo = storePaymentService.sevenDaysAgo();
		
		Map lists = new HashMap();
		// 최근 6개월
		lists.put("aMonthAgoTotalPrice", aMonthAgo.getA());
		lists.put("twoMonthsAgoTotalPrice", twoMonthsAgo.getA());
		lists.put("threeMonthsAgoTotalPrice", threeMonthsAgo.getA());
		lists.put("fourMonthsAgoTotalPrice", fourMonthsAgo.getA());
		lists.put("fiveMonthsAgoTotalPrice", fiveMonthsAgo.getA());
		lists.put("sixMonthsAgoTotalPrice", sixMonthsAgo.getA());
		
		lists.put("aMonthAgoMonth", aMonthAgo.getB());
		lists.put("twoMonthsAgoMonth", twoMonthsAgo.getB());
		lists.put("threeMonthsAgoMonth", threeMonthsAgo.getB());
		lists.put("fourMonthsAgoMonth", fourMonthsAgo.getB());
		lists.put("fiveMonthsAgoMonth", fiveMonthsAgo.getB());
		lists.put("sixMonthsAgoMonth", sixMonthsAgo.getB());
		
		// 최근 일주일
		lists.put("aDayAgoTotalPrice", aDayAgo.getA());
		lists.put("twoDaysAgoTotalPrice", twoDaysAgo.getA());
		lists.put("threeDaysAgoTotalPrice", threeDaysAgo.getA());
		lists.put("fourDaysAgoTotalPrice", fourDaysAgo.getA());
		lists.put("fiveDaysAgoTotalPrice", fiveDaysAgo.getA());
		lists.put("sixDaysAgoTotalPrice", sixDaysAgo.getA());
		lists.put("sevenDaysAgoTotalPrice", sevenDaysAgo.getA());
		
		lists.put("aDayAgoDay", aDayAgo.getB());
		lists.put("twoDasyAgoDay", twoDaysAgo.getB());
		lists.put("threeDaysAgoDay", threeDaysAgo.getB());
		lists.put("fourDaysAgoDay", fourDaysAgo.getB());
		lists.put("fiveDaysAgDay", fiveDaysAgo.getB());
		lists.put("sixDaysAgoDay", sixDaysAgo.getB());
		lists.put("sevenDaysAgoDay", sevenDaysAgo.getB());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.setViewName("admin/sales/sales");
		return mav;
	}
	
	@RequestMapping("admin/sales/salesCheck.do")
	public String salesCheck(@RequestParam(value = "startd", defaultValue = "") String startd,
			@RequestParam(value = "endd", defaultValue = "") String endd,
			@RequestParam(value = "category", defaultValue = "") String category,
			@RequestParam(value = "kind", defaultValue = "") String kind, Model model) {
		
		List<StorePaymentDTO> check = null;
		List<TicketingDTO> check2 = null;
		String total = null;
		
		/** 조회 */
		// 전체
		if(kind.equals("a")) {
			if(category.equals("all")) {
				total = storePaymentService.allAll(startd, endd);
				model.addAttribute("total", total);
			} else if(category.equals("movie")) {
				total = ticketingService.allMovie(startd, endd);
				model.addAttribute("total", total);
			} else if(category.equals("store")) {
				total = storePaymentService.allStore(startd, endd);
				model.addAttribute("total", total);
			}
		}
		
		// 일자별
		if(kind.equals("d")) {
			if(category.equals("all")) {
				check = storePaymentService.dayAll(startd, endd);
				total = storePaymentService.dayAllTotal(startd, endd);
				model.addAttribute("check", check);
				model.addAttribute("total", total);
			} else if(category.equals("movie")) {
				check2 = ticketingService.dayMovie(startd, endd);
				total = ticketingService.dayMovieTotal(startd, endd);
				model.addAttribute("check", check2);
				model.addAttribute("total", total);
			} else if(category.equals("store")) {
				check = storePaymentService.dayStore(startd, endd);
				total = storePaymentService.dayStoreTotal(startd, endd);
				model.addAttribute("check", check);
				model.addAttribute("total", total);
			}
		}
		
		// 월별
		if(kind.equals("m")) {
			if(category.equals("all")) {
				check = storePaymentService.monthAll(startd, endd);
				total = storePaymentService.monthAllTotal(startd, endd);
				model.addAttribute("check", check);
				model.addAttribute("total", total);
			} else if(category.equals("movie")) {
				check2 = ticketingService.monthMovie(startd, endd);
				total = ticketingService.monthMovieTotal(startd, endd);
				model.addAttribute("check", check2);
				model.addAttribute("total", total);
			} else if(category.equals("store")) {
				check = storePaymentService.monthStore(startd, endd);
				total = storePaymentService.monthStoreTotal(startd, endd);
				model.addAttribute("check", check);
				model.addAttribute("total", total);
			}
		}
		
		return "amorJson";
	}
}