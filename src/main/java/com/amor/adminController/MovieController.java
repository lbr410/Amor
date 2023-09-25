package com.amor.adminController;

import java.io.File;
import java.sql.*;
import java.util.*;
import javax.servlet.Servlet;// ?
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amor.movie.model.MovieDTO;
import com.amor.movie.service.MovieService;



@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieservice; 

	@RequestMapping("admin/movie/movieList.do")
	public ModelAndView movieList() {
		
		List<MovieDTO> lists = movieservice.movieList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.setViewName("admin/movie/movieList");
		return mav;
	}
	
	@RequestMapping(value =  "admin/movie/movieAdd.do", method = RequestMethod.GET)
	public String movieAddForm() {return "admin/movie/movieAdd";}
	
	@RequestMapping(value = "admin/movie/movieAdd.do", method=RequestMethod.POST)
	public ModelAndView movieAddSumit(
			String movie_name,String movie_genre,String movie_god,String movie_actor,String movie_maxage, 
			String movie_opendate, int movie_runningtime,String movie_country, String movie_content,
			@RequestParam(value = "movie_poster") MultipartFile movie_poster,
			@RequestParam(value = "movie_stillcut1") MultipartFile movie_stillcut1,
			@RequestParam(value = "movie_stillcut2") MultipartFile movie_stillcut2,
			@RequestParam(value = "movie_stillcut3") MultipartFile movie_stillcut3,
			@RequestParam(value = "movie_stillcut4") MultipartFile movie_stillcut4,
			@RequestParam(value = "movie_stillcut5") MultipartFile movie_stillcut5,
			HttpServletRequest req) {
		String savepath = req.getRealPath("/resources/upload/movie/");//이미지 파일 경로

		//movie_poster.getr
		java.sql.Date movie_opendate_d = java.sql.Date.valueOf(movie_opendate); //string -> java.sql.date 타입으로
		
		String movieImg[] = stillcutDefault(savepath, movie_poster,movie_stillcut1,movie_stillcut2,movie_stillcut3,movie_stillcut4,movie_stillcut5);
		System.out.println("스틸컷 => \n 1"+movieImg[1]+"2"+movieImg[2]+"3"+movieImg[3]+"4"+movieImg[4]+"5"+movieImg[5]);

		MovieDTO dto = new MovieDTO(0, movie_name, movie_genre, movie_god, movie_actor, movie_maxage, movie_opendate_d, movie_runningtime, movie_country, movie_content, movieImg[0], movieImg[1], movieImg[2],movieImg[3],movieImg[4],movieImg[5]);
		ModelAndView mav = new ModelAndView();
		int result = movieservice.movieAdd(dto);
		String msg = result > 0 ? "등록" : "실패";
		mav.addObject("msg",msg);
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/movie/moviePopUp.do")
	public ModelAndView moviePopUp(int movie_idx) {
		
		MovieDTO dto = movieservice.movieContent(movie_idx);
		
		ModelAndView mav = new ModelAndView();
		
		if(dto == null) {
			mav.addObject("msg","삭제된 게시물 잘못된 접근입니다.");
			mav.setViewName("admin/msg/adminMsg");
		}else {
			String movieContent = dto.getMovie_content().replaceAll("\n", "<br>");
			mav.addObject("movieContent",movieContent);
			mav.addObject("dto",dto);
			mav.setViewName("admin/movie/moviePopUp");
		}
		return mav;
	}

	@RequestMapping(value =  "admin/movie/movieUpdate.do", method = RequestMethod.GET)
	public ModelAndView movieUpdate1(int movie_idx) {
		MovieDTO dto = movieservice.movieContent(movie_idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.setViewName("admin/movie/movieUpdate");
		return mav;
	}
	
	@RequestMapping(value =  "admin/movie/movieUpdate.do", method = RequestMethod.POST)
	public ModelAndView movieUpdate2(
			String movie_name,String movie_genre,String movie_god,String movie_actor,String movie_maxage,
			String movie_opendate, int movie_runningtime,String movie_country, String movie_content,
			@RequestParam(value = "movie_poster") MultipartFile movie_poster,
			@RequestParam(value = "movie_stillcut1") MultipartFile movie_stillcut1,
			@RequestParam(value = "movie_stillcut2") MultipartFile movie_stillcut2,
			@RequestParam(value = "movie_stillcut3") MultipartFile movie_stillcut3,
			@RequestParam(value = "movie_stillcut4") MultipartFile movie_stillcut4,
			@RequestParam(value = "movie_stillcut5") MultipartFile movie_stillcut5,
			HttpServletRequest req) {
		String savepath = req.getRealPath("/resources/upload/movie/");//이미지 파일 경로
		java.sql.Date movie_opendate_d = java.sql.Date.valueOf(movie_opendate); //string -> java.sql.date 타입으로
		String movieImg[] = stillcutDefault(savepath,movie_poster,movie_stillcut1,movie_stillcut2,movie_stillcut3,movie_stillcut4,movie_stillcut5);
		MovieDTO dto = new MovieDTO(0, movie_name, movie_genre, movie_god, movie_actor, movie_maxage, movie_opendate_d, movie_runningtime, movie_country, movie_content, movieImg[0], movieImg[1], movieImg[2],movieImg[3],movieImg[4],movieImg[5]);
		int result = movieservice.movieUpdate(dto);
		String msg = result>0? "수정" :"실패";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg) ;
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/movie/movieDelete.do")
	public ModelAndView movieDelete(int movie_idx) {
		int result = movieservice.movieDelete(movie_idx);
		String msg = result>0? "삭제" :"실패";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	
	public String[] stillcutDefault(String savepath, MultipartFile movie_poster,MultipartFile movie_stillcut1,MultipartFile movie_stillcut2, MultipartFile movie_stillcut3,MultipartFile movie_stillcut4,MultipartFile movie_stillcut5) {
		MultipartFile[] fileImg = new MultipartFile[6];
		fileImg[0] = movie_poster;
		fileImg[1] = movie_stillcut1;
		fileImg[2] = movie_stillcut2;
		fileImg[3] = movie_stillcut3;
		fileImg[4] = movie_stillcut4;
		fileImg[5] = movie_stillcut5;
		
		try {
			for(int i = 0 ; i<6; i++) {
				if(fileImg[i].getOriginalFilename() == null || fileImg[i].getOriginalFilename().equals("")) {
					
				}else {
					byte[] bytes = fileImg[i].getBytes();//원본
					File f = new File(savepath+fileImg[i].getOriginalFilename());
					//작업중
				}
				
				
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		String movie_poster_name = movie_poster.getOriginalFilename();
		String movie_stillcut1_name = movie_stillcut1.getOriginalFilename();
		String movie_stillcut2_name = movie_stillcut2.getOriginalFilename();
		String movie_stillcut3_name = movie_stillcut3.getOriginalFilename();
		String movie_stillcut4_name = movie_stillcut4.getOriginalFilename();
		String movie_stillcut5_name = movie_stillcut5.getOriginalFilename();
		
		if(movie_stillcut1_name.equals("")||movie_stillcut1_name==null) {
			movie_stillcut1_name = "-";
		}else {
			movie_stillcut1_name = movie_stillcut1.getOriginalFilename();
		}
		
		if(movie_stillcut2_name.equals("")||movie_stillcut2_name==null) {
			movie_stillcut2_name = "-";
		}else {
			movie_stillcut2_name = movie_stillcut2.getOriginalFilename();
		}
		if(movie_stillcut3_name.equals("")||movie_stillcut3_name==null) {
			movie_stillcut3_name = "-";
		}else {
			movie_stillcut3_name = movie_stillcut3.getOriginalFilename();
		}
		if(movie_stillcut4_name.equals("")||movie_stillcut4_name==null) {
			movie_stillcut4_name = "-";
		}else {
			movie_stillcut4_name = movie_stillcut4.getOriginalFilename();
		}
		if(movie_stillcut5_name.equals("")||movie_stillcut5_name==null) {
			movie_stillcut5_name = "-";
		}else {
			movie_stillcut5_name = movie_stillcut5.getOriginalFilename();
		}
		
		String movieImg[] = new String[6];
		movieImg[0] = movie_poster_name;
		movieImg[1] = movie_stillcut1_name;
		movieImg[2] = movie_stillcut2_name;
		movieImg[3] = movie_stillcut3_name;
		movieImg[4] = movie_stillcut4_name;
		movieImg[5] = movie_stillcut5_name;
		
		return movieImg;
	}
	
	
	
}
