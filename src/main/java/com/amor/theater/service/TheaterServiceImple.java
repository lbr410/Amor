package com.amor.theater.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.amor.theater.model.TheaterDAO;
import com.amor.theater.model.TheaterDTO;

public class TheaterServiceImple implements TheaterService {
	
	private TheaterDAO theaterDao;

	public TheaterServiceImple(TheaterDAO theaterDao) {
		super();
		this.theaterDao = theaterDao;
	}
	
	@Override
	public TheaterDTO theaterInfo(int theater_idx) {
		TheaterDTO dto = theaterDao.theaterInfo(theater_idx);
		return dto;
	}
	
	@Override
	public int theaterAdd() {
		int result = theaterDao.theaterAdd();
		return result;
	}
	
	@Override
	public List<TheaterDTO> theaterSelect() {
		List<TheaterDTO> lists = theaterDao.theaterSelect();
		if(lists != null || lists.size() > 0) {
			return lists;
		}else {
			return null;
		}		
	}
	
	@Override
	public int updateSeate(String name,String seates,int tidx,int totalseat,int row,int col) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("theatername", name);
		map.put("seates", seates);
		map.put("tidx", tidx);
		map.put("totalseat", totalseat);
		map.put("row", row);
		map.put("col", col);
		int result = theaterDao.updateSeate(map);
		return result;
	}
	
	@Override
	public int totalTheater() {
		int result = theaterDao.totalTheater();
		return result;
	}
	
	@Override
	public int theaterDelete(int tidx) {
		int result = theaterDao.theaterDelete(tidx);
		return result;
	}
}