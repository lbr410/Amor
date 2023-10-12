package com.amor.product.service;

import java.text.DecimalFormat;
import java.util.*;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amor.product.model.ProductDAO;
import com.amor.product.model.ProductDTO;
import com.amor.storePayment.model.StorePaymentDTO;

public class ProductServiceImple implements ProductService {
	
	private ProductDAO productDao;
	
	public ProductServiceImple(ProductDAO productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<ProductDTO> productList(int cp, int listSize) {
		DecimalFormat df = new DecimalFormat("#,##0");
		int start = (cp-1) * listSize + 1;
		int end = cp * listSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<ProductDTO> lists = productDao.productList(map);
		for(int i=0; i<lists.size(); i++) {
			int price = lists.get(i).getProduct_price();
			String price_s = df.format(price);
			lists.get(i).setProduct_price2(price_s);
		}
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
		DecimalFormat df=new DecimalFormat("#,##0");
		
		 for (int i = 0; i < lists.size(); i++) {
			 if(lists.get(i).getProduct_soldout().equals("n")) {
			     double product_price=lists.get(i).getProduct_price();  
			     String product_price2=df.format(product_price);
			     lists.get(i).setProduct_price2(product_price2); 		 
			 }else if(lists.get(i).getProduct_soldout().endsWith("y")) {
				 lists.get(i).setProduct_price2("품절");
			 }      
		 }	
		return lists;
	}
	
	@Override
	public List<ProductDTO> storeDrinkList() {
		List<ProductDTO> lists=productDao.storeDrinkList();
		DecimalFormat df=new DecimalFormat("#,##0");
		
		 for (int i = 0; i < lists.size(); i++) {
			 if(lists.get(i).getProduct_soldout().equals("n")) {
			     double product_price=lists.get(i).getProduct_price();  
			     String product_price2=df.format(product_price);
			     lists.get(i).setProduct_price2(product_price2);				 
			 }else if(lists.get(i).getProduct_soldout().equals("y")) {
				 lists.get(i).setProduct_price2("품절");
			 }
		}	
		return lists;
	}
	
	@Override
	public List<ProductDTO> storeSnackList() {
		List<ProductDTO> lists=productDao.storeSnackList();
		DecimalFormat df=new DecimalFormat("#,##0");
		
		 for (int i = 0; i < lists.size(); i++) {
			 if(lists.get(i).getProduct_soldout().equals("n")) {
				 double product_price=lists.get(i).getProduct_price();  
			     String product_price2=df.format(product_price);
			     lists.get(i).setProduct_price2(product_price2);  
			 }else if(lists.get(i).getProduct_soldout().equals("y")) {
				 lists.get(i).setProduct_price2("품절");
			 }    	        
		}	
		return lists;
	}
	
	@Override
	public ProductDTO storeContent(int idx) {
		DecimalFormat df=new DecimalFormat("#,##0");
		ProductDTO dto=productDao.storeContent(idx);
		String product_price2=df.format(dto.getProduct_price());
		dto.setProduct_price2(product_price2);
		dto.setProduct_content(dto.getProduct_content().replaceAll("\n", "<br>"));
		return dto;
	}
	
	@Override
	public ProductDTO storePayForm(int idx, int num) {
		DecimalFormat df=new DecimalFormat("#,##0");
		ProductDTO dto=productDao.storePayForm(idx);	
		String product_price2=df.format(dto.getProduct_price()*num);
		dto.setProduct_price2(product_price2);
		return dto;
	}
	
	@Override
	public ProductDTO storeKakao(int idx, int num) {
		ProductDTO dto=productDao.storeKakao(idx);
		DecimalFormat df=new DecimalFormat("#,##0");
		String product_price2=df.format(dto.getProduct_price()*num);
		dto.setProduct_price2(product_price2);
		dto.setTotalnum(num);
		return dto;
	}
	
	@Override
	public List<ProductDTO> indexSnack() {
		DecimalFormat df = new DecimalFormat("#,##0");
		Map map = new HashMap();

		List<ProductDTO> slists = productDao.indexSnack(map);
		for(int i=0; i<slists.size(); i++) {
			int price = slists.get(i).getProduct_price();
			String price_s = df.format(price);
			slists.get(i).setProduct_price2(price_s);
		}
		return slists;
	}
	
	@Override
	public List<ProductDTO> indexDrink() {
		DecimalFormat df = new DecimalFormat("#,##0");
		Map map = new HashMap();

		List<ProductDTO> dlists = productDao.indexDrink(map);
		for(int i=0; i<dlists.size(); i++) {
			int price = dlists.get(i).getProduct_price();
			String price_s = df.format(price);
			dlists.get(i).setProduct_price2(price_s);
		}
		return dlists;
	}
	@Override
	public List<ProductDTO> indexTicket() {
		DecimalFormat df = new DecimalFormat("#,##0");
		Map map = new HashMap();

		List<ProductDTO> tlists = productDao.indexTicket(map);
		for(int i=0; i<tlists.size(); i++) {
			int price = tlists.get(i).getProduct_price();
			String price_s = df.format(price);
			tlists.get(i).setProduct_price2(price_s);
		}
		return tlists;
	}
}
