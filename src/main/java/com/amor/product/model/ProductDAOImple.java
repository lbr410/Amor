package com.amor.product.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class ProductDAOImple implements ProductDAO {
	
	private SqlSessionTemplate sqlmap;
	
	public ProductDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public List<ProductDTO> productList(Map map) {
		List<ProductDTO> lists = sqlmap.selectList("productList", map);
		return lists;
	}
	
	@Override
	public int totalCnt() {
		int count = sqlmap.selectOne("productTotalCnt");
		return count;
	}
	
	@Override
	public int soldOutChange(ProductDTO dto) {
		int count = sqlmap.update("soldOutChange", dto);
		return count;
	}
	
	@Override
	public String prodContent(int product_idx) {
		String content = sqlmap.selectOne("prodContent", product_idx);
		return content;
	}
	
	@Override
	public List<ProductDTO> prodSearchList(Map map) {
		List<ProductDTO> lists = sqlmap.selectList("prodSearchList", map);
		return lists;
	}
	
	@Override
	public int prodSearchTotalCnt(String search) {
		int count = sqlmap.selectOne("prodSearchTotalCnt", search);
		return count;
	}
	
	@Override
	public int productAdd(ProductDTO dto) {
		int count = sqlmap.insert("productAdd", dto);
		return count;
	}
}