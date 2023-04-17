package org.koreait.boardtest.models.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDeleteService {
	@Autowired
	private BoardDao boardDao;

	public void deleteBoard(Long id){
		boardDao.delete(id);
	}
}
