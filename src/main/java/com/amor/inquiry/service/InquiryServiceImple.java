package com.amor.inquiry.service;
import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import com.amor.inquiry.model.InquiryDAO;
import com.amor.inquiry.model.InquiryDTO;
import com.amor.inquiry.model.InquiryJoinDTO;

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
		for(int i=0;i<lists.size();i++) {
			lists.get(i).setInquiry_answer(lists.get(i).getInquiry_answer().replaceAll("\n", "<br>"));
		}
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
	public List<InquiryJoinDTO> adminInquiryList(int cp, int listSize) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		List<InquiryJoinDTO>lists=inquiryDao.adminInquiryList(map);
		for(int i=0;i<lists.size();i++) {
			lists.get(i).setInquiry_answer(lists.get(i).getInquiry_answer().replaceAll("\n", "<br>"));
		}
		return lists;
	}
	
	@Override
	public int inquiryBlock(int inquiry_idx, String value) {
		Map map=new HashedMap();
		map.put("inquiry_idx", inquiry_idx);
		map.put("value", value);
		int result=inquiryDao.inquiryBlock(map);
		return result;
	}
	@Override
	public int inquiryTotalCnt() {
		int result=inquiryDao.inquiryTotalCnt();
		return result;
	}
	
	@Override
	public InquiryJoinDTO inquiryContent(int idx) {
		InquiryJoinDTO dto=inquiryDao.inquiryContent(idx);
		dto.setInquiry_content(dto.getInquiry_content().replaceAll("\n", "<br>"));
		return dto;
	}
	
	@Override
	public int inquiryAnswer(InquiryJoinDTO dto) {
		int result=inquiryDao.inquiryAnswer(dto);
		return result;
	}
	
	@Override
	public InquiryJoinDTO inquiryUpdateForm(int idx) {
		InquiryJoinDTO dto=inquiryDao.inquiryContent(idx);
		dto.setInquiry_content(dto.getInquiry_content().replaceAll("\n", "<br>"));
		return dto;
	}
	
	@Override
	public int inquiryDelete(int inquiry_idx) {
		int result=inquiryDao.inquiryDelete(inquiry_idx);
		return result;
	}

	@Override
	public List<InquiryDTO> adminMainInquiryList() {
		List<InquiryDTO> lists = inquiryDao.adminMainInquiryList();
		return lists;
	}
}
