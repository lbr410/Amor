package com.amor.db;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class AmorDB {
	
	static DataSource ds; // 비디오가게를 할당받을 수 있다.
	
	static { // static블록 - 프로그램이 시작되는 시점부터 메모리에 올려줌
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch(Exception e) {
			
		}
	}
	
	public static Connection getConn() throws Exception { // static을 붙이면 이름으로 호출하여 쓰면됨
	 	// 예외상황을 나를 호출했던 것에 떠넘김
		return ds.getConnection();
	}
}