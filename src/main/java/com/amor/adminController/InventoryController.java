package com.amor.adminController;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.inventory.model.InventoryDTO;
import com.amor.inventory.service.InventoryService;

@Controller
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping("admin/inventory/inventoryList.do")
	public ModelAndView inventoryList(
			HttpSession session,
			@CookieValue(value = "autologin", required = false)String autologin,
			@RequestParam(value="cp", defaultValue = "1")int cp) {
		int totalCnt=inventoryService.inventoryTotalCnt();
		int listSize=10;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("/amor/admin/inventory/inventoryList.do", totalCnt, listSize, pageSize, cp);
		ModelAndView mav=new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용가능힙니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else {
			List<InventoryDTO> lists=inventoryService.inventoryList(cp, listSize);
			mav.addObject("pageStr", pageStr);
			mav.addObject("lists", lists);
			mav.setViewName("/admin/inventory/inventoryList");
		}
		return mav;
	}
	
	@RequestMapping(value="admin/inventory/inventoryWrite.do", method = RequestMethod.GET)
	public ModelAndView inventoryWriteForm(
			HttpSession session,
			@CookieValue(value = "autologin", required = false)String autologin) {
		ModelAndView mav=new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("admin/msg/adminMsg");
		}else {
			mav.addObject("href", "/amor/admin/inventory/inventoryWrite");
		}
		return mav;
	}
	
	@RequestMapping(value="admin/inventory/inventoryWrite.do", method = RequestMethod.POST)
	public ModelAndView inventoryAdd(
			HttpSession session,
			@CookieValue(value = "autologin", required = false)String autologin,
			@RequestParam("inventory_num")String inventory_num,
			@RequestParam("inventory_category")String inventory_category,
			@RequestParam("inventory_name")String inventory_name,
			@RequestParam("inventory_brand")String inventory_brand,
			@RequestParam("inventory_unit")String inventory_unit,
			@RequestParam("inventory_optimal")int inventory_optimal) {
		
		ModelAndView mav=new ModelAndView();
		if(autologin == null && session.getAttribute("data") == null) {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("href", "/amor/admin/adminLogin.do");
			mav.setViewName("admin/msg/adminMsg");
		}else {
			InventoryDTO dto=new InventoryDTO(0, inventory_num, inventory_category, inventory_name, inventory_brand, inventory_unit, inventory_optimal, 0, 0);
		    int result=inventoryService.inventoryAdd(dto);
		    String msg=result>0?"재고상품이 등록되었습니다.":"재고상품 등록이 실패했습니다.";
		    mav.addObject("msg", msg);
		    mav.addObject("href", "/amor/admin/inventory/inventoryList.do");
		    mav.setViewName("/admin/msg/adminMsg");
			}
		 return mav;
		}
	
	@RequestMapping("admin/inventory/inventoryUpdateForm.do")
	public ModelAndView inventoryUpdate(
			@RequestParam(value="idx", defaultValue = "0")int idx) {
		
		InventoryDTO dto=inventoryService.inventoryUpdateForm(idx);
		ModelAndView mav=new ModelAndView();
		if(dto==null) {
			mav.addObject("msg", "잘못된 접근입니다.");
			mav.addObject("href", "/amor/admin/inventory/inventoryList.do");
			mav.setViewName("/admin/msg/adminMsg");
		}else {
			mav.addObject("dto", dto);
			mav.setViewName("/admin/inventory/inventoryUpdate");
		}
		return mav;
	}
	
	@RequestMapping("admin/inventory/inventoryUpdate.do")
	public ModelAndView inventoryUpdate(InventoryDTO dto) {
		
		int result=inventoryService.inventoryUpdate(dto);
		String msg=result>0?"수정 완료되었습니다.":"수정 실패했습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/inventory/inventoryList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/inventory/inventoryDelete.do")
	public ModelAndView inventoryDelete(
			@RequestParam(value="idx", defaultValue = "0")int idx) {
		int result=inventoryService.inventoryDelete(idx);
		String msg=result>0?"삭제되었습니다.":"삭제 실패했습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href", "/amor/admin/inventory/inventoryList.do");
		mav.setViewName("/admin/msg/adminMsg");
		return mav;
	}
}
