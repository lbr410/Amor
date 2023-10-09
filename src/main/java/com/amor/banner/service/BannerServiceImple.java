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
		List<BannerDTO> lists = bannerdao.bannerList();
		return lists;
	}
	
	@Override
	public int bannerAdd(BannerDTO dto) {
		int result = bannerdao.bannerAdd(dto);
		return result;
	}
	
	@Override
	public BannerDTO bannerUpdate1(int banner_idx) {
		BannerDTO dto = bannerdao.bannerUpdate1(banner_idx);
		return dto;
	}
	
	@Override
	public int bannerUpdate2(BannerDTO dto) {
		int result = bannerdao.bannerUpdate2(dto);
		return result;
	}
	
	@Override
	public int bannerDelete(int banner_idx) {
		int result = bannerdao.bannerDelete(banner_idx);
		return result;
	}
}
