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
		List<BannerDTO> lists = sqlmap.selectList("bannerList");
		return lists;
	}
	
	@Override
	public int bannerAdd(BannerDTO dto) {
		int result = sqlmap.insert("bannerAdd",dto);
		return result;
	}
	
	@Override
	public BannerDTO bannerUpdate1(int banner_idx) {
		BannerDTO dto = sqlmap.selectOne("bannerUpdate1",banner_idx);
		return dto;
	}
	
	@Override
	public int bannerUpdate2(BannerDTO dto) {
		int result = sqlmap.update("bannerUpdate2", dto);
		return result;
	}
	
	@Override
	public int bannerDelete(int banner_idx) {
		int result = sqlmap.delete("bannerDelete",banner_idx);
		return result;
	}
	
	
	
	
}
