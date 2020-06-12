package kr.co.lifesaver.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.lifesaver.domain.LifeSaverAdminLoginDTO;
import kr.co.lifesaver.domain.LifeSaverHospitalLoc;
import kr.co.lifesaver.domain.LifeSaver_Saver_Info;
import kr.co.lifesaver.domain.LifeSaver_Situation_StatusDTO;
import kr.co.lifesaver.persistance.DAO;



@Controller
public class AdminController {
	
	@Inject
	private DAO lifeSaverDao;
	
	@RequestMapping(value = "/admin")
	public String processStep1(Model model) {
		List<LifeSaver_Situation_StatusDTO> list = lifeSaverDao.selectAllSS();
		
		model.addAttribute("list", list);
		
		return "/admin/admin_main";
	}
	@PostMapping(value = "/search")
	public String searchList(HttpServletRequest req, Model model) {
		
		LifeSaver_Situation_StatusDTO dto = new LifeSaver_Situation_StatusDTO();
		
		String value = req.getParameter("val");
		
		if(req.getParameter("col_select").equals("saver_code")) {
			dto.setSaver_code(value);
		}else if(req.getParameter("col_select").equals("ssb_situation_num")) {
			dto.setSsb_situation_num(Integer.parseInt(value));
		}else if(req.getParameter("col_select").equals("sit_emr_arrtime")) {
			dto.setSit_emr_arrtime(value);
		}else if(req.getParameter("col_select").equals("sit_saver_stat")) {
			dto.setSit_saver_stat(value);
		}else if(req.getParameter("col_select").equals("sit_emr_stat")) {
			dto.setSit_emr_stat(value);
		}else if(req.getParameter("col_select").equals("sit_hos_arrstatus")) {
			dto.setSit_hos_arrstatus(value);
		}else if(req.getParameter("col_select").equals("sit_unicare_Status")) {
			dto.setSit_unicare_Status(value);
		}else if(req.getParameter("col_select").equals("sit_death_cuz")) {
			dto.setSit_death_cuz(value);
		}else if(req.getParameter("col_select").equals("sit_arrest_cuz")) {
			dto.setSit_arrest_cuz(value);
		}else if(req.getParameter("col_select").equals("sit_alive")) {
			dto.setSit_alive(Integer.parseInt(value));
		}
		
		
		
		List<LifeSaver_Situation_StatusDTO> list = lifeSaverDao.selectSS(dto);
		//System.out.println(req.getParameter("val"));
		model.addAttribute("list", list);
		
		
		return "/admin/admin_main";
	}
	
	@PostMapping(value = "/admin_ssb_save")
	public String updateSSB(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		ArrayList<LifeSaver_Situation_StatusDTO> list = new ArrayList<LifeSaver_Situation_StatusDTO>();
		String [] selectSaverCode = req.getParameterValues("saver_code");
		String [] selectSsbSituationNum = req.getParameterValues("ssb_situation_num");
		String [] selectSitEmrArrtime = req.getParameterValues("sit_emr_arrtime");
		String [] selectSitSaverStat = req.getParameterValues("sit_saver_stat");
		String [] selectSitEmrStat = req.getParameterValues("sit_emr_stat");
		String [] selectSitHosArrstatus = req.getParameterValues("sit_hos_arrstatus");
		String [] selectSitUnicareStatus = req.getParameterValues("sit_unicare_Status");
		String [] selectSitDeathCuz = req.getParameterValues("sit_death_cuz");
		String [] selectSitArrestCuz = req.getParameterValues("sit_arrest_cuz");
		String [] selectSitAlive = req.getParameterValues("sit_alive");
		
		for(int i = 0; i<selectSaverCode.length; i++) {
			
			LifeSaver_Situation_StatusDTO dto = new LifeSaver_Situation_StatusDTO(selectSaverCode[i], 
					Integer.parseInt(selectSsbSituationNum[i]), 
					selectSitEmrArrtime[i], 
					selectSitSaverStat[i], 
					selectSitEmrStat[i], 
					selectSitHosArrstatus[i], 
					selectSitUnicareStatus[i], 
					selectSitDeathCuz[i], 
					selectSitArrestCuz[i], 
					Integer.parseInt(selectSitAlive[i]));
			if(dto.getSit_saver_stat().equals("death")) {
				dto.setSit_emr_stat("death");
				dto.setSit_hos_arrstatus("death");
				dto.setSit_unicare_Status("death");
				dto.setSit_alive(0);
			}else if(dto.getSit_emr_stat().equals("death")) {
				dto.setSit_hos_arrstatus("death");
				dto.setSit_unicare_Status("death");
				dto.setSit_alive(0);
			}else if(dto.getSit_hos_arrstatus().equals("death")) {
				dto.setSit_unicare_Status("death");
				dto.setSit_alive(0);
			}else if(dto.getSit_unicare_Status().equals("death")){
				dto.setSit_alive(0);
			}else if(!dto.getSit_unicare_Status().equals("death")) {
				dto.setSit_alive(1);
			}
			
			lifeSaverDao.updateSSStat(dto);
			list.add(dto);
		}
		
		model.addAttribute("list", list);
		
		return "/admin/admin_main";
	}
	
