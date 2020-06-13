package kr.co.lifesaver.persistance;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import kr.co.lifesaver.domain.LifeSaver_BoardDTO;

public class LifeSaver_BoardDAO implements BoardDAO{

	@Inject
	SqlSession session;
	
	
	@Override
	public void insertBoard(LifeSaver_BoardDTO dto) {
		session.insert("insertBoard", dto);
		
	}

}
