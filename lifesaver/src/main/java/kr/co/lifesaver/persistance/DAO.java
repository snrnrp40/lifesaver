package kr.co.lifesaver.persistance;

import java.util.List;

import kr.co.lifesaver.domain.LifeSaverAdminLoginDTO;
import kr.co.lifesaver.domain.LifeSaverHospitalLoc;
import kr.co.lifesaver.domain.LifeSaver_Saver_Info;
import kr.co.lifesaver.domain.LifeSaver_Situation_StatusDTO;
import vo.mapVO;




public interface DAO {
	public List<LifeSaver_Situation_StatusDTO> selectAllSS();
	public List<LifeSaver_Situation_StatusDTO> selectSS(LifeSaver_Situation_StatusDTO dto);
	public void updateSSStat(LifeSaver_Situation_StatusDTO dto);
	public List<LifeSaver_Saver_Info> selectAllSaverinfo();
	public List<LifeSaver_Saver_Info> selectWaitAuth(int saverAuth);
	public void updateAuthPass(String saverNo);
	public List<LifeSaver_Saver_Info> selectByLifeInfo(LifeSaver_Saver_Info dto);
	public void updateSaverGrades(LifeSaver_Saver_Info dto);
	public void insertHosLoc(LifeSaverHospitalLoc dto);
	public List<LifeSaverHospitalLoc> selectHos(LifeSaverHospitalLoc dto);
	public LifeSaverAdminLoginDTO chkAdminLogin(LifeSaverAdminLoginDTO dto);
	public void insertMap(mapVO vo);
	public void insertMatching();
	public void updateTry();
	public void initSituation();
	
}