	@RequestMapping(value = "/guard.page")
	public String selectGuardList(Model model) {
		
		List<LifeSaver_Saver_Info> list = lifeSaverDao.selectWaitAuth(1);
		
		model.addAttribute("saverList", list);
		
		return "/admin/emergencyguard";
	}
	
	@RequestMapping(value = "/building.page")
	public String buildingList(Model model) {
		
		return "/admin/building";
	}
	
	@RequestMapping(value = "/authorization.page")
	public String waitAuth(Model model) {
		
		List<LifeSaver_Saver_Info> list = lifeSaverDao.selectWaitAuth(0);
		
		model.addAttribute("saverList", list);
		
		return "/admin/authorization";
	}
	
	@RequestMapping(value = "/hospital.page")
	public String hosList(HttpServletRequest req, Model model) {
		
		LifeSaverHospitalLoc dto =  new LifeSaverHospitalLoc();
		List<LifeSaverHospitalLoc> hosList = lifeSaverDao.selectHos(dto);
		if(req.getParameter("value")==null) {
			
			
		}else if(!(req.getParameter("value")==null)) {
			String value = req.getParameter("value");
			String colSel = req.getParameter("col_select");
			if(colSel.equals("hos_code")) {
				dto.setHos_code(value);
			}else if(colSel.equals("hos_name")) {
				dto.setHos_name(value);
			}else if(colSel.equals("hos_road")) {
				dto.setHos_road(value);
			}else if(colSel.equals("hos_jiburn")) {
				dto.setHos_jiburn(value);
			}
			hosList = lifeSaverDao.selectHos(dto);
		}
		
		model.addAttribute("hosList", hosList);
		
		return "/admin/hospital";
	}
	
	
	@PostMapping(value = "/searchSaverList") public String
	listResult(HttpServletRequest req, Model model) {
		
		LifeSaver_Saver_Info dto = new LifeSaver_Saver_Info();
		
		String value = req.getParameter("val");
		
		if(req.getParameter("col_select").equals("saver_code")) {
			dto.setSaver_code(value);
		}else if(req.getParameter("col_select").equals("common_code")) {
			dto.setCommon_code(value);
		}else if(req.getParameter("col_select").equals("saver_license")) {
			dto.setSaver_license(value);
		}else if(req.getParameter("col_select").equals("saver_grade")) {
			dto.setSaver_grade(value);
		}else if(req.getParameter("col_select").equals("saver_job")) {
			dto.setSaver_job(value);
		}else if(req.getParameter("col_select").equals("saver_job_addr")) {
			dto.setSaver_job_addr(value);
		}else if(req.getParameter("col_select").equals("saver_rev_try")) {
			dto.setSaver_rev_try(value);
		}else if(req.getParameter("col_select").equals("saver_rev_succ")) {
			dto.setSaver_rev_succ(value);
		}else if(req.getParameter("col_select").equals("saver_rev_fail")) {
			dto.setSaver_rev_fail(value);
		}	
		List<LifeSaver_Saver_Info> list = lifeSaverDao.selectByLifeInfo(dto);
		
		model.addAttribute("saverList", list);
		
		return "/admin/authorization"; 
	}
	 
	@RequestMapping(value = "/admin_updateAuth")
	public String updateAuth(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
				
		lifeSaverDao.updateAuthPass(req.getParameter("saverCode"));
		
		return "redirect:/authorization.page";
	}
	
