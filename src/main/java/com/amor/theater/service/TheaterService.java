package com.amor.theater.service;

import java.util.List;

import com.amor.theater.model.TheaterDTO;

public interface TheaterService {
	public TheaterDTO theaterInfo(int theater_idx);
	
	public int theaterAdd();
	public List<TheaterDTO> theaterSelect();
	public List<TheaterDTO> seatesSelect(int theateridx);
}