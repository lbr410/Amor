package com.amor.adminController;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.inquiry.model.InquiryDTO;
import com.amor.inquiry.service.InquiryService;

@Controller
public class InquiryListController {

	@Autowired
	private InquiryService inquiryService;
	
	
	
}