	@PostMapping(value = "/findSaverList") public String
	saverListResult(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		LifeSaver_Saver_Info dto = new LifeSaver_Saver_Info();
		
		String value = req.getParameter("val");
		
		System.out.println(value);
		
		if(req.getParameter("col_select").equals("saver_code")) {
			dto.setSaver_code(value);
		}else if(req.getParameter("col_select").equals("common_code")) {
			dto.setCommon_code(value);
		}else if(req.getParameter("col_select").equals("saver_license")) {
			dto.setSaver_license(value);
		}else if(req.getParameter("col_select").equals("saver_grade")) {
			dto.setSaver_grade(value);
		}else if(req.getParameter("col_select").equals("saver_job")) {
			dto.setSaver_job(value);
		}else if(req.getParameter("col_select").equals("saver_job_addr")) {
			dto.setSaver_job_addr(value);
		}else if(req.getParameter("col_select").equals("saver_rev_try")) {
			dto.setSaver_rev_try(value);
		}else if(req.getParameter("col_select").equals("saver_rev_succ")) {
			dto.setSaver_rev_succ(value);
		}else if(req.getParameter("col_select").equals("saver_rev_fail")) {
			dto.setSaver_rev_fail(value);
		}else if(req.getParameter("col_select").equals("saver_auth")){
			dto.setSaver_auth(1);
		}
		dto.setSaver_auth(1);
		System.out.println(dto.getSaver_auth());
		
		List<LifeSaver_Saver_Info> list = lifeSaverDao.selectByLifeInfo(dto);
		
		model.addAttribute("saverList", list);
		
		return "/admin/emergencyguard"; 
	}
	
	@PostMapping(value = "/adminSaveGrade")
	public String saveGrade(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		
		ArrayList<LifeSaver_Saver_Info> list = new ArrayList<LifeSaver_Saver_Info>();
		
		String[] saverCodes = req.getParameterValues("saverCode");
		String[] commonCode =req.getParameterValues("commonCode");
		String[] saverLicense = req.getParameterValues("saverLicense");
		String[] saverGrades = req.getParameterValues("saverGrade");
		String[] saverJob = req.getParameterValues("saverJob");
		String[] saverJobAddr = req.getParameterValues("saverJobAddr");
		String[] saverRevTry = req.getParameterValues("saverRevTry");
		String[] saverRevSucc = req.getParameterValues("saverRevSucc");
		String[] saverRevFail = req.getParameterValues("saverRevFail");
		String[] saverAuth = req.getParameterValues("saverAuth");
		
		for(int i = 0; i<saverCodes.length; i++) {
			LifeSaver_Saver_Info dto = new LifeSaver_Saver_Info(
					saverCodes[i], 
					commonCode[i], 
					saverLicense[i], 
					saverGrades[i], 
					saverJob[i], 
					saverJobAddr[i], 
					saverRevTry[i], 
					saverRevSucc[i], 
					saverRevFail[i], 
					Integer.parseInt(saverAuth[i])
							);
			
			lifeSaverDao.updateSaverGrades(dto);
			list.add(dto);
		}
		
		model.addAttribute("saverList", list);
		
		return "/admin/emergencyguard";
	}
	
	@RequestMapping(value = "/addrow")
	public String addRow() {
		return "/admin/addHosRow";
	}
	
	@PostMapping(value = "/addrowOk")
	public String addRowOk(HttpServletRequest req, Model model) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		String hosCode = req.getParameter("hos_code");
		String hosName = req.getParameter("hos_name");
		String hosRoad = req.getParameter("hos_road");
		String hosJiburn = req.getParameter("hos_jiburn");
		
		LifeSaverHospitalLoc dto = new LifeSaverHospitalLoc(hosCode, hosName, hosRoad, hosJiburn);
		
		lifeSaverDao.insertHosLoc(dto);
		return "/admin/refresh";
	}
	
	@RequestMapping(value = "/adminLogin")
	public String adminLogin(HttpServletRequest req, Model model) {
		
		return "/admin/managerlogin";
	}
	
	@PostMapping(value = "/adminLogin")
	public String adminChk(HttpServletRequest req,  HttpSession session) {
		
		LifeSaverAdminLoginDTO dto = new LifeSaverAdminLoginDTO();
		
		dto.setId(req.getParameter("id"));
		dto.setPwd(req.getParameter("pwd"));
		
		dto = lifeSaverDao.chkAdminLogin(dto);
		
		if(dto!=null) {
			session.setAttribute("admin", dto);
			return "redirect:/admin";
		}else {
			req.setAttribute("war", "아이디와 비밀번호를 확인해주세요");
			return "/admin/managerlogin";
		}
		
		
	}
	@RequestMapping(value = "/adminlogout")
	public String adminLogout(HttpSession session) {
		
		session.invalidate();
		
		return "/admin/managerlogin";
	}
}
