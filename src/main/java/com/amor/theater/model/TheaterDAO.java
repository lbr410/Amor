package com.amor.theater.model;

import java.util.List;
import java.util.Map;

public interface TheaterDAO {
	public TheaterDTO theaterInfo(int theater_idx);
	
	public int theaterAdd();
	public List<TheaterDTO> theaterSelect();
	public int updateSeate(Map<String, Object> map);
	public int totalTheater();
	public int theaterDelete(int tidx);
}