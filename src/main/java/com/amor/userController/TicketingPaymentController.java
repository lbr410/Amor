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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.payment.Kakaopay;
import com.amor.payment.KakaopayDTO;
import com.amor.ticketing.model.TicketingPayingJoinDTO;
import com.amor.ticketing.service.TicketingService;

@Controller
public class TicketingPaymentController {
	
	@Autowired
	private TicketingService ticketingService;
	
	private String ticketing_idx;
	private String ticketing_price;
	private String ticketing_personnel;
	private int playing_movie_idx;
	private int theater_idx;
	private String ticketing_screeningtime;
	private String ticketing_seat;

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
	
	@RequestMapping(value = "ticketing/ticketingPaymentKako.do", method = RequestMethod.POST)
	public String ticketingPayment (
			HttpSession session,
			@RequestParam("ticketing_personnel") String ticketing_personnel,
			@RequestParam("ticketing_price") String ticketing_price,
			@RequestParam("playing_movie_idx") int playing_movie_idx,
			@RequestParam("theater_idx") int theater_idx,
			@RequestParam("ticketing_seat") String ticketing_seat,
			@RequestParam("ticketing_screeningtime") String ticketing_screeningtime,
			@RequestParam("theater_name") String theater_name,
			@RequestParam("movie_name") String movie_name
			) {
		
		this.ticketing_price=ticketing_price;
		this.ticketing_personnel=ticketing_personnel;
		this.playing_movie_idx=playing_movie_idx;
		this.theater_idx=theater_idx;
		this.ticketing_seat=ticketing_seat;
		this.ticketing_screeningtime=ticketing_screeningtime;
		
		String ticketing_idx = "";
		for (int i=0;i<10;i++) {
			int random = (int)(Math.random()*9)+0;
			ticketing_idx += random;
        }
		
		this.ticketing_idx=ticketing_idx;
		
		String sid=(String)session.getAttribute("sid");
		String quantity=ticketing_personnel;
		String total_amount=ticketing_price;
		String okpage="http://localhost:9090/amor/ticketing/ticketingPayDetail.do";
		String cancelpage="http://localhost:9090/amor/store/kakaoFail.do";
		String failpage="http://localhost:9090/amor/store/kakaoCancel.do";
		
		KakaopayDTO kdto = new KakaopayDTO(ticketing_idx, sid, "Amor Ticketing", quantity, total_amount, okpage, cancelpage, failpage);
		Kakaopay kaka = new Kakaopay();
		
		return "redirect:"+kaka.kakaoPayReady(kdto);
	}
	
	@RequestMapping("ticketing/ticketingPayDetail.do")
	public ModelAndView ticketingPayDetail(
			@RequestParam("pg_token") String pg_token,
			HttpSession session,
			HttpServletRequest req) {
		
		String sid=(String)session.getAttribute("sid");
		int sidx=(Integer)session.getAttribute("sidx");
		
		Kakaopay kaka = new Kakaopay();
		KakaopayDTO kdto = new KakaopayDTO(this.ticketing_idx, sid, null, null, this.ticketing_price, null, null, null);
		ModelAndView mav = new ModelAndView();
		mav.addObject("ticketing",kaka.kakaoPayInfo(pg_token, kdto));
		mav.addObject("", this.)
		mav.setViewName("/user/ticketing/ticketingPayDetail");
		return mav;
		
	}
	
}
