package com.amor.theater.model;

import java.util.List;

public interface TheaterDAO {
	public TheaterDTO theaterInfo(int theater_idx);
	
	public int theaterAdd();
	public List<TheaterDTO> theaterSelect();
	public List<TheaterDTO> seatesSelect(int theateridx);
}