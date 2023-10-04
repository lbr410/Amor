package com.amor.inquiry.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class InquiryDAOImple implements InquiryDAO {

	private SqlSessionTemplate sqlmap;
	
	
	
	public InquiryDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public List<InquiryDTO> memberInquiryList(Map map) {
		List<InquiryDTO> lists=sqlmap.selectList("memberInquiryList", map);
		return lists;
	}
	
	@Override
	public int memberInquiryTotalCnt(int member_idx) {
		int result=sqlmap.selectOne("memberInquiryTotalCnt", member_idx);
		return result;
	}
	
	@Override
	public int inquiryWrite(InquiryDTO dto) {
		int result=sqlmap.insert("inquiryWrite", dto);
		return result;
	}
	
	@Override
	public List<InquiryDTO> inquiryList(Map map) {
		List<InquiryDTO> lists=sqlmap.selectList("inquiryList", map);
		return null;
	}
	
	@Override
	public int inquiryAnswer(InquiryDTO dto) {
		int result=sqlmap.update("inquiryAnswer", dto);
		return result;
	}
	
	@Override
	public int inquiryDelete(int inquiry_idx) {
		int result=sqlmap.delete("inquiryDelete", inquiry_idx);
		return result;
	}
}
