package com.amor.userController;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.product.service.ProductService;
import com.amor.product.model.*;

@Controller
public class StoreController {
	
	@Autowired
	private ProductService productService;

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
			@RequestParam("idx") int idx){
		
				/*@RequestParam("total")String total,
				@RequestParam("price")int price*/
//		System.out.println(num);
//		System.out.println(idx);
		ProductDTO dto=productService.storePayForm(idx,num);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("num", num);
		mav.addObject("dto", dto);
		mav.setViewName("/user/store/storePayment");
		return mav;
	}
	
	@RequestMapping("store/storeDetailForm.do")
	public ModelAndView storeDetailForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/user/store/storeDetail");
		return mav;
	}
	
	
}
