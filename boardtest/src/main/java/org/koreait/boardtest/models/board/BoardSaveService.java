package org.koreait.boardtest.models.board;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
@RequiredArgsConstructor
public class BoardSaveService {
	private final BoardSaveValidator saveValidator;
	private final BoardDao boardDao;

	public void save(BoardForm boardForm){
		save(boardForm, null);
	}
	public void save(BoardForm boardForm, Errors errors){

		if(errors != null && errors.hasErrors()){
			return;
		}
		saveValidator.check(boardForm);
		boardDao.insert(boardForm);
	}
}
