package com.vogobike.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import com.vogobike.dto.BikeDto;
import com.vogobike.service.ManageBikeService;

public class ListBikeController implements Controller {
	private ManageBikeService manageBikeService;

	public ListBikeController(ManageBikeService manageBikeService) {
		this.manageBikeService = manageBikeService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		List<BikeDto> bikeDtos = null;

		bikeDtos = manageBikeService.getBikes();
		mav = new ModelAndView();
		mav.addObject("bikes", bikeDtos);
		mav.setViewName("bikes");
		return mav;
	}
}
