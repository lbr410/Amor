package com.amor.payment;

import java.io.*;
import java.net.*;

import lombok.extern.java.Log;
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
import lombok.extern.java.Log;
import com.amor.payment.*;
import com.amor.product.model.ProductDTO;
import com.amor.storePayment.model.StorePaymentDTO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log
public class kakaopay {

    private static final String HOST = "https://kapi.kakao.com";  
    private KakaoPayReadyVO kakaoPayReadyVO;	
    private KakaoPayApprovalVO kakaoPayApprovalVO;
    private static String tid1;  
    
    public String kakaoPayReady(){
    	  	
        RestTemplate restTemplate = new RestTemplate();

        
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK fccc27b54366df53bfa835c02e180aa9");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME"); //테스트 코드 수정X
        params.add("partner_order_id", "1001"); //주문번호
        params.add("partner_user_id", "gorany"); //결제자 id
        params.add("item_name", "콜라"); //결제 상품
        params.add("quantity", "1"); //수량
        params.add("total_amount","2100"); //총 금액
        params.add("tax_free_amount", "100"); //부가세 수정 X
        params.add("approval_url", "http://localhost:9090/amor/store/kakaoOk.do"); 
        params.add("cancel_url", "http://localhost:9090/myweb3/kakaoPayCancel.do");
        params.add("fail_url", "http://localhost:9090/myweb3/kakaoPaySuccessFail.do");

        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

        try {

            kakaoPayReadyVO = restTemplate.postForObject (new URI(HOST + "/v1/payment/ready"), body, KakaoPayReadyVO.class);
            
            log.info("" + kakaoPayReadyVO);
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
    
    
    public KakaoPayApprovalVO kakaoPayInfo(String pg_token) {

        RestTemplate restTemplate = new RestTemplate();
 
        // 서버로 요청할 Header
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","KakaoAK fccc27b54366df53bfa835c02e180aa9");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        
        
        // 서버로 요청할 Body
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME"); 
        params.add("tid", tid1); 
        params.add("partner_order_id", "1001"); //주문번호 동일하게
        params.add("partner_user_id", "gorany"); //결제자 id 동일하게
        params.add("pg_token", pg_token);
        params.add("total_amount", "500"); //총금액 동일하게
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
            kakaoPayApprovalVO = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoPayApprovalVO.class);
            log.info("" + kakaoPayApprovalVO);
          
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
