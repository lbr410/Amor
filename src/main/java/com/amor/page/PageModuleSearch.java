package com.amor.page;

public class PageModuleSearch {
	public static String makePage(String pagename, int totalCnt, int listSize, int pageSize, int cp, String search) { // 메모리에 바로 올림
		
		int totalPage = totalCnt / listSize + 1;
		if(totalCnt%listSize==0) {totalPage--;}
		int userGroup = cp / pageSize;
		if(cp%pageSize==0) {userGroup--;}
		
		StringBuffer sb = new StringBuffer();

		if(userGroup!=0) {
			sb.append("<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			int temp = (userGroup-1) * pageSize + pageSize;
			sb.append(temp);
			sb.append("&search="+search+"'>&lt;&nbsp;&nbsp;</a>");
		}

		for(int i=userGroup*pageSize+1; i<=userGroup*pageSize+pageSize; i++) {
			String css = i == cp ? "nowPage" : "";
			sb.append("&nbsp;&nbsp;<a class='"+css+"' href='");
			sb.append(pagename);
			sb.append("?cp=");
			sb.append(i);
			sb.append("&search=");
			sb.append(search);
			sb.append("'>");
			sb.append(i);
			sb.append("</a>&nbsp;&nbsp;&nbsp;");
	
			if(i==totalPage) {
				break;
			}
		}

		if(userGroup!=(totalPage/pageSize-(totalPage%pageSize==0 ? 1 : 0))) {
			sb.append("<a href='");
			sb.append(pagename);
			sb.append("?cp=");
			int temp = (userGroup+1) * pageSize + 1;
			sb.append(temp);
			sb.append("&search="+search+"'>&nbsp;&nbsp;&gt;</a>");
		}
		
		return sb.toString();
	}
}