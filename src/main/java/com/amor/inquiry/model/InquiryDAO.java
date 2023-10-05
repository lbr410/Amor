package com.amor.inquiry.model;
import java.util.*;
public interface InquiryDAO {

	public List<InquiryDTO> memberInquiryList(Map map);
	public int memberInquiryTotalCnt(int member_idx);
	public int inquiryWrite(InquiryDTO dto);
	public int inquiryDelete(int idx);
	public List<InquiryJoinDTO> adminInquiryList(Map map);
	public int inquiryBlock(Map map);
	public int inquiryTotalCnt();
	public InquiryJoinDTO inquiryContent(int idx);
	public int inquiryAnswer(InquiryJoinDTO dto);
	
	
	
	
	
	
	
	
	
	public List<InquiryDTO> adminMainInquiryList();
}
