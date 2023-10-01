package com.amor.notice.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class NoticeDAOImple implements NoticeDAO {
	
	private SqlSessionTemplate sqlmap;

	public NoticeDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public List<NoticeDTO> noticeList(Map map) {
		List<NoticeDTO>lists=sqlmap.selectList("noticeList", map);
		return lists;
	}
	
	@Override
	public int noticeTotalCnt() {
		int result=sqlmap.selectOne("noticeTotalCnt");
		return result;
	}
	
	@Override
	public int noticeAdd(NoticeDTO dto) {
		int result=sqlmap.insert("noticeAdd", dto);
		return result;
	}
	
	@Override
	public NoticeDTO noticeContent(int idx) {
		NoticeDTO dto=sqlmap.selectOne("noticeContent", idx);
		return dto;
	}
	
	@Override
	public NoticeDTO noticeUpdateForm(int idx) {
		NoticeDTO dto=sqlmap.selectOne("noticeUpdateForm", idx);
		return dto;
	}
	
	@Override
	public int noticeUpdate(NoticeDTO dto) {
		int result=sqlmap.update("noticeUpdate", dto);
		return result;
	}
	
	@Override
	public int noticeDelete(int idx) {
		int result=sqlmap.delete("noticeDelete", idx);
		return result;
	}

	@Override
	public int noticeReadNumUpdate(int notice_idx) {
		int result=sqlmap.update("noticeReadNumUpdate", notice_idx);
		return result;
	}
}
