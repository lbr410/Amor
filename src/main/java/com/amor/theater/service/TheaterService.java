package com.amor.theater.service;

import java.util.List;
import java.util.Map;

import com.amor.theater.model.TheaterDTO;

public interface TheaterService {
	public TheaterDTO theaterInfo(int theater_idx);
	
	public int theaterAdd();
	public List<TheaterDTO> theaterSelect();
	public int updateSeate(String name,String seates, int tidx,int totalseat,int row,int col);
	public int totalTheater();
	public int theaterDelete(int tidx);
}