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
	public List<InquiryJoinDTO> adminInquiryList(Map map) {
		List<InquiryJoinDTO> lists=sqlmap.selectList("adminInquiryList", map);
		return lists;
	}
	
	@Override
	public int inquiryBlock(Map map) {
		int result=sqlmap.update("inquiryBlock", map);
		return result;
	}
	
	@Override
	public int inquiryTotalCnt() {
		int result=sqlmap.selectOne("inquiryTotalCnt");
		return result;
	}
	
	@Override
	public InquiryJoinDTO inquiryContent(int idx) {
		InquiryJoinDTO dto=sqlmap.selectOne("inquiryContent", idx);
		dto.setInquiry_content(dto.getInquiry_content().replaceAll("\n", "<br>")); 
		dto.setInquiry_content(dto.getInquiry_answer().replaceAll("\n", "<br>"));
		return dto;
	}
	
	@Override
	public int inquiryAnswer(InquiryJoinDTO dto) {
		int result=sqlmap.update("inquiryAnswer", dto);
		dto.setInquiry_content(dto.getInquiry_answer().replaceAll("\n", "<br>"));
		return result;
	}
	
	@Override
	public int inquiryDelete(int inquiry_idx) {
		int result=sqlmap.delete("inquiryDelete", inquiry_idx);
		return result;
	}
	
	@Override
	public InquiryJoinDTO inquiryUpdateForm(int idx) {
		InquiryJoinDTO dto=sqlmap.selectOne("inquiryUpdateForm", idx);
		return dto;
	}
	@Override
	public List<InquiryDTO> adminMainInquiryList() {
		List<InquiryDTO> lists = sqlmap.selectList("adminMainInquiryList");
		return lists;
	}
}
