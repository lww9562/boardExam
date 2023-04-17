package org.koreait.boardtest.models.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
@RequiredArgsConstructor
public class BoardViewService {
	private final BoardDao boardDao;
	private final BoardViewValidator validator;


	public Board view(Long id){
		return view(id, null);
	}

	public Board view(Long id, Errors errors){
		if(errors != null && errors.hasErrors()) {
			return null;
		}
		validator.check(id);
		Board board = boardDao.get(id);
		return board;
	}
}
