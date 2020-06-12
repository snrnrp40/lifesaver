package kr.co.lifesaver.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	httpConnection conn = httpConnection.getInstance();

	@RequestMapping(value = "/main")
	public String mainIndex() {
		return "main";
	}
	
	@RequestMapping(value = "/login") 
	public String index() {
		return "login/login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletResponse resp, HttpSession session, HttpServletRequest req) throws IOException{
		
		

		String access_token = (String)session.getAttribute("access_token");
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", "Bearer "+ access_token);
		
		String result = conn.HttpPostConnection("https://kapi.kakao.com/v1/user/logout", map).toString();
		System.out.println(result);
		
		
		session.invalidate();
		
		
		// 쿠키 제거
	     boolean found = false;
	     Cookie[] cookies = req.getCookies();    //쿠키를 서버에서 요청한다.
	     for(int i=0;i<cookies.length;i++)
	     {
	          if(cookies[i].getName().equals("MyCookie1"))    //MyCookie1이름의 쿠키가 현재 있으면
	          {
	               found = true;    //true로 변화
	               break;
	          }
	     }
	     if(found)    //true일 경우
	     {
	          Cookie cookie = new Cookie("MyCookie1", "test");  //쿠키를 생성해주고
	          cookie.setMaxAge(0);    //쿠키의 최대기간을 "0"으로 지정해주면 제거 된다.
	          resp.addCookie(cookie);   //서버에 추가를 요청한다.(저장은 클라이언트에)
	          System.out.println("쿠키제거");
	     }
	     else
	     {
	          System.out.println("쿠키없음");
	     }
		
		
		
		
		return "main";
		
	}
	
	@RequestMapping(value = "/board")
	public String boardIndex() {
		return "board";
	}
	
	
	
	
}
