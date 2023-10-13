package com.amor.adminController;

import java.util.*;

import javax.servlet.http.HttpSession;

import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.amor.product.model.ProductDTO;
import com.amor.product.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	// 관리자 상품 목록 조회
	@RequestMapping("/admin/product/productList.do")
	public ModelAndView productListForm(@RequestParam(value = "cp", defaultValue = "1") int cp,
										HttpSession session, @CookieValue(value = "autologin", required = false) String autologin) {
		int totalCnt = productService.totalCnt();
		int listSize = 5;
		int pageSize = 5;

		String pageStr = com.amor.page.PageModule.makePage("/amor/admin/product/productList.do", totalCnt, listSize, pageSize, cp);
		
		List<ProductDTO> lists = productService.productList(cp, listSize);
		
		ModelAndView mav = new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		} else {
			mav.addObject("pageStr", pageStr);
			mav.addObject("lists", lists);
			mav.setViewName("admin/product/productList");
		}
		
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
		String content = productService.prodContent(product_idx).replaceAll("\n", "<br>");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("content", content);
		mav.setViewName("admin/product/productPopUp");
		return mav;
	}
	
	// 스토어 제목 검색
	@RequestMapping("admin/product/prodSearchList.do")
	public ModelAndView searchList(@RequestParam(value = "cp", defaultValue = "1") int cp, @RequestParam("search") String search,
								   HttpSession session, @CookieValue(value = "autologin", required = false) String autologin) {
		int totalCnt = productService.prodSearchTotalCnt(search);
		int listSize = 5;
		int pageSize = 5;

		String pageStr = com.amor.page.PageModuleSearch.makePage("/amor/admin/product/prodSearchList.do", totalCnt, listSize, pageSize, cp, search);
		
		List<ProductDTO> lists = productService.prodSearchList(cp, listSize, search);
		
		ModelAndView mav = new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		} else {
			mav.addObject("pageStr", pageStr);
			mav.addObject("lists", lists);
			mav.setViewName("admin/product/productList");
		}
		
		return mav;
	}
	
	// 상품 등록 페이지로 이동
	@RequestMapping(value = "admin/product/productAdd.do", method = RequestMethod.GET)
	public ModelAndView productAddForm(HttpSession session, @CookieValue(value = "autologin", required = false) String autologin) {
		ModelAndView mav = new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		} else {
			mav.setViewName("admin/product/productAdd");
		}
		
		return mav;
	}
	
	// 상품 등록
	@RequestMapping(value = "admin/product/productAdd.do", method = RequestMethod.POST)
	public ModelAndView productAdd(MultipartHttpServletRequest req) {
		MultipartFile upl = req.getFile("product_img");
		String upload = upl.getOriginalFilename();
		String noExt = upload.substring(0, upload.lastIndexOf("."));
		String ext = upload.substring(upload.lastIndexOf(".") + 1);

		String savePath = req.getRealPath("/resources/upload/product/");
		String saveFileName = "";
		
		try {
			byte bytes[] = upl.getBytes();
			String filefull = savePath + upload;
			File f = new File(filefull);
			if(f.isFile()) {
				boolean ex = true;
				int index = 0;
				while(ex) {
					index++;
					saveFileName = noExt+"("+index+")."+ext;
					String dictFile = savePath + saveFileName;
					ex = new File(dictFile).isFile();
					f = new File(dictFile);
				}
			} else if(!f.isFile()) {
				saveFileName = upload;
			}
			
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ProductDTO dto = new ProductDTO();
		dto.setProduct_category(req.getParameter("product_category"));
		dto.setProduct_title(req.getParameter("product_title"));
		dto.setProduct_price(Integer.parseInt(req.getParameter("product_price")));
		dto.setProduct_content(req.getParameter("product_content"));
		dto.setProduct_img(saveFileName);

		int count = productService.productAdd(dto);
		
		String msg = count > 0 ? "상품을 등록하였습니다." : "상품 등록 실패!";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl", "productList.do");
		mav.setViewName("user/msg/userMsg");
		
		return mav;
	}
	
	// 해당 상품 수정 페이지로 이동 후 정보 불러오기
	@RequestMapping(value = "admin/product/productUpdate.do", method = RequestMethod.GET)
	public ModelAndView productUpdateForm(@RequestParam("idx") int product_idx, HttpSession session, @CookieValue(value = "autologin", required = false) String autologin) {
		
		ProductDTO dto = productService.productSelectIdx(product_idx);
		ModelAndView mav = new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용 가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		} else {
			mav.addObject("dto", dto);
			mav.setViewName("admin/product/productUpdate");
		}
		
		return mav;
	}
	
	// 상품 수정
	@RequestMapping(value = "admin/product/productUpdate.do", method = RequestMethod.POST)
	public ModelAndView productUpdate(MultipartHttpServletRequest req) {
		MultipartFile upl = req.getFile("product_img");
		String upload = upl.getOriginalFilename();
		String noExt = upload.substring(0, upload.lastIndexOf("."));
		String ext = upload.substring(upload.lastIndexOf(".") + 1);
		
		String savePath = req.getRealPath("/resources/upload/product/");
		String saveFileName = "";
		
		try {
			byte bytes[] = upl.getBytes();
			String filefull = savePath+upload;
			File f = new File(filefull);
			if(f.isFile()) {
				boolean ex = true;
				int index = 0;
				while(ex) {
					index++;
					saveFileName = noExt+"("+index+")."+ext;
					String dictFile = savePath + saveFileName;
					ex = new File(dictFile).isFile();
					f = new File(dictFile);
				}
			} else if(!f.isFile()) {
				saveFileName = upload;
			}
			
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ProductDTO dto = new ProductDTO();
		dto.setProduct_idx(Integer.parseInt(req.getParameter("product_idx")));
		dto.setProduct_category(req.getParameter("product_category"));
		dto.setProduct_title(req.getParameter("product_title"));
		dto.setProduct_price(Integer.parseInt(req.getParameter("product_price")));
		dto.setProduct_content(req.getParameter("product_content"));
		dto.setProduct_img(saveFileName);
		
		int count = productService.productUpdate(dto);
		
		String msg = count > 0 ? "상품을 수정하였습니다." : "상품 수정 실패!";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl", "productList.do");
		mav.setViewName("user/msg/userMsg");
		
		return mav;
	}
	
	// 상품 삭제
	@RequestMapping("admin/product/productDel.do")
	public String productDel(@RequestParam("idx") int idx) {
		productService.productDel(idx);
		
		return "admin/product/productList";
	}
}