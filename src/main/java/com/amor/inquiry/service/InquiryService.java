package com.amor.inquiry.service;

import java.util.List;
import java.util.Map;

import com.amor.inquiry.model.InquiryDTO;

public interface InquiryService {

	public List<InquiryDTO> memberInquiryList(int cp, int listSize, int member_idx);
	public int memberInquiryTotalCnt(int member_idx);
	public int inquiryWrite(InquiryDTO dto);
	public List<InquiryDTO> inquiryList(int cp, int listSize);
	public int inquiryAnswer(InquiryDTO dto);
	public int inquiryDelete(int idx);
	
	
	
	
	
	
	
	
	
	public List<InquiryDTO> adminMainInquiryList();

}
