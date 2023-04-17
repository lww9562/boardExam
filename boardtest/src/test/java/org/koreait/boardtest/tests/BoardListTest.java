package org.koreait.boardtest.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.boardtest.models.board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BoardListTest {
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardListService listService;

	@Test
	@DisplayName("값 읽어오기 - BoardListService의 getList 메서드 호출 시, 반환값 자료형 List<Board> 검증")
	public void viewListSuccess(){
		assertTrue(listService.getList() instanceof List<Board> ? true : false);
	}

	@Test
	@DisplayName("값 읽어오기 - 읽어온 List<Board>의 각각의 자료형이 null값인지 검증, null값일 시, ")
	public void viewInstanceTest(){
		assertDoesNotThrow(()->{
			listService.getList();
		});
	}
}
