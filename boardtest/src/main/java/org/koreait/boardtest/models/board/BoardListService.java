package org.koreait.boardtest.models.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardListService {
	private final BoardDao boardDao;
	private final BoardListValidator listValidator;

	public List<Board> getList(){
		List<Board> boards = boardDao.getList();
		listValidator.check(boards);

		return boards;
	}
}
