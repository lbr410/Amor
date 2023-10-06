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
	public List<AdsDTO> bannerList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int bannerAdd(AdsDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public AdsDTO bannerUpdate1(int ads_idx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int bannerUpdate2(AdsDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int bannerDelete(int ads_idx) {
		// TODO Auto-generated method stub
		return 0;
	}

}
