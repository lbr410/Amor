package com.amor.banner.service;

import java.util.List;

import com.amor.banner.model.BannerDAO;
import com.amor.banner.model.BannerDTO;

public class BannerServiceImple implements BannerService {

	private BannerDAO bannerdao;
	
	public BannerServiceImple(BannerDAO bannerdao) {
		super();
		this.bannerdao = bannerdao;
	}

	@Override
	public List<BannerDTO> bannerList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int bannerAdd(BannerDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public BannerDTO bannerUpdate1(int banner_idx) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int bannerUpdate2(BannerDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int bannerDelete(int banner_idx) {
		// TODO Auto-generated method stub
		return 0;
	}
}
