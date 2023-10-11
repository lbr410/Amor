package com.amor.faq.service;

import java.util.*;
import com.amor.faq.model.*;

public interface FaqService {
	
	public List<FaqDTO> faqList(int cp, int listSize);
	public int faqTotalCnt();
	public int faqWriteAdd(FaqDTO dto);
	public FaqDTO faqContent(int idx);
	public FaqDTO faqUpdateForm(int idx);
	public int faqUpdate(FaqDTO dto);
	public int faqDelete(int idx);
	public List<FaqDTO> userFaqList();
}
