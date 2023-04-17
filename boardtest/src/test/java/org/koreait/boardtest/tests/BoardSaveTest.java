package org.koreait.boardtest.tests;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.boardtest.models.board.BadRequestException;
import org.koreait.boardtest.models.board.BoardDao;
import org.koreait.boardtest.models.board.BoardForm;
import org.koreait.boardtest.models.board.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
public class BoardSaveTest {
	private BoardForm boardForm;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardSaveService saveService;

	@BeforeEach
	public void init(){
		boardForm = new BoardForm();
		boardForm.setSubject("제목1");
		boardForm.setContent("내용1");
	}
	@Test
	@DisplayName("boardDao.insert 테스트, 저장 성공 시 예외 발생 없음")
	public void boardSaveTest(){
		assertDoesNotThrow(()->{
					saveService.save(boardForm);
				});
	}

	@Test
	@DisplayName("subject, content 등 필수값이 들어가지 않았을 때, BadRequestException 발생")
	public void boardRequirementTest1(){
		boardForm.setSubject(null);
		assertThrows(BadRequestException.class, ()->{
			saveService.save(boardForm);
		});

		boardForm.setContent(null);
		assertThrows(BadRequestException.class, ()->{
			saveService.save(boardForm);
		});
	}

	@Test
	@DisplayName("subject, content 에 빈 값이 들어갔을 때, BadRequestException 발생")
	public void boardRequirementTest2(){
		boardForm.setSubject("   ");
		assertThrows(BadRequestException.class, ()->{
			saveService.save(boardForm);
		});

		boardForm.setContent("    ");
		assertThrows(BadRequestException.class, ()->{
			saveService.save(boardForm);
		});
	}
}
