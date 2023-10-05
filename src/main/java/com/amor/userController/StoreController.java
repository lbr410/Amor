package com.amor.userController;

import java.io.*;
import java.net.*;
import java.net.URL;
import java.text.*;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.amor.product.service.ProductService;
import com.amor.storePayment.service.StorePaymentService;
import com.amor.product.model.*;
import com.amor.storePayment.model.*;

@Controller
public class StoreController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private StorePaymentService storePaymentService;

	@RequestMapping("store.do")
	public ModelAndView storeForm() {
		
		List<ProductDTO> Tlists=productService.storeTicketList();
		List<ProductDTO> Dlists=productService.storeDrinkList();
		List<ProductDTO> Slists=productService.storeSnackList();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("Tlists", Tlists);
		mav.addObject("Dlists", Dlists);
		mav.addObject("Slists", Slists);
		
		mav.setViewName("/user/store/store");
		
		return mav;
	}
	
	@RequestMapping("store/storeContentForm.do")
	public ModelAndView storeContent(
			@RequestParam(value="product_idx",defaultValue ="0") int idx) {
		
		ProductDTO dto=productService.storeContent(idx);
		ModelAndView mav=new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("user/store/storeContent");
		return mav;
	}
	
	@RequestMapping("store/storePaymentForm.do")
	public ModelAndView storePaymentForm(
			@RequestParam("num") int num,
			@RequestParam("idx") int idx,
			HttpSession session){
		
				/*@RequestParam("total")String total,
				@RequestParam("price")int price*/
//		System.out.println(num);
//		System.out.println(idx);
		ModelAndView mav=new ModelAndView();
		if(session.getAttribute("sid")==null) {
			mav.addObject("msg", "로그인 후 이용가능합니댜.");
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("/user/msg/userMsg");
		}else {
			
			ProductDTO dto=productService.storePayForm(idx,num);
				
			mav.addObject("num", num);
			mav.addObject("dto", dto);
			mav.setViewName("/user/store/storePayment");
		}

		return mav;
	}
	
	
	@RequestMapping("store/storeDetail.do")
	public ModelAndView storeDetailForm() {
		        
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/user/store/storeDetail");
		return mav;
	}
	
	
}
