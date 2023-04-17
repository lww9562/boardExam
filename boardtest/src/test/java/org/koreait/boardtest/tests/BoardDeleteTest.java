package org.koreait.boardtest.tests;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.boardtest.models.board.BoardDao;
import org.koreait.boardtest.models.board.BoardDeleteService;
import org.koreait.boardtest.models.board.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@RequiredArgsConstructor

public class BoardDeleteTest {
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardDeleteService deleteService;

	@Test
	@DisplayName("board 삭제 테스트 - 성공 시 오류 없음(특정 id값을 넣어서 메서드 수행)")
	public void boardDeletTest(){
		assertDoesNotThrow(()->{
			deleteService.deleteBoard(7L);
		});
	}
}
