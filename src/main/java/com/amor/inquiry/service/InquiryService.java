package com.amor.inquiry.service;

import java.util.List;
import java.util.Map;

import com.amor.inquiry.model.InquiryDTO;
import com.amor.inquiry.model.InquiryJoinDTO;

public interface InquiryService {

	public List<InquiryDTO> memberInquiryList(int cp, int listSize, int member_idx);
	public int memberInquiryTotalCnt(int member_idx);
	public int inquiryWrite(InquiryDTO dto);
	public int inquiryDelete(int idx);
	public List<InquiryJoinDTO> adminInquiryList(int cp, int listSize);
	public int inquiryBlock(int inquiry_block, String value);
	public int inquiryTotalCnt();
	public InquiryJoinDTO inquiryContent(int idx);
	public int inquiryAnswer(InquiryJoinDTO dto);
	public InquiryJoinDTO inquiryUpdateForm(int idx);
	public List<InquiryDTO> adminMainInquiryList();

	
}