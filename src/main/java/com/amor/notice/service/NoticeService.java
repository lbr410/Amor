package com.amor.notice.service;

import java.util.*;

import com.amor.notice.model.*;

public interface NoticeService {
	
	public List<NoticeDTO> noticeList(int cp, int listSize);
	public int noticeTotalCnt();
	public int noticeAdd(NoticeDTO dto);
	public NoticeDTO noticeContnet(int idx);
	public NoticeDTO noticeUpdateForm(int idx);
	public int noticeUpdate(NoticeDTO dto);
	public int noticeDelete(int idx);
}
