package com.amor.ads.service;

import java.util.List;

import com.amor.ads.model.AdsDAO;
import com.amor.ads.model.AdsDTO;

public class AdsServiceImple implements AdsService {
	
	private AdsDAO adsdao;

	public AdsServiceImple(AdsDAO adsdao) {
		super();
		this.adsdao = adsdao;
	}

	@Override
	public List<AdsDTO> adsList() {
		List<AdsDTO> lists = adsdao.adsList();
		return lists;
	}
	
	@Override
	public int adsAdd(AdsDTO dto) {
		int result = adsdao.adsAdd(dto);
		return result;
	}
	
	@Override
	public AdsDTO adsUpdate1(int ads_idx) {
		AdsDTO dto = adsdao.adsUpdate1(ads_idx);
		return dto;
	}
	
	@Override
	public int adsUpdate2(AdsDTO dto) {
		int result = adsdao.adsUpdate2(dto);
		return result;
	}
	
	@Override
	public int adsDelete(int ads_idx) {
		int result = adsdao.adsDelete(ads_idx);
		return result;
	}

}
