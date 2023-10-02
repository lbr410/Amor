package com.amor.userController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
	
	@RequestMapping(value = "/user/myAmor/movieReviewAdd.do", method = RequestMethod.POST)
	public ModelAndView reviewWrite(MovieReviewJoinDTO dto, MultipartHttpServletRequest req) {
			
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
	      
//	      ProductDTO dto = new ProductDTO();
//	      dto.setProduct_category(req.getParameter("product_category"));
//	      dto.setProduct_title(req.getParameter("product_title"));
//	      dto.setProduct_price(Integer.parseInt(req.getParameter("product_price")));
//	      dto.setProduct_content(req.getParameter("product_content"));
//	      dto.setProduct_img(saveFileName);

//	      int count = productService.productAdd(dto);
	      
//	      String msg = count > 0 ? "상품을 등록하였습니다." : "상품 등록 실패!";
//	      ModelAndView mav = new ModelAndView();
//	      mav.addObject("msg", msg);
//	      mav.addObject("goUrl", "productList.do");
//	      mav.setViewName("user/msg/userMsg");
//	      
//	      return mav;
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/myAmor/movieReviewAdd");
		return mav;
	}	
	
	@RequestMapping("/user/myAmor/movieReviewList.do")
	public ModelAndView reviewList(
			@RequestParam(value = "cp", defaultValue = "1")int cp,
			@RequestParam(value = "member_idx", defaultValue = "4")int member_idx
			) {
		
		int totalCnt=movieReviewService.getTotalCnt();
		int listSize=5;
		int pageSize=5;
		
		List<MovieReviewJoinDTO> reviewLists=movieReviewService.lists(cp, listSize, member_idx);
		
		String reviewpageStr = com.amor.page.PageModule.makePage("movieReviewList.do", totalCnt, listSize, pageSize, cp);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("reviewpageStr",reviewpageStr);
		mav.addObject("reviewLists", reviewLists);
		mav.setViewName("/user/myAmor/movieReviewList");
		return mav;
	}
	
	
	
}


