package com.amor.ads.service;

import java.util.List;

import com.amor.ads.model.AdsDTO;

public interface AdsService {
	
	public List<AdsDTO> bannerList();
	public int bannerAdd(AdsDTO dto);
	public AdsDTO bannerUpdate1(int ads_idx);
	public int bannerUpdate2(AdsDTO dto);
	public int bannerDelete(int ads_idx);

}
