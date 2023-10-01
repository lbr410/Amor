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
	public List<InquiryDTO> inquiryList(Map map) {
		List<InquiryDTO> lists=sqlmap.selectList("inquiryList", map);
		return lists;
	}
	
	@Override
	public int inquiryTotalCnt() {
		int result=sqlmap.selectOne("inquiryTotalCnt");
		return result;
	}
	
	@Override
	public int inquiryWrite(InquiryDTO dto) {
		int result=sqlmap.insert("inquiryWrite", dto);
		return result;
	}
	
	
}
