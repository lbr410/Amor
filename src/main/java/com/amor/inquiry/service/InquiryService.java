package com.amor.inquiry.service;

import java.util.List;
import java.util.Map;

import com.amor.inquiry.model.InquiryDTO;

public interface InquiryService {

	public List<InquiryDTO> inquiryList(int cp, int listSize);
	public int inquiryTotalCnt();
	public int inquiryWrite(InquiryDTO dto);
}
