package com.amor.payment;

import java.io.*;
import java.net.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.http.HttpEntity;
import com.amor.payment.*;
import lombok.extern.java.Log;


public class Kakaopay {
	
    private static final String HOST = "https://kapi.kakao.com";  
    private KakaoPayReadyVO kakaoPayReadyVO;	
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    private static String tid1;
    
	   public String kakaoPayReady(KakaopayDTO kdto) {
		   
		   
	        RestTemplate restTemplate = new RestTemplate();
	 
	        // 서버로 요청할 Header
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Authorization", "KakaoAK fccc27b54366df53bfa835c02e180aa9");
	        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
	        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
	        
	        // 서버로 요청할 Body
	        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	        params.add("cid", "TC0ONETIME");
	        params.add("partner_order_id", kdto.getPartner_order_id());
	        params.add("partner_user_id", kdto.getPartner_user_id());
	        params.add("item_name", kdto.getItem_name());
	        params.add("quantity", kdto.getQuantity());
	        params.add("total_amount", kdto.getTotal_amount());
	        params.add("tax_free_amount", "100");
	        params.add("approval_url", kdto.getApproval_url());
	        params.add("cancel_url", kdto.getCancel_url());
	        params.add("fail_url", kdto.getFail_url());
	 
	         HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
	 
	        try {
	            kakaoPayReadyVO = restTemplate.postForObject (new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
	            
	            tid1=kakaoPayReadyVO.getTid();
	            
	            return kakaoPayReadyVO.getNext_redirect_pc_url();
	 
	        } catch (RestClientException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (URISyntaxException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        return "";
	        
	    }	
	   
	   
	    public KakaoPayApprovalVO kakaoPayInfo (String pg_token, KakaopayDTO kdto) {
	    	 
	        System.out.println("kakaInfo1");
	        RestTemplate restTemplate = new RestTemplate();
	 
	        // 서버로 요청할 Header
	        HttpHeaders headers = new HttpHeaders();
	        System.out.println("kakaInfo2");
	        headers.add("Authorization","KakaoAK fccc27b54366df53bfa835c02e180aa9");
	        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
	        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");	        
	        
	        // 서버로 요청할 Body
	        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	        params.add("cid", "TC0ONETIME");
	        params.add("tid", tid1);
	        params.add("partner_order_id", kdto.getPartner_order_id());
	        params.add("partner_user_id", kdto.getPartner_user_id());
	        params.add("pg_token", pg_token);
	        params.add("total_amount", kdto.getTotal_amount());
	        
	        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
	        
	        try {
	            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
	          
	            return kakaoPayApprovalVO;
	        
	        } catch (RestClientException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (URISyntaxException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        return null;
	    }

}
