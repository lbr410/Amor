package com.amor.ads.service;

import java.util.List;

import com.amor.ads.model.AdsDTO;

public interface AdsService {
	
	public List<AdsDTO> adsList();
	public int adsAdd(AdsDTO dto);
	public AdsDTO adsUpdate1(int ads_idx);
	public int adsUpdate2(AdsDTO dto);
	public int adsDelete(int ads_idx);

}
