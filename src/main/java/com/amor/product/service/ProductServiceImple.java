package com.amor.product.service;

import java.text.DecimalFormat;
import java.util.*;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amor.product.model.ProductDAO;
import com.amor.product.model.ProductDTO;

public class ProductServiceImple implements ProductService {
	
	private ProductDAO productDao;
	
	public ProductServiceImple(ProductDAO productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<ProductDTO> productList(int cp, int listSize) {
		int start = (cp-1) * listSize + 1;
		int end = cp * listSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<ProductDTO> lists = productDao.productList(map);
		return lists;
	}
	
	@Override
	public int totalCnt() {
		int count = productDao.totalCnt();
		return count;
	}
	
	@Override
	public int soldOutChange(ProductDTO dto) {
		int count = productDao.soldOutChange(dto);
		return count;
	}
	
	@Override
	public String prodContent(int product_idx) {
		String content = productDao.prodContent(product_idx);
		return content;
	}
	
	@Override
	public List<ProductDTO> prodSearchList(int cp, int listSize, String search) {
		int start = (cp-1) * listSize + 1;
		int end = cp * listSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("search", search);
		
		List<ProductDTO> lists = productDao.prodSearchList(map);
		return lists;
	}
	
	@Override
	public int prodSearchTotalCnt(String search) {
		int count = productDao.prodSearchTotalCnt(search);
		return count;
	}
	
	@Override
	public int productAdd(ProductDTO dto) {
		int count = productDao.productAdd(dto);
		return count;
	}
	
	@Override
	public ProductDTO productSelectIdx(int product_idx) {
		ProductDTO dto = productDao.productSelectIdx(product_idx);
		return dto;
	}
	
	@Override
	public int productUpdate(ProductDTO dto) {
		int count = productDao.productUpdate(dto);
		return count;
	}
	
	@Override
	public int productDel(int product_idx) {
		int count = productDao.productDel(product_idx);
		return count;
	}
	
	@Override
	public List<ProductDTO> storeTicketList() {
		List<ProductDTO> lists=productDao.storeTicketList();
		DecimalFormat df=new DecimalFormat("#,##0원");
		
		 for (int i = 0; i < lists.size(); i++) {
			 System.out.println(df.format(lists.get(i).getProduct_price()));
		        double product_price=lists.get(i).getProduct_price();  
		        String product_price2=df.format(product_price);
		        lists.get(i).setProduct_price2(product_price2); 	        
		    }	
		return lists;
	}
	
	@Override
	public List<ProductDTO> storeDrinkList() {
		List<ProductDTO> lists=productDao.storeDrinkList();
		DecimalFormat df=new DecimalFormat("#,##0원");
		
		 for (int i = 0; i < lists.size(); i++) {
			 System.out.println(df.format(lists.get(i).getProduct_price()));
		        double product_price=lists.get(i).getProduct_price();  
		        String product_price2=df.format(product_price);
		        lists.get(i).setProduct_price2(product_price2); 	        
		    }	
		return lists;
	}
	
	@Override
	public List<ProductDTO> storeSnackList() {
		List<ProductDTO> lists=productDao.storeSnackList();
		DecimalFormat df=new DecimalFormat("#,##0원");
		
		 for (int i = 0; i < lists.size(); i++) {
			 System.out.println(df.format(lists.get(i).getProduct_price()));
		        double product_price=lists.get(i).getProduct_price();  
		        String product_price2=df.format(product_price);
		        lists.get(i).setProduct_price2(product_price2); 	        
		    }	
		return lists;
	}
	
	@Override
	public ProductDTO storeContent(int idx) {
		DecimalFormat df=new DecimalFormat("#,##0");
		ProductDTO dto=productDao.storeContent(idx);
		String product_price2=df.format(dto.getProduct_price());
		dto.setProduct_price2(product_price2);
		
		return dto;
	}
}
