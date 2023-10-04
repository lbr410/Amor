package com.amor.theater.service;

import java.util.List;

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
	public List<TheaterDTO> seatesSelect(int theateridx) {
		List<TheaterDTO> list = theaterDao.seatesSelect(theateridx);
		return null;
	}
	
}