package com.amor.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amor.notice.model.*;

public class NoticeServiceImple implements NoticeService {

	private NoticeDAO noticeDao;

	public NoticeServiceImple(NoticeDAO noticeDao) {
		super();
		this.noticeDao = noticeDao;
	}
	
	@Override
	public List<NoticeDTO> noticeList(int cp, int listSize) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<NoticeDTO>lists=noticeDao.noticeList(map);
		return lists;
	}
	
	@Override
	public int noticeTotalCnt() {
		int result=noticeDao.noticeTotalCnt();
		return result;
	}
	
	@Override
	public int noticeAdd(NoticeDTO dto) {
		int result=noticeDao.noticeAdd(dto);
		return result;
	}
	
	@Override
	public NoticeDTO noticeContnet(int idx) {
		NoticeDTO dto=noticeDao.noticeContent(idx);
		dto.setNotice_content(dto.getNotice_content().replaceAll("\n", "<br>"));
		return dto;
	}
	
	@Override
	public NoticeDTO noticeUpdateForm(int idx) {
		NoticeDTO dto=noticeDao.noticeUpdateForm(idx);
		return dto;
	}
	
	@Override
	public int noticeUpdate(NoticeDTO dto) {
		int result=noticeDao.noticeUpdate(dto);
		return result;
	}

	@Override
	public int noticeDelete(int idx) {
		int result=noticeDao.noticeDelete(idx);
		return result;
	}
}
