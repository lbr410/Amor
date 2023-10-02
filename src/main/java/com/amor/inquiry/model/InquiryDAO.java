package com.amor.inquiry.model;
import java.util.*;
public interface InquiryDAO {

	public List<InquiryDTO> memberInquiryList(Map map);
	public int inquiryTotalCnt();
	public int inquiryWrite(InquiryDTO dto);
	public List<InquiryDTO> inquiryList(Map map);
	public int inquiryAnswer(InquiryDTO dto);
	public int inquiryDelete(int idx);
}
