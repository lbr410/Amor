package com.amor.adminController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.theater.model.TheaterDTO;
import com.amor.theater.service.TheaterService;
import com.amor.etc.*;

@Controller
public class TheaterController {

	@Autowired
	TheaterService theaterService;
	
	@RequestMapping("/admin/theater/theaterList.do")
	public ModelAndView goTheater(@CookieValue(value = "autologin", required = false)String autologin,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("data");
		if(autologin != null || id != null) {
			
		List<TheaterDTO> lists = theaterService.theaterSelect();
		if(lists != null) {
			StringBuffer sb = new StringBuffer();
			sb.append("<div class=\"theater\" id = \"${temp.theater_idx}\">\r\n"
					+ "  <div class=\"theaterbox\">\r\n"
					+ "    <div class=\"theatername\"></div>\r\n"
					+ "    <div class=\"name\">${temp.theater_name}</div>\r\n"
					+ "  </div>\r\n"
					+ "  <c:url var=\"seateSelect\" value=\"/admin/theater/seateSelect.do\">\r\n"
					+ "  	<c:param name=\"theateridx\">${temp.theater_idx}</c:param>\r\n"
					+ "  	<c:param name=\"theatername\">${temp.theater_name}</c:param>\r\n"
					+ "  	<c:param name=\"row\">${temp.theater_row}</c:param>\r\n"
					+ "  	<c:param name=\"col\">${temp.theater_column}</c:param>\r\n"
					+ "  </c:url>\r\n"
					+ "  <a href = \"${seateSelect}\"><div class=\"addbox\">\r\n"
					+ "    <svg\r\n"
					+ "      class=\"addimg\"\r\n"
					+ "      width=\"29\"\r\n"
					+ "      height=\"29\"\r\n"
					+ "      viewBox=\"0 0 29 29\"\r\n"
					+ "      fill=\"none\"\r\n"
					+ "      xmlns=\"http://www.w3.org/2000/svg\"\r\n"
					+ "    >\r\n"
					+ "      <path\r\n"
					+ "        d=\"M0 -0.5H-0.5V0V29V29.5H0H29H29.5V29V0V-0.5H29H0Z\"\r\n"
					+ "        fill=\"white\"\r\n"
					+ "        stroke=\"black\"\r\n"
					+ "      />\r\n"
					+ "    </svg>\r\n"
					+ "\r\n"
					+ "    <svg\r\n"
					+ "      class=\"wright\"\r\n"
					+ "      width=\"24\"\r\n"
					+ "      height=\"24\"\r\n"
					+ "      viewBox=\"0 0 24 24\"\r\n"
					+ "      fill=\"none\"\r\n"
					+ "      xmlns=\"http://www.w3.org/2000/svg\"\r\n"
					+ "    >\r\n"
					+ "      <path\r\n"
					+ "        fill-rule=\"evenodd\"\r\n"
					+ "        clip-rule=\"evenodd\"\r\n"
					+ "        d=\"M19.4142 2.41421C18.6332 1.63317 17.3668 1.63316 16.5858 2.41421L3.39881 15.6012L3.058 20.0996L7.55644 19.7588L20.7434 6.57184C21.5245 5.79079 21.5245 4.52446 20.7434 3.74341L19.4142 2.41421ZM16.8121 8.12734L15.0303 6.3455L5.13114 16.2446L4.81017 18.3474L6.91298 18.0265L16.8121 8.12734Z\"\r\n"
					+ "        fill=\"#1A2C82\"\r\n"
					+ "      />\r\n"
					+ "    </svg>\r\n"
					+ "  </div></a>\r\n"
					+ "  <div class=\"delbox\" onclick = \"theaterDel(${temp.theater_idx})\">\r\n"
					+ "    <div class=\"delimg\"></div>\r\n"
					+ "    <svg\r\n"
					+ "      class=\"bin\"\r\n"
					+ "      width=\"24\"\r\n"
					+ "      height=\"26\"\r\n"
					+ "      viewBox=\"0 0 24 26\"\r\n"
					+ "      fill=\"none\"\r\n"
					+ "      xmlns=\"http://www.w3.org/2000/svg\"\r\n"
					+ "    >\r\n"
					+ "      <path\r\n"
					+ "        fill-rule=\"evenodd\"\r\n"
					+ "        clip-rule=\"evenodd\"\r\n"
					+ "        d=\"M15 2.34473H9V4.48266H3V7.68955L5 7.68955V21.5861C5 22.7669 5.89543 23.724 7 23.724H17C18.1046 23.724 19 22.7669 19 21.5861V7.68955L21 7.68955V4.48266H15V2.34473ZM7 7.68955H17V21.5861H7V7.68955ZM9 10.8965H11V18.3792H9V10.8965ZM15 10.8965H13V18.3792H15V10.8965Z\"\r\n"
					+ "        fill=\"#666666\"\r\n"
					+ "      />\r\n"
					+ "    </svg>\r\n"
					+ "  </div>\r\n"
					+ "</div>");
			mav.addObject("theater", sb.toString());
			mav.addObject("lists", lists);
			mav.setViewName("admin/theater/theaterList");
			return mav;
		}else{
			mav.addObject("lists", null);
			mav.setViewName("admin/theater/theaterList");
			return mav;
		}
		
		}else {
			mav.setViewName("admin/adminLogin");
			return mav;
		}
	}
	
	@RequestMapping("/admin/theater/createTheater.do")
	public String createTheater(Model model) {
		int totalTheater = theaterService.totalTheater();
		if(totalTheater == 6) {
			model.addAttribute("alert", "상영관을 6개이상 생성하실수 없습니다.");
		}else{
			int result = theaterService.theaterAdd();
			if(result > 0) {
				model.addAttribute("alert", null);
			}else {
				model.addAttribute("alert", "생성중 오류가 발생했습니다 관리자 문의 바랍니다.");
			}
			
		}
		return "amorJson";
	}
	
	@RequestMapping("/admin/theater/addSeate.do")
	public String show(@RequestParam("row")int row,
			@RequestParam(name = "col",required = false)int col,
			@RequestParam("theateridx")int tidx,
			Model model) {
		TheaterDTO tdto = theaterService.theaterInfo(tidx);
		seat item = new seat();
		String seates = item.addTheater(tdto.getTheater_seat(), row, col);
		model.addAttribute("seates",seates);
		return "amorJson";
	}
	
	@RequestMapping("/admin/theater/seateInitialization.do")
	public String seateInitialization(@RequestParam("row")int row,
			@RequestParam(name = "col",required = false)int col,
			Model model) {
		seat item = new seat();
		String seates = item.addTheater(null, row, col);
		model.addAttribute("seates",seates);
		return "amorJson";
	}
	
	@RequestMapping("/admin/theater/updateSeate.do")
	public String updateSeate(@RequestParam("seatesData")String seates,
			@RequestParam("totalseat")int totalseat,
			@RequestParam("row")int row,
			@RequestParam("col")int col,
			@RequestParam("tidx")int tidx,
			@RequestParam("theatername")String name,
			Model model) {
		int result = theaterService.updateSeate(name, seates, tidx, totalseat, row, col);
		if(result > 0) {
			model.addAttribute("alert","저장했습니다.");
		}else {
			model.addAttribute("alert","저장이 실패했습니다.(관리자 문의)");
		}
		return "amorJson";
		
	}
	
	@RequestMapping("/admin/theater/seateSelect.do")
	public ModelAndView seateSelect(@RequestParam("theateridx")int tidx,
			@RequestParam("row")int row_s,
			@RequestParam("col")int col_s) {
		TheaterDTO tdto = theaterService.theaterInfo(tidx);
		seat item = new seat();
		int row = 0;
		int col = 0;
		if(tdto.getTheater_row() > row_s) {
			row = tdto.getTheater_row();
		}else {
			row = row_s;
		}
		if(tdto.getTheater_column() > col_s) {
			col = tdto.getTheater_column();
		}else {
			col = col_s;
		}
		String seates = item.addTheater(tdto.getTheater_seat(), row, col);
		ModelAndView mav = new ModelAndView();
		mav.addObject("tidx", tidx);
		mav.addObject("row",row);
		mav.addObject("col",col);
		mav.addObject("theatername", tdto.getTheater_name());
		mav.addObject("seates", seates);
		mav.setViewName("/admin/theater/theaterAdd");
		return mav;
	}
	
	@RequestMapping("/admin/theater/theaterDelete.do")
	public String theaterDelete(@RequestParam("tidx")int tidx,Model model) {
		
		int result = theaterService.theaterDelete(tidx);
		if(result > 0) {
			model.addAttribute("tidx", tidx);
		}else {
			model.addAttribute("alert", "삭제 실패 관리자 문의바랍니다.");
		}
		return "amorJson";
	}
	
}
