package com.amor.ads.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class AdsDAOImple implements AdsDAO {

	private SqlSessionTemplate sqlmap;

	public AdsDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public List<AdsDTO> adsList() {
		List<AdsDTO> lists = sqlmap.selectList("adsList");
		return lists;
	}
	
	@Override
	public int adsAdd(AdsDTO dto) {
		int result = sqlmap.insert("adsAdd",dto);
		return result;
	}
	
	@Override
	public AdsDTO adsUpdate1(int ads_idx) {
		AdsDTO dto = sqlmap.selectOne("adsUpdate1", ads_idx);
		return dto;
	}
	
	@Override
	public int adsUpdate2(AdsDTO dto) {
		int result = sqlmap.update("adsUpdate2", dto);
		return result;
	}
	
	@Override
	public int adsDelete(int ads_idx) {
		int result = sqlmap.delete("adsDelete", ads_idx);
		return result;
	}
	
	
	
}
