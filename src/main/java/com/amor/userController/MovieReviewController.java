package com.amor.userController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.style.DefaultValueStyler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.amor.movieReview.model.MovieReviewDTO;
import com.amor.movieReview.model.MovieReviewJoinDTO;
import com.amor.movieReview.service.MovieReviewService;
import com.amor.movieReview.service.MovieReviewServiceImple;

@Controller
public class MovieReviewController {

	@Autowired
	private MovieReviewService movieReviewService;
	
	@RequestMapping("/user/myAmor/tempReview.do")
	public String reviewTemp() {
		return "/user/myAmor/tempReview";
	}
	
	@RequestMapping(value = "/myAmor/movieReviewAdd.do", method = RequestMethod.POST)
	public ModelAndView movieReviewAdd (MultipartHttpServletRequest req,
			@RequestParam("movie_idx") int movie_idx,
			@RequestParam("ticketing_idx") int ticketing_idx,
			@RequestParam("member_idx") int member_idx,
			@RequestParam("movie_review_star")int movie_review_star,
			@RequestParam("movie_review_content")String movie_review_content
			) {
		
		  MultipartFile upl = req.getFile("movie_review_img");
	      String upload = upl.getOriginalFilename();
	      String noExt = upload.substring(0, upload.lastIndexOf("."));
	      String ext = upload.substring(upload.lastIndexOf(".") + 1);

	      String savePath = req.getRealPath("/resources/upload/review/");
	      String saveFileName = "";
	      
	      try {
	         byte bytes[] = upl.getBytes();
	         String filefull = savePath + upload;
	         File f = new File(filefull);
	         if(f.isFile()) {
	            boolean ex = true;
	            int index = 0;
	            while(ex) {
	               index++;
	               saveFileName = noExt+"("+index+")."+ext;
	               String dictFile = savePath + saveFileName;
	               ex = new File(dictFile).isFile();
	               f = new File(dictFile);
	            }
	         } else if(!f.isFile()) {
	            saveFileName = upload;
	         }
	         
	         FileOutputStream fos = new FileOutputStream(f);
	         fos.write(bytes);
	         fos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	    MovieReviewJoinDTO dto = new MovieReviewJoinDTO(movie_idx, ticketing_idx, member_idx, movie_review_star, movie_review_content, saveFileName);
	    int result1 = movieReviewService.movieReviewAdd(dto);
	    int result2 = movieReviewService.reviewTicketingState(ticketing_idx);
	    System.out.println("ticketing_idx="+ticketing_idx);
	    System.out.println("result2="+result2);
	    int result = result1+result2;
	    String msg = result>1?"등록에 성공하였습니다.":"등록에 실패하였습니다.";
	    
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl", "/amor/myAmor/ticketingHistory.do");
		mav.setViewName("user/msg/userMsg");
		return mav;
	}	
	
	@RequestMapping("/myAmor/reviewList.do")
	public ModelAndView reviewList(
			@RequestParam(value = "cp", defaultValue = "1")int cp,
			HttpSession session
			) {
		
		ModelAndView mav = new ModelAndView();
		
		if (session.getAttribute("sid") == null) {
			
			mav.addObject("msg", "로그인이 필요합니다.");
			mav.addObject("goUrl", "/amor");
			mav.setViewName("/user/msg/userMsg");
			
		} else {

			String member_id =(String)session.getAttribute("sid");
			int member_idx = movieReviewService.reviewListIdx(member_id);
			
			int totalCnt=movieReviewService.getTotalCnt(member_idx);
			int listSize=5;
			int pageSize=5;
			
			List<MovieReviewJoinDTO> reviewLists=movieReviewService.lists(cp, listSize, member_idx);
			
			String reviewpageStr = com.amor.page.PageModule.makePage("/amor/myAmor/reviewList.do", totalCnt, listSize, pageSize, cp);
		
			
			mav.addObject("reviewpageStr", reviewpageStr);
			mav.addObject("reviewLists", reviewLists);
			mav.setViewName("/user/myAmor/reviewList");
		}
		
		return mav;
	}
	
	@RequestMapping("/myAmor/reviewDelete.do")
	public ModelAndView reviewDelete(
			@RequestParam("movie_review_idx") int movie_review_idx
			) {

		int ticketing_idx = movieReviewService.reviewTicketingIDX(movie_review_idx);
		int result2 = movieReviewService.reviewTicketingDelState(ticketing_idx);
		int result1 = movieReviewService.reviewDelete(movie_review_idx);
		int result = result1+result2;
		String msg = result>1?"삭제에 성공했습니다.":"삭제에 실패했습니다.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("goUrl", "/amor/myAmor/reviewList.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
	}
	
	@RequestMapping(value = "/myAmor/reviewUpdate.do", method = RequestMethod.POST)
	public ModelAndView reviewUpdate(MultipartHttpServletRequest req,
			@RequestParam("movie_review_star") int movie_review_star,
			@RequestParam("movie_review_content") String movie_review_content,
			@RequestParam("movie_review_idx") int movie_review_idx
			) {
		
		  MultipartFile upl = req.getFile("movie_review_img");
	      String upload = upl.getOriginalFilename();
	      String noExt = upload.substring(0, upload.lastIndexOf("."));
	      String ext = upload.substring(upload.lastIndexOf(".") + 1);

	      String savePath = req.getRealPath("/resources/upload/review/");
	      String saveFileName = "";
	      
	      try {
	         byte bytes[] = upl.getBytes();
	         String filefull = savePath + upload;
	         File f = new File(filefull);
	         if(f.isFile()) {
	            boolean ex = true;
	            int index = 0;
	            while(ex) {
	               index++;
	               saveFileName = noExt+"("+index+")."+ext;
	               String dictFile = savePath + saveFileName;
	               ex = new File(dictFile).isFile();
	               f = new File(dictFile);
	            }
	         } else if(!f.isFile()) {
	            saveFileName = upload;
	         }
	         
	         FileOutputStream fos = new FileOutputStream(f);
	         fos.write(bytes);
	         fos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	     
	    MovieReviewJoinDTO dto = new MovieReviewJoinDTO(movie_review_idx, movie_review_star, movie_review_content, saveFileName);
	      
	    int result = movieReviewService.reviewUpdate(dto);
		
	    String msg = result>0?"수정에 성공하였습니다.":"수정에 실패하였습니다.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.addObject("goUrl", "/amor/myAmor/reviewList.do");
		mav.setViewName("/user/msg/userMsg");
		return mav;
		
	}
}


