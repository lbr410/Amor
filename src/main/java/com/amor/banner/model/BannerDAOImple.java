package com.amor.banner.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class BannerDAOImple implements BannerDAO {

	private SqlSessionTemplate sqlmap;

	public BannerDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public List<BannerDTO> bannerList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int bannerAdd(BannerDTO dto) {
		int result = sqlmap.insert("",dto);
		return result;
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
