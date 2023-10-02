package com.amor.theater.service;

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
}