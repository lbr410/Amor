package com.amor.etc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class seat {

	public String addTheater(String seates,int row,int col) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String[][] data = objectMapper.readValue(seates,String[][].class);
			for(int i = 0 ; i < row ; i++) {
				for(int j = 0 ; j < col ;j++) {
					System.out.print(data[i][j]);
				}
				System.out.println();
			}
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuffer sb = new StringBuffer();
		
    	int num = 0;
    	
		for(int i = 0 ; i < row; i++) {
			sb.append("<br>");
			for(int j = 1 ; j <= col; j++) {
			num++;
			//체크박스(좌석)
			sb.append("<input type='checkbox' id = 'checkbox"+num+"' value = '"+i+","+j+"' name = 'seates'>");
			sb.append("<label for='checkbox"+num+"'>");
			// 각좌석의 번호를 보여주는 div태그
			sb.append("<div class = 'checkbox-label' id = 'boxnum"+num+"' name = '"+i+"' value = '"+j+"'>"+j+"</div>");		
			sb.append("</label>");
			sb.append("&nbsp;&nbsp;");
			}
		}
		return sb.toString();
	}
}
