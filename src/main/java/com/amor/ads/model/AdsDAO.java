package com.amor.ads.model;

import java.util.List;

public interface AdsDAO {

	public List<AdsDTO> adsList();
	public int adsAdd(AdsDTO dto);
	public AdsDTO adsUpdate1(int ads_idx);
	public int adsUpdate2(AdsDTO dto);
	public int adsDelete(int ads_idx);
	
}
