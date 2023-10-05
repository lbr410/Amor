package com.amor.payment;

import java.util.Date;
import lombok.*;

@Data
public class KakaoPayReadyVO {

	   private String tid;
	   private String next_redirect_pc_url;
	   private Date created_at;
	
}
