package com.amor.adminController;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.*;
import javax.servlet.Servlet;// ?
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.functors.ExceptionPredicate;
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
	public ModelAndView movieList(@RequestParam(value="cp", defaultValue = "1") int cp, @RequestParam(value="search", defaultValue = "") String search) {
		int totalCnt=movieservice.getTotalCnt();
		int listSize=5;
		int pageSize=5;
			
		if(search == null || search.equals("")) {
			String pageStr = com.amor.page.PageModule.makePage("/amor/admin/movie/movieList.do", totalCnt, listSize, pageSize, cp);
			
			List<MovieDTO> lists = movieservice.movieList(cp, listSize);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("lists", lists);
			mav.addObject("pageStr",pageStr);
			mav.setViewName("admin/movie/movieList");
			return mav;
		}else{
			String pageStr = com.amor.page.PageModuleSearch.makePage("/amor/admin/movie/movieList.do", totalCnt, listSize, pageSize, cp, search);
			List<MovieDTO> lists = movieservice.movieListSearch(cp, listSize,search);
			ModelAndView mav = new ModelAndView();
			mav.addObject("lists", lists);
			mav.addObject("pageStr",pageStr);
			mav.setViewName("admin/movie/movieList");
			return mav;
		}
		
		
	}
	
	@RequestMapping("admin/movie/stateChk.do")
	public ModelAndView soldOutChange(@RequestParam("idx") int idx, @RequestParam("state") String state) {
		MovieDTO dto = new MovieDTO(idx,state);
		if(state.equals("y")) {
			dto.setMovie_state("y");
			dto.setMovie_idx(idx);
			movieservice.stateChange(dto);
		} 
		if(state.equals("n")) {
			dto.setMovie_state("n");
			dto.setMovie_idx(idx);
			movieservice.stateChange(dto);
		}
		
		ModelAndView mav = new ModelAndView();
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
		System.out.println(movie_opendate);
		System.out.println(movie_opendate_d);
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
	public ModelAndView movieUpdate2(int movie_idx,
			String movie_name,String movie_genre,String movie_god,String movie_actor,String movie_maxage,String movie_state,
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
		String movieImg[] = stillcutDefault(savepath, movie_poster,movie_stillcut1,movie_stillcut2,movie_stillcut3,movie_stillcut4,movie_stillcut5);
		MovieDTO dto = new MovieDTO(movie_idx, movie_name, movie_genre, movie_god, movie_actor, movie_maxage, movie_opendate_d, movie_runningtime, movie_country, movie_content, movieImg[0], movie_state,movieImg[1], movieImg[2],movieImg[3],movieImg[4],movieImg[5]);
		int result = movieservice.movieUpdate(dto);
		String msg = result>0? "수정" :"실패";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg) ;
		mav.addObject("href", "/amor/admin/movie/movieList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	@RequestMapping("admin/movie/movieDelete.do")
	public ModelAndView movieDelete(int movie_idx) {
		int result = movieservice.movieDelete(movie_idx);
		String msg = result>0? "삭제" :"실패";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("href","/amor/admin/movie/movieList.do");
		mav.setViewName("admin/msg/adminMsg");
		return mav;
	}
	
	
	public String[] stillcutDefault(String savepath, MultipartFile movie_poster,MultipartFile movie_stillcut1,MultipartFile movie_stillcut2, MultipartFile movie_stillcut3,MultipartFile movie_stillcut4,MultipartFile movie_stillcut5) {
		
		MultipartFile[] mfileImg = new MultipartFile[6]; // 파일
		mfileImg[0] = movie_poster;
		mfileImg[1] = movie_stillcut1;
		mfileImg[2] = movie_stillcut2;
		mfileImg[3] = movie_stillcut3;
		mfileImg[4] = movie_stillcut4;
		mfileImg[5] = movie_stillcut5;
		
		String[] saveFileName = new String[6]; // 파일 이름
		saveFileName[0] = mfileImg[0].getOriginalFilename();
		saveFileName[1] = mfileImg[1].getOriginalFilename();
		saveFileName[2] = mfileImg[2].getOriginalFilename();
		saveFileName[3] = mfileImg[3].getOriginalFilename();
		saveFileName[4] = mfileImg[4].getOriginalFilename();
		saveFileName[5] = mfileImg[5].getOriginalFilename();
		
		if(saveFileName[0].equals("")||saveFileName[0]==null) {
			
		}else {
			try {
				String upload = saveFileName[0];
				String noExt = upload.substring(0, upload.lastIndexOf("."));
				String ext = upload.substring(upload.lastIndexOf(".") + 1);
				
				byte[] bytes = mfileImg[0].getBytes();//원본
				File f = new File(savepath+saveFileName[0]);
				
				if(f.isFile()) {//파일이 존재할때
					boolean ex = true;
					int index = 0;
					while(ex) {
						index++;
						saveFileName[0] = noExt+"("+index+")."+ext;
						String dictFile = savepath + saveFileName[0];
						ex = new File(dictFile).isFile();
						f = new File(dictFile);
					}
				}else if(!f.isFile()) {
					saveFileName[0] = upload;
		        }
				
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(bytes);
				fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(saveFileName[1].equals("")||saveFileName[1]==null) {
			saveFileName[1] = "-";
		}else {
			try {
				String upload = saveFileName[1];
				String noExt = upload.substring(0, upload.lastIndexOf("."));
				String ext = upload.substring(upload.lastIndexOf(".") + 1);
				
				byte[] bytes = mfileImg[1].getBytes();//원본
				File f = new File(savepath+saveFileName[1]);
				
				if(f.isFile()) {//파일이 존재할때
					boolean ex = true;
					int index = 0;
					while(ex) {
						index++;
						saveFileName[1] = noExt+"("+index+")."+ext;
						String dictFile = savepath + saveFileName[1];
						ex = new File(dictFile).isFile();
						f = new File(dictFile);
					}
				}else if(!f.isFile()) {
					saveFileName[1] = upload;
		        }
				
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(bytes);
				fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(saveFileName[2].equals("")||saveFileName[2]==null) {
			saveFileName[2] = "-";
		}else {
			try {
				String upload = saveFileName[2];
				String noExt = upload.substring(0, upload.lastIndexOf("."));
				String ext = upload.substring(upload.lastIndexOf(".") + 1);
				
				byte[] bytes = mfileImg[2].getBytes();//원본
				File f = new File(savepath+saveFileName[2]);
				
				if(f.isFile()) {//파일이 존재할때
					boolean ex = true;
					int index = 0;
					while(ex) {
						index++;
						saveFileName[2] = noExt+"("+index+")."+ext;
						String dictFile = savepath + saveFileName[2];
						ex = new File(dictFile).isFile();
						f = new File(dictFile);
					}
				}else if(!f.isFile()) {
					saveFileName[2] = upload;
		        }
				
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(bytes);
				fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(saveFileName[3].equals("")||saveFileName[3]==null) {
			saveFileName[3] = "-";
		}else {
			try {
				String upload = saveFileName[3];
				String noExt = upload.substring(0, upload.lastIndexOf("."));
				String ext = upload.substring(upload.lastIndexOf(".") + 1);
				
				byte[] bytes = mfileImg[3].getBytes();//원본
				File f = new File(savepath+saveFileName[3]);
				
				if(f.isFile()) {//파일이 존재할때
					boolean ex = true;
					int index = 0;
					while(ex) {
						index++;
						saveFileName[3] = noExt+"("+index+")."+ext;
						String dictFile = savepath + saveFileName[3];
						ex = new File(dictFile).isFile();
						f = new File(dictFile);
					}
				}else if(!f.isFile()) {
					saveFileName[3] = upload;
		        }
				
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(bytes);
				fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(saveFileName[4].equals("")||saveFileName[4]==null) {
			saveFileName[4] = "-";
		}else {
			try {
				String upload = saveFileName[4];
				String noExt = upload.substring(0, upload.lastIndexOf("."));
				String ext = upload.substring(upload.lastIndexOf(".") + 1);
				
				byte[] bytes = mfileImg[4].getBytes();//원본
				File f = new File(savepath+saveFileName[4]);
				
				if(f.isFile()) {//파일이 존재할때
					boolean ex = true;
					int index = 0;
					while(ex) {
						index++;
						saveFileName[4] = noExt+"("+index+")."+ext;
						String dictFile = savepath + saveFileName[4];
						ex = new File(dictFile).isFile();
						f = new File(dictFile);
					}
				}else if(!f.isFile()) {
					saveFileName[4] = upload;
		        }
				
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(bytes);
				fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(saveFileName[5].equals("")||saveFileName[5]==null) {
			saveFileName[5] = "-";
		}else {
			try {
				String upload = saveFileName[5];
				String noExt = upload.substring(0, upload.lastIndexOf("."));
				String ext = upload.substring(upload.lastIndexOf(".") + 1);
				
				byte[] bytes = mfileImg[5].getBytes();//원본
				File f = new File(savepath+saveFileName[5]);
				
				if(f.isFile()) {//파일이 존재할때
					boolean ex = true;
					int index = 0;
					while(ex) {
						index++;
						saveFileName[5] = noExt+"("+index+")."+ext;
						String dictFile = savepath + saveFileName[5];
						ex = new File(dictFile).isFile();
						f = new File(dictFile);
					}
				}else if(!f.isFile()) {
					saveFileName[5] = upload;
		        }
				
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(bytes);
				fos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		return saveFileName;
	}

}
