package com.amor.inquiry.service;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import com.amor.inquiry.model.InquiryDAO;
import com.amor.inquiry.model.InquiryDTO;

public class InquiryServiceImple implements InquiryService {

	private InquiryDAO inquiryDao;
	
	
	public InquiryServiceImple(InquiryDAO inquiryDao) {
		super();
		this.inquiryDao = inquiryDao;
	}

	@Override
	public List<InquiryDTO> memberInquiryList(int cp, int listSize, int member_idx) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		map.put("member_idx", member_idx);
		List<InquiryDTO>lists=inquiryDao.memberInquiryList(map);
		return lists;
	}
	
	@Override
	public int memberInquiryTotalCnt(int member_idx) {
		int result=inquiryDao.memberInquiryTotalCnt(member_idx);
		return result;
	}
	
	@Override
	public int inquiryWrite(InquiryDTO dto) {
		int result=inquiryDao.inquiryWrite(dto);
		return result;
	}
	
	@Override
	public List<InquiryDTO> inquiryList(int cp, int listSize) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		List<InquiryDTO>lists=inquiryDao.inquiryList(map);
		return lists;
	}
	
	@Override
	public int inquiryAnswer(InquiryDTO dto) {
		int result=inquiryDao.inquiryAnswer(dto);
		return result;
	}
	
	@Override
	public int inquiryDelete(int idx) {
		int result=inquiryDao.inquiryDelete(idx);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<InquiryDTO> adminMainInquiryList() {
		List<InquiryDTO> lists = inquiryDao.adminMainInquiryList();
		return lists;
	}
}
