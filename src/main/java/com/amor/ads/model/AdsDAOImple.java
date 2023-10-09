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
