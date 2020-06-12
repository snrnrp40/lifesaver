package kr.co.lifesaver.persistance;

import java.util.List;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.lifesaver.domain.LifeSaverAdminLoginDTO;
import kr.co.lifesaver.domain.LifeSaverHospitalLoc;
import kr.co.lifesaver.domain.LifeSaver_Saver_Info;
import kr.co.lifesaver.domain.LifeSaver_Situation_StatusDTO;
import vo.mapVO;

// 업데이트 됨
@Repository
public class LifeSaver_adminDAO implements DAO {
	@Inject
	SqlSession session;

	@Override
	public List<LifeSaver_Situation_StatusDTO> selectAllSS() {
		
		return session.selectList("selectAllSS");
	}
	
	@Override
	public List<LifeSaver_Situation_StatusDTO> selectSS(LifeSaver_Situation_StatusDTO dto) {
		// TODO Auto-generated method stub
		return session.selectList("selectSSB", dto);
	}

	@Override
	public void updateSSStat(LifeSaver_Situation_StatusDTO dto) {
		session.update("updateSSStat", dto);
		
	}

	@Override
	public void updateAuthPass(String saverNo) {
		session.update("updateAuthPass", saverNo);
		
	}

	@Override
	public List<LifeSaver_Saver_Info> selectAllSaverinfo() {
		// TODO Auto-generated method stub
		return session.selectList("selectAllSaver");
	}

	@Override
	public List<LifeSaver_Saver_Info> selectWaitAuth(int saverAuth) {
		
		return session.selectList("selectWaitAuth", saverAuth);
	}

	@Override
	public List<LifeSaver_Saver_Info> selectByLifeInfo(LifeSaver_Saver_Info dto) {
		
		return session.selectList("selectSaverInfo", dto);
	}

	@Override
	public void updateSaverGrades(LifeSaver_Saver_Info dto) {
		session.update("updateSaverInfo", dto);
		
	}

	@Override
	public void insertHosLoc(LifeSaverHospitalLoc dto) {
		session.insert("insertHosLoc", dto);
	}

	@Override
	public List<LifeSaverHospitalLoc> selectHos(LifeSaverHospitalLoc dto) {
		
		return session.selectList("selectHosLoc", dto);
	}

	@Override
	public LifeSaverAdminLoginDTO chkAdminLogin(LifeSaverAdminLoginDTO dto) {
		return session.selectOne("adminLogin", dto);
	}

	@Override
	public void insertMap(mapVO vo) {
		session.insert("insertMap", vo);
		
	}

	@Override
	public void insertMatching() {
		session.insert("insertMaching");
		
	}

	@Override
	public void updateTry() {
		session.update("updateTry");
		
	}

	@Override
	public void initSituation() {
		session.insert("initSituationStat");
		
	}

	
	
	
}
