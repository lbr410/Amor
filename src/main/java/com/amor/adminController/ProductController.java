package com.amor.adminController;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.product.model.ProductDTO;
import com.amor.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	// 관리자 상품 목록 조회
	@RequestMapping("admin/product/productList.do")
	public ModelAndView productListForm(@RequestParam(value = "cp", defaultValue = "1") int cp) {
		int totalCnt = productService.totalCnt();
		int listSize = 5;
		int pageSize = 5;

		String pageStr = com.amor.page.PageModule.makePage("/amor/admin/product/productList.do", totalCnt, listSize, pageSize, cp);
		
		List<ProductDTO> lists = productService.productList(cp, listSize);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr", pageStr);
		mav.addObject("lists", lists);
		mav.setViewName("admin/product/productList");
		
		return mav;
	}
	
	// 품절 여부 변경
	@RequestMapping("admin/product/soldOutChk.do")
	public ModelAndView soldOutChange(@RequestParam("idx") int idx, @RequestParam("soldout") String soldout) {
		ProductDTO dto = new ProductDTO();
		if(soldout.equals("y")) {
			dto.setProduct_soldout("y");
			dto.setProduct_idx(idx);
			productService.soldOutChange(dto);
		} 
		if(soldout.equals("n")) {
			dto.setProduct_soldout("n");
			dto.setProduct_idx(idx);
			productService.soldOutChange(dto);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/product/productList");
		return mav;
	}
	
	// 상세내용 보기 클릭시 팝업창으로 상세내용 출력
	@RequestMapping("admin/product/productPopUp.do")
	public ModelAndView productContent(@RequestParam("idx") int product_idx) {
		String content = productService.prodContent(product_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("content", content);
		mav.setViewName("admin/product/productPopUp");
		return mav;
	}
	
	// 스토어 제목 검색
	@RequestMapping("admin/product/prodSearchList.do")
	public ModelAndView searchList(@RequestParam(value = "cp", defaultValue = "1") int cp, @RequestParam("search") String search) {
		int totalCnt = productService.prodSearchTotalCnt(search);
		int listSize = 5;
		int pageSize = 5;

		String pageStr = com.amor.page.PageModuleSearch.makePage("/amor/admin/product/prodSearchList.do", totalCnt, listSize, pageSize, cp, search);
		
		List<ProductDTO> lists = productService.prodSearchList(cp, listSize, search);
		System.out.println(search);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr", pageStr);
		mav.addObject("lists", lists);
		mav.setViewName("admin/product/productList");
		
		return mav;
	}
	
	// 상품 등록 페이지로 이동
	@RequestMapping(value = "admin/product/productAdd.do", method = RequestMethod.GET)
	public String productAddForm() {
		return "admin/product/productAdd";
	}
	
	// 상품 등록
	@RequestMapping(value = "admin/product/productAdd.do", method = RequestMethod.POST)
	public ModelAndView productAdd(ProductDTO dto) {
		int count = productService.productAdd(dto);
		
		String msg = count > 0 ? "상품을 등록하였습니다." : "상품 등록 실패!";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl", "productList.do");
		mav.setViewName("user/msg/userMsg");
		
		return mav;
	}
}