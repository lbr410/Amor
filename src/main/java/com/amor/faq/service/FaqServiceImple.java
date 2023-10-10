package com.amor.faq.service;

import java.util.*;

import com.amor.faq.model.*;

public class FaqServiceImple implements FaqService {

	private FaqDAO faqDao;

	public FaqServiceImple(FaqDAO faqDao) {
		super();
		this.faqDao = faqDao;
	}
	
	@Override
	public List<FaqDTO> faqList(int cp, int listSize) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);	
		List<FaqDTO> lists=faqDao.faqList(map);
		
		for(int i=0;i<lists.size();i++) {
			switch (lists.get(i).getFaq_type()) {
			case 1: lists.get(i).setFaq_type2("영화관"); break;
			case 2: lists.get(i).setFaq_type2("회원"); break;
			case 3: lists.get(i).setFaq_type2("온라인"); break;
			case 4: lists.get(i).setFaq_type2("스토어");
			}
		}	
		return lists;
	}
	
	@Override
	public int faqTotalCnt() {
		int result=faqDao.faqTatalCnt();
		return result;
	}
	
	@Override
	public int faqWriteAdd(FaqDTO dto) {
		int result=faqDao.faqWriteAdd(dto);
		return result;
	}
	
	@Override
	public FaqDTO faqContent(int idx) {
		FaqDTO dto=faqDao.faqContent(idx);
		dto.setFaq_content(dto.getFaq_content().replaceAll("\n", "<br>")); 
		return dto;
	}
	
	@Override
	public FaqDTO faqUpdateForm(int idx) {
		FaqDTO dto=faqDao.faqUpdateForm(idx);
		return dto;
	}
	
	@Override
	public int faqUpdate(FaqDTO dto) {
		int result=faqDao.faqUpdate(dto);
		return result;
	}
	
	@Override
	public int faqDelete(int idx) {
		int result=faqDao.faqDelete(idx);
		return result;
	}
}
