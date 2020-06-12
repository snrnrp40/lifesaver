package kr.co.lifesaver.controller;

import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.lifesaver.persistance.DAO;
import vo.MatchingVO;
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
		
		String saverCode = "D1044";
		
		lifeSaverDao.insertMap(vo);
		
		
		lifeSaverDao.insertMatching();
		lifeSaverDao.updateTry();
		lifeSaverDao.initSituation();
		
		return "/main";
	}
}
