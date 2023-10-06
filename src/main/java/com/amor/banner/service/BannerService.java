package com.amor.banner.service;
import java.util.*;
import com.amor.banner.model.BannerDTO;

public interface BannerService {
	
	public List<BannerDTO> bannerList();
	public int bannerAdd(BannerDTO dto);
	public BannerDTO bannerUpdate1(int banner_idx);
	public int bannerUpdate2(BannerDTO dto);
	public int bannerDelete(int banner_idx);
	
}
