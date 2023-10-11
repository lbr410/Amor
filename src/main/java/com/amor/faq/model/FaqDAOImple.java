package com.amor.faq.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

public class FaqDAOImple implements FaqDAO {

	private SqlSessionTemplate sqlmap;

	public FaqDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public List<FaqDTO> faqList(Map map) {
		List<FaqDTO> lists=sqlmap.selectList("faqList", map);
		return lists;
	}
	
	@Override
	public int faqTatalCnt() {
		int result=sqlmap.selectOne("faqTotalCnt");
		return result;
	}
	
	@Override
	public int faqWriteAdd(FaqDTO dto) {
		int result=sqlmap.insert("faqAdd", dto);
		return result;
	}
	
	@Override
	public FaqDTO faqContent(int idx) {
		FaqDTO dto=sqlmap.selectOne("faqContent", idx);
		return dto;
	}
	
	@Override
	public FaqDTO faqUpdateForm(int idx) {
		FaqDTO dto=sqlmap.selectOne("faqUpdateForm", idx);
		return dto;
	}
	
	@Override
	public int faqUpdate(FaqDTO dto) {
		int result=sqlmap.update("faqUpdate", dto);
		return result;
	}
	
	@Override
	public int faqDelete(int idx) {
		int result=sqlmap.delete("faqDelete", idx);
		return result;
	}
	
	@Override
	public List<FaqDTO> userFaqList(Map map) {
		List<FaqDTO> lists=sqlmap.selectList("userFaqList", map);
		return lists;
	}
	
}
