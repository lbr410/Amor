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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int adsAdd(AdsDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public AdsDTO adsUpdate1(int ads_idx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int adsUpdate2(AdsDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int adsDelete(int ads_idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
