package com.amor.userController;

import java.io.*;
import java.net.*;
import java.net.URL;
import java.net.http.HttpRequest;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.client.RestClientException;

import com.amor.product.service.ProductService;
import com.amor.storePayment.service.StorePaymentService;
import com.amor.product.model.*;
import com.amor.storePayment.model.*;
import com.amor.payment.*;

@Controller
public class StoreController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private StorePaymentService storePaymentService;
	
	private int product_idx;
	private String totalPrice;
	private int dbnum;
	private String product_title;
	private String paytime;


	@RequestMapping("store/store.do")
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
	
	
	@RequestMapping(value="store/storeSubmit.do",method = RequestMethod.POST)
	public  String storeSubmit(
			@RequestParam(value="idx", defaultValue = "0") int idx,
			@RequestParam("num") int num,
			HttpSession session) {
		ProductDTO pdto=productService.storeKakao(idx, num);
		
		String sid=(String)session.getAttribute("sid");
		String quantity=Integer.toString(num);
		String total_amount=Integer.toString(pdto.getProduct_price()*num);
//		String okpage="http://localhost:9090/amor/store/kakaoOk.do"; // localhost
//		String okpage="http://192.168.0.45:9090/amor/store/kakaoOk.do"; // 203호
		String okpage="192.168.1.156:9090/amor/store/kakaoOk.do"; // 401호
		
//		String cancelpage="http://localhost:9090/amor/store/kakaoFail.do"; // localhost
//		String cancelpage="http://192.168.0.45:9090/amor/store/kakaoFail.do"; // 203호
		String cancelpage="http://192.168.1.156:9090/amor/store/kakaoFail.do"; // 401호
		
//		String failpage="http://localhost:9090/amor/store/kakaoCancel.do"; // localhost
//		String failpage="http://192.168.0.45:9090/amor/store/kakaoCancel.do"; // 203호
		String failpage="http://192.168.1.156:9090/amor/store/kakaoCancel.do"; // 401호
		
		
		product_idx=pdto.getProduct_idx();	
		product_title=pdto.getProduct_title();
	
		totalPrice=total_amount;
		dbnum=num;

		KakaopayDTO kdto=new KakaopayDTO("1" ,sid , pdto.getProduct_title(), quantity, total_amount , okpage, cancelpage, failpage);
		Kakaopay kaka=new Kakaopay();
		return "redirect:" + kaka.kakaoPayReady(kdto);
	}
		
	@RequestMapping("store/kakaoOk.do")
	public ModelAndView storeInsert(
			@RequestParam("pg_token")String pg_token,
			HttpSession session) {

		int sidx=(Integer)session.getAttribute("sidx");
		int totalPriceInt=Integer.parseInt(totalPrice);
		
		int result=storePaymentService.storePayInert(product_idx, sidx, dbnum,totalPriceInt);
		
		LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatTime = time.format(formatter);
		paytime=formatTime;
		
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg", "결제가 완료되었습니다.");
        mav.addObject("goUrl", "/amor/store/storeDetail.do");
        mav.setViewName("/user/msg/userMsg");
        
		return mav;
	}
	
	@RequestMapping("store/storeDetail.do")
	public ModelAndView storeDetailForm() {
		
		ModelAndView mav=new ModelAndView(); 
		mav.addObject("title", product_title);
		mav.addObject("price", Integer.parseInt(totalPrice));
		mav.addObject("time", paytime);
		mav.setViewName("/user/store/storeDetail");
		
		return mav;
	}

	
	@RequestMapping("store/kakaoCancel.do")
	public ModelAndView storeCancel() {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "결제가 취소되었습니다.");
		mav.addObject("goUrl", "/amor/store.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}
	
	@RequestMapping("store/kakaoFail.do")
	public ModelAndView storeFail() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "결제가 실패하였습니다.");
		mav.addObject("goUrl", "/amor/index.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}
	
}
