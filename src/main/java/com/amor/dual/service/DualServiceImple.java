package com.amor.dual.service;

import java.text.DecimalFormat;
import java.util.List;

import com.amor.dual.model.DualDAO;
import com.amor.dual.model.DualDTO;

public class DualServiceImple implements DualService {
	
	private DualDAO dualDao;
	DecimalFormat df = new DecimalFormat("#,###");

	public DualServiceImple(DualDAO dualDao) {
		super();
		this.dualDao = dualDao;
	}
	
	@Override
	public List<DualDTO> chartData() {
		List<DualDTO> lists = dualDao.chartData();
		return lists;
	}
	
	@Override
	public List<DualDTO> threeTableResult() {
		List<DualDTO> lists = dualDao.threeTableResult();
		return lists;
	}
	
	@Override
	public List<DualDTO> salesChartData() {
		List<DualDTO> lists = dualDao.salesChartData();
		return lists;
	}
}