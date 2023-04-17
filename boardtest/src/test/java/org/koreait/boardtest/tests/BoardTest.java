package org.koreait.boardtest.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.boardtest.models.board.BoardDao;
import org.koreait.boardtest.models.board.BoardForm;
import org.koreait.boardtest.models.board.BoardSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc

public class BoardTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardSaveService saveService;

	private BoardForm boardForm;

	@BeforeEach
	public void init(){
		boardForm = new BoardForm();
		boardForm.setSubject("제목1");
		boardForm.setContent("내용1");
	}


	@Test
	@DisplayName("통합 테스트 - 게시글의 제목 및 내용이 입력되지 않았을 경우, '제목을 입력하세요', '내용을 입력하세요' 에러 메세지 확인")
	public void test1() throws Exception {
		String str = mockMvc.perform(post("/board/write"))
				.andReturn().getResponse().getContentAsString();

		boolean result1 = str.contains("제목을 입력하세요");
		boolean result2 = str.contains("내용을 입력하세요");
		assertTrue(result1);
		assertTrue(result2);
	}

	@Test
	@DisplayName("통합 테스트 - 게시글 작성 성공 시, '/board/list' 로 이동")
	public void test2() throws Exception{
		mockMvc.perform(post("/board/write")
				.param("subject", "제목1")
				.param("content", "내용1"))
				.andDo(print())
				.andExpect(redirectedUrl("/board/list"));
	}

	@Test
	@DisplayName("'board/delete/{id} 에서 값을 입력 후, 삭제 성공 시, '/board/list/ 로 이동 - 특정 값을 대입하여 사용")
	public void test3() throws Exception{
		mockMvc.perform(get("/board/delete")
				.param("id", "4"))
				.andDo(print())
				.andExpect(redirectedUrl("/board/list"));
	}

	@Test
	@DisplayName("'/board/details/{id} 에서 정상적이지 않은 값을 입력 시, 'error/common.html 로 이동")
	public void test4() throws Exception{
		String url = mockMvc.perform(get("/board/details/100"))
				.andReturn().getResponse().getContentAsString();

		boolean result3 = url.contains("에러페이지");
		assertTrue(result3);
	}
}
