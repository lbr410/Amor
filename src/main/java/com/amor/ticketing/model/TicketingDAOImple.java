package com.amor.ticketing.model;


import org.mybatis.spring.SqlSessionTemplate;


public class TicketingDAOImple implements TicketingDAO {

	private SqlSessionTemplate sqlmap;
			
	public TicketingDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	
}
