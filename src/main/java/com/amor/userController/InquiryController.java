package com.amor.userController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.DefaultValueStyler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.amor.inquiry.model.InquiryDTO;
import com.amor.inquiry.service.InquiryService;
import com.amor.notice.model.NoticeDTO;

@Controller
public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;
	
	//사용자 1:1문의 리스트
	@RequestMapping("myAmor/memberInquiryList.do")
	public ModelAndView inquiryList(
			HttpSession session,
			@RequestParam(value="cp", defaultValue="1")int cp) {
		
		int member_idx=(Integer)session.getAttribute("sidx");
		InquiryDTO dto=new InquiryDTO();
		dto.setMember_idx(member_idx);
		String sid = (String)session.getAttribute("sid");
		int totalCnt=inquiryService.memberInquiryTotalCnt(member_idx);
		int listSize=5;
		int pageSize=5;
		String pageStr=com.amor.page.PageModule.makePage("memberInquiryList.do", totalCnt, listSize, pageSize, cp);
		
		List<InquiryDTO>lists=inquiryService.memberInquiryList(cp, listSize, member_idx);

		ModelAndView mav=new ModelAndView();
		mav.addObject("lists", lists);
		mav.addObject("pageStr", pageStr);
		mav.setViewName("/user/myAmor/inquiryList");
		return mav;
	}
	
	//사용자 1:1문의 작성 폼으로 이동
	@RequestMapping("myAmor/inquiryWrite.do")
	public String inquiryWriteForm() {
  
		return "/user/myAmor/inquiryWrite";

	}
	//사용자 1:1문의 작성
	@RequestMapping(value="myAmor/inquiryWrite.do", method = RequestMethod.POST)
	public ModelAndView inquiryWrite(
			HttpSession session,
			MultipartHttpServletRequest req) {
		
		MultipartFile upl = req.getFile("inquiry_filename");
		String upload = upl.getOriginalFilename();
		String noExt = upload.substring(0, upload.lastIndexOf('.'));
		String ext = upload.substring(upload.lastIndexOf(".") + 1);
		
		String savePath = req.getRealPath("/resources/upload/inquiry/");
		String saveFileName="";
		
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
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		int member_idx=(Integer)session.getAttribute("sidx");
		
		InquiryDTO dto=new InquiryDTO();
		dto.setMember_idx(member_idx);
		dto.setInquiry_subject(req.getParameter("inquiry_subject"));
		dto.setInquiry_content(req.getParameter("inquiry_content"));
		dto.setInquiry_filename(req.getFile("inquiry_filename").getOriginalFilename());
		String type=req.getParameter("inquiry_type");
		int inquiry_type=Integer.parseInt(type);
		dto.setInquiry_type(inquiry_type);
		int result=inquiryService.inquiryWrite(dto);
		String msg=result>0?"문의가 등록되었습니다.":"문의 등록 실패했습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("href","user/myAmor/inquiryWrite.do"); 
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}
	
	@RequestMapping("myAmor/inquiryListDels.do")
	public String inquiryDel(@RequestParam("inquiry_idx") int idx) {
		inquiryService.inquiryDelete(idx);
		
		return "redirect:memberInquiryList.do";
	}
}
