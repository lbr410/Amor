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
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.LocalDataSourceConnectionProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amor.payment.Kakaopay;
import com.amor.payment.KakaopayDTO;
import com.amor.ticketing.model.TicketingDTO;
import com.amor.ticketing.model.TicketingPayingJoinDTO;
import com.amor.ticketing.service.TicketingService;

@Controller
public class TicketingPaymentController {
	
	@Autowired
	private TicketingService ticketingService;
	
	private String ticketing_num;
	private String ticketing_price;
	private String ticketing_personnel;
	private int playing_movie_idx;
	private int theater_idx;
	private String ticketing_screeningtime;
	private String ticketing_seat;
	private String movie_name;
	private String theater_name;
	private String ticketing_cancel;
	private String partner_order_id;
	private String approved_at;
	private String amountTotal;
	

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
			@RequestParam("ticketing_price") int ticketing_price,
			HttpSession session
			) {
		
		String sid = (String)session.getAttribute("sid");
		
		ModelAndView mav = new ModelAndView();
		
		if (sid != null) {
		
			TicketingPayingJoinDTO dto = ticketingService.ticketingPaying(movie_idx, theater_idx, playing_movie_idx);
			String movie_poster = dto.getMovie_poster();
			String movie_name = dto.getMovie_name();
			String playing_movie_start = dto.getPlaying_movie_start();
			String theater_name = dto.getTheater_name();
			String playing_movie_end = dto.getPlaying_movie_end();
			
			String playing_movie_seat_num = "";
			for (int i = 0 ; i<playing_movie_seat.length;i++) {
				if (playing_movie_seat.length == 0) {
				playing_movie_seat_num = playing_movie_seat[i]; 
				} else {
					if (playing_movie_seat.length-1==i) {
						playing_movie_seat_num += playing_movie_seat[i];
						break;
					}
					playing_movie_seat_num += playing_movie_seat[i]+",";	
				}
			}		
		
			String playing_movie_end_cut = playing_movie_end.substring(10, 16);
			String playing_movie_start_cut = playing_movie_start.substring(0,16);
			
			LocalDate date = LocalDate.of(Integer.parseInt(playing_movie_start.substring(0,4)),Integer.parseInt(playing_movie_start.substring(5,7)),Integer.parseInt(playing_movie_start.substring(8,10)));
			
			DayOfWeek dayOfWeek = date.getDayOfWeek();
			String week = dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN);
			
			String fullday = playing_movie_start.substring(0,10)+"("+week+")"+" |"+playing_movie_start.substring(10,16)+"~"+playing_movie_end.substring(10, 16);
			
			DecimalFormat df = new DecimalFormat("###,###");
			String ticketing_price_comma = df.format(ticketing_price);
			
			
			mav.addObject("movie_idx", movie_idx);
			mav.addObject("theater_idx", theater_idx);
			mav.addObject("playing_movie_idx", playing_movie_idx);
			mav.addObject("playing_movie_seat", playing_movie_seat_num);
			mav.addObject("adultC", adultC);
			mav.addObject("teenagerC", teenagerC);
			mav.addObject("seniorC", seniorC);
			mav.addObject("disabledC", disabledC);
			mav.addObject("ticketing_personnel", ticketing_personnel);
			mav.addObject("ticketing_price_comma", ticketing_price_comma);
			mav.addObject("ticketing_price", ticketing_price);
			mav.addObject("movie_poster", movie_poster);
			mav.addObject("playing_movie_start", playing_movie_start_cut);
			mav.addObject("playing_movie_end", playing_movie_end_cut);
			mav.addObject("fullday", fullday);
			mav.addObject("movie_name", movie_name);
			mav.addObject("theater_name", theater_name);
			mav.setViewName("/user/ticketing/ticketingPayment");
			
		} else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
		}
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
		this.movie_name=movie_name;
		this.theater_name=theater_name;
		
		String ticketing_num = "";
		for (int i=0;i<12;i++) {
			int random = (int)(Math.random()*9)+0;
			ticketing_num += random;
        }
		
		this.ticketing_num=ticketing_num;
		
		String sid=(String)session.getAttribute("sid");
		String quantity=ticketing_personnel;
		String total_amount=ticketing_price;
		String okpage="http://localhost:9090/amor/ticketing/kakaoPayOk.do";
		String cancelpage="http://localhost:9090/amor/ticketing/kakaoFail.do";
		String failpage="http://localhost:9090/amor/ticketing/kakaoCancel.do";
		
		KakaopayDTO kdto = new KakaopayDTO(ticketing_num, sid, "Amor Ticketing", quantity, total_amount, okpage, cancelpage, failpage);
		Kakaopay kaka = new Kakaopay();
		
		return "redirect:"+kaka.kakaoPayReady(kdto);
	}
	
	
	@RequestMapping("ticketing/ticketingPayDetail.do")
	public ModelAndView ticketingPayDetail(HttpSession session ) {
		
		String sid = (String)session.getAttribute("sid");
		
		ModelAndView mav = new ModelAndView();
		
		if (sid != null) {
		
			mav.addObject("approved_at", this.approved_at);
			mav.addObject("partner_order_id", this.partner_order_id);
			mav.addObject("amountTotal", this.amountTotal);
			mav.addObject("theater_name", this.theater_name);
			mav.addObject("movie_name", this.movie_name);
			mav.addObject("ticketing_screeningtime", this.ticketing_screeningtime);
			mav.addObject("ticketing_seat", this.ticketing_seat);
			mav.addObject("ticketing_personnel", this.ticketing_personnel);
			mav.addObject("ticketing_cancel", ticketing_cancel);
			mav.setViewName("/user/ticketing/ticketingPayDetail");
		
		} else {
			mav.addObject("msg", "로그인 후 이용가능합니다.");
			mav.addObject("goUrl", "/amor/member/login.do");
			mav.setViewName("user/msg/userMsg");
		}
		
		return mav;
		
	}
	
	@RequestMapping("ticketing/kakaoPayOk.do")
	public ModelAndView ticketingPayOK(
			@RequestParam("pg_token") String pg_token,
			HttpSession session
			) {
		
		String sid=(String)session.getAttribute("sid");
		int sidx=(Integer)session.getAttribute("sidx");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date cancelDate = null;
		try {
		cancelDate = sdf.parse(this.ticketing_screeningtime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(cancelDate);
		cal.add(Calendar.MINUTE, -30);
		
		String ticketing_cancel = sdf.format(cal.getTime());
		this.ticketing_cancel = ticketing_cancel;
		Kakaopay kaka = new Kakaopay();
		KakaopayDTO kdto = new KakaopayDTO(this.ticketing_num, sid, null, null, this.ticketing_price, null, null, null);
		
		Calendar now = Calendar.getInstance();
		
		this.partner_order_id = kdto.getPartner_order_id();
		this.approved_at = sdf3.format(now.getTime()); 
		this.amountTotal = kdto.getTotal_amount();
		
		//데이터 insert 과정 
		
		String ticketing_screeningtime = this.ticketing_screeningtime+":00";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date screenDate = null;
		try {
		screenDate = sdf1.parse(ticketing_screeningtime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int ticketing_price = Integer.parseInt(this.ticketing_price);
		int ticketing_personnel = Integer.parseInt(this.ticketing_personnel);
		
		TicketingDTO dto = new TicketingDTO(this.playing_movie_idx, this.theater_idx, sidx, this.ticketing_num, this.ticketing_seat, screenDate, ticketing_price, ticketing_personnel);
		int result1 = ticketingService.ticketingAdd(dto);
		int audience = ticketingService.totalAudience(this.playing_movie_idx);
		
		int totalMovieAudience = audience+ticketing_personnel;
		
		int result2 = ticketingService.movieAudience(totalMovieAudience, this.playing_movie_idx);
		int result3 = ticketingService.playingMovieSeat(ticketing_personnel, this.playing_movie_idx);
		
		String playingMovieSeat = ticketingService.playingMovieTotalSeat(this.playing_movie_idx);
		String playingUpdateSeat = "";
		if (playingMovieSeat.equals("[]")) {
			playingUpdateSeat = this.ticketing_seat;
		} else {
			playingUpdateSeat = playingMovieSeat+","+this.ticketing_seat;
		}
		
		int result4 = ticketingService.playingMovieUpdateSeat(playingUpdateSeat, this.playing_movie_idx); 
		
		int result = result1+result2+result3+result4;
		
		String msg = result>3?"결제가 완료되었습니다.":"결제를 완료할 수 없습니다.(고객센터 문의)";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl", "ticketingPayDetail.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}
	
	@RequestMapping("ticketing/kakaoCancel.do")
	public ModelAndView ticketingCancel() {
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "결제가 취소되었습니다.");
		mav.addObject("goUrl", "/amor/store.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}
	
	@RequestMapping("ticketing/kakaoFail.do")
	public ModelAndView ticketingFail() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "결제가 실패하였습니다.");
		mav.addObject("goUrl", "/amor/index.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}
	
	
}
