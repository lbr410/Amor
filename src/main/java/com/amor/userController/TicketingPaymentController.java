package com.amor.userController;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.ticketing.model.TicketingPayingJoinDTO;
import com.amor.ticketing.service.TicketingService;

@Controller
public class TicketingPaymentController {
	
	@Autowired
	private TicketingService ticketingService;

	@RequestMapping(value = "ticketing/ticketingPayment.do", method = RequestMethod.POST)
	public ModelAndView ticketingPayment(
			@RequestParam("movie_idx") int movie_idx,
			@RequestParam("theater_idx") int theater_idx,
			@RequestParam("playing_movie_idx") int playing_movie_idx,
			@RequestParam("playing_movie_seat") String playing_movie_seat[],
			@RequestParam("adultC") int adultC,
			@RequestParam("teenagerC") int teenagerC,
			@RequestParam("seniorC") int seniorC,
			@RequestParam("disabledC") int disabledC,
			@RequestParam("ticketing_personnel") int ticketing_personnel,
			@RequestParam("ticketing_price") int ticketing_price
			) {
		
		TicketingPayingJoinDTO dto = ticketingService.ticketingPaying(movie_idx, theater_idx, playing_movie_idx);
		String movie_poster = dto.getMovie_poster();
		String movie_name = dto.getMovie_name();
		String playing_movie_start = dto.getPlaying_movie_start();
		String theater_name = dto.getTheater_name();		
		
		String playing_movie_seat_num = "";
		for (int i = 0 ; i<playing_movie_seat.length;i++) {
			if (playing_movie_seat.length == 0) {
			playing_movie_seat_num = playing_movie_seat[i]; 
			} else {
				if (playing_movie_seat.length-1==i) {
					playing_movie_seat_num += playing_movie_seat[i];
					break;
				}
				playing_movie_seat_num += playing_movie_seat[i]+", ";	
			}
		}		
		
		String playing_movie_start_cut = playing_movie_start.substring(0, 16);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("movie_idx", movie_idx);
		mav.addObject("theater_idx", theater_idx);
		mav.addObject("playing_movie_idx", playing_movie_idx);
		mav.addObject("playing_movie_seat", playing_movie_seat_num);
		mav.addObject("adultC", adultC);
		mav.addObject("teenagerC", teenagerC);
		mav.addObject("seniorC", seniorC);
		mav.addObject("disabledC", disabledC);
		mav.addObject("ticketing_personnel", ticketing_personnel);
		mav.addObject("ticketing_price", ticketing_price);
		mav.addObject("movie_poster", movie_poster);
		mav.addObject("playing_movie_start", playing_movie_start_cut);
		mav.addObject("movie_name", movie_name);
		mav.addObject("theater_name", theater_name);
		mav.setViewName("/user/ticketing/ticketingPayment");
		return mav;
	}
	
	@RequestMapping("ticketing/ticketingPayDetail.do")
	public ModelAndView ticketingPayingSuccess () {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/ticketing/ticketingPayment");
		return mav;
	}
	
	@RequestMapping(value = "ticketing/ticketingPayment.do", method = RequestMethod.GET)
	public ModelAndView ticketingPayment (
			HttpSession session,
			@RequestParam("ticketing_personnel") String ticketing_personnel,
			@RequestParam("ticketing_price") String ticketing_price
			) {
		
		String partner_order_id = "";
		for (int i=0;i<10;i++) {
			int random = (int)(Math.random()*9)+0;
			partner_order_id += random;
        }
		
		String userid = (String)session.getAttribute("sidx");
		
		String kakaoResult = "";
		
		try {
			URL addr = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection sconnect = (HttpURLConnection)addr.openConnection();
			sconnect.setRequestMethod("POST");
			sconnect.setRequestProperty("Authorization", "KakaoAK e12f13c674ded90df2c74472f0b3c87b");
			sconnect.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			sconnect.setDoOutput(true);
			String ticketParameter = "cid=TC0ONETIME&partner_order_id="+partner_order_id+"&partner_user_id="+userid+"&item_name=movie_ticket&quantity="+ticketing_personnel+"&total_amount="+ticketing_price+"&tax_free_amount=0&approval_url=http://localhost:9090/amor/ticketing/ticketingPayDetail.do&cancel_url=http://localhost:9090/amor/ticketing/ticketingPayment.do&fail_url=http://localhost:9090/amor/ticketing/ticketingPayment.do"; 
			OutputStream sender = sconnect.getOutputStream();
			DataOutputStream datasender = new DataOutputStream(sender);
			datasender.writeBytes(ticketParameter);
			datasender.close();
			
			int result = sconnect.getResponseCode();
			
			InputStream receiver;
			if (result == 200) {
				receiver = sconnect.getInputStream();
			} else {
				receiver = sconnect.getErrorStream();
			}
			InputStreamReader reader = new InputStreamReader(receiver);
			BufferedReader bf = new BufferedReader(reader);
			kakaoResult = bf.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("kakaoResult", kakaoResult);
		mav.setViewName("amorJson");
		return mav;
	}
}
