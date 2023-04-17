package org.koreait.boardtest.tests;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.boardtest.models.board.BadRequestException;
import org.koreait.boardtest.models.board.Board;
import org.koreait.boardtest.models.board.BoardDao;
import org.koreait.boardtest.models.board.BoardViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BoardViewTest {
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardViewService viewService;


	@Test
	@DisplayName("값 읽어오기 / id값이 null일 때 BadRequestException 발생")
	public void nullParameterTest(){
		Long id = null;
		assertThrows(BadRequestException.class, ()->{
			viewService.view(id);
		});
	}

	@Test
	@DisplayName("게시글 보기에 성공하면, DTO 객체 Board 반환 확인")
	public void viewSuccess(){
		assertTrue(viewService.view(2L) instanceof Board ? true : false);
	}
}
