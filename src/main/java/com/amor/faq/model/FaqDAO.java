package com.amor.faq.model;

import java.util.*;

public interface FaqDAO {
	
	public List<FaqDTO> faqList(Map map);
	public int faqTatalCnt();
	public int faqWriteAdd(FaqDTO dto);
	public FaqDTO faqContent(int idx);
	public FaqDTO faqUpdateForm(int idx);
	public int faqUpdate(FaqDTO dto);
	public int faqDelete(int idx);
	public List<FaqDTO> userFaqList(Map map);
}