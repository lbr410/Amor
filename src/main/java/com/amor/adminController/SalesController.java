package com.amor.adminController;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.dual.model.DualDTO;
import com.amor.dual.service.DualService;
import com.amor.storePayment.model.StorePaymentDTO;
import com.amor.storePayment.service.StorePaymentService;
import com.amor.ticketing.model.TicketingDTO;
import com.amor.ticketing.service.TicketingService;

@Controller
public class SalesController {
	
	@Autowired
	private DualService dualService;
	
	@Autowired
	private StorePaymentService storePaymentService;
	
	@Autowired
	private TicketingService ticketingService;
	
	// 매출관리 페이지로 이동
	@RequestMapping("admin/sales/sales.do")
	public ModelAndView salesForm(HttpSession session) {		
		
		List<DualDTO> salesChartData = dualService.salesChartData();
		List<DualDTO> sixMonthData = new ArrayList<DualDTO>();
		List<DualDTO> weekData = new ArrayList<DualDTO>();
		
		for(int i=0; i<salesChartData.size(); i++) {
			if(salesChartData.get(i).getOrders() <= 5) {
				// 최근 6개월
				sixMonthData.add(salesChartData.get(i));
			} else {
				// 최근 일주일
				weekData.add(salesChartData.get(i));
			}
		}

		ModelAndView mav = new ModelAndView();
		if(session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다."); // 메시지 왜 안뜨는?
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		} else {
			mav.addObject("sixMonthData", sixMonthData);
			mav.addObject("weekData", weekData);
			mav.setViewName("admin/sales/sales");
		}
		return mav;
	}
	
	// 기간별 매출 조회
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