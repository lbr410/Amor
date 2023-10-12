package com.amor.notice.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.amor.notice.model.*;

@Service
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

	@Override
	public List<NoticeDTO> userNoticeList(int cp, int listSize) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<NoticeDTO>lists=noticeDao.userNoticeList(map);
		return lists;
	}
	
	@Override
	public int userNoticeTotalCnt() {
		int result=noticeDao.userNoticeTotalCnt();
		return result;
	}
	@Override
	public NoticeDTO userNoticeContnet(int idx) {
		NoticeDTO dto=noticeDao.userNoticeContent(idx);
		dto.setNotice_content(dto.getNotice_content().replaceAll("\n", "<br>"));
		return dto;
	}
	
	@Override
	public int noticeReadNumUpdate(int notice_idx) {
		int result=noticeDao.noticeReadNumUpdate(notice_idx);
		return result;
	}
}
