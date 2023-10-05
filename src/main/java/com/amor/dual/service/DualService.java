package com.amor.dual.service;

import java.util.*;

import com.amor.dual.model.DualDTO;

public interface DualService {
	public List<DualDTO> chartData();
	public List<DualDTO> threeTableResult();
	public List<DualDTO> salesChartData();
}