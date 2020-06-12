package kr.co.lifesaver.controller;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.lifesaver.persistance.DAO;
import vo.mapVO;

@Controller
public class MapController {
	
	@Inject
	private DAO lifeSaverDao;
	
	@RequestMapping(value = "/mapOk")
	public String test(HttpServletRequest req) throws UnsupportedEncodingException {
		
		String latitude = req.getParameter("latitude");
		String longitude = req.getParameter("longitude");
		String Hours = req.getParameter("Hours");
		String Minutes = req.getParameter("Minutes");
		String Seconds = req.getParameter("Seconds");
		
		System.out.println(latitude + longitude + Hours + Minutes + Seconds);
		
		mapVO vo = new mapVO();
		
		vo.setSsb_situation_lat(latitude);
		vo.setSsb_situation_lon(longitude);
		vo.setSsb_report_time(Hours+Minutes+Seconds);
		
		lifeSaverDao.insertMap(vo);
		
		return "/main";
	}
}
