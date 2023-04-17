package org.koreait.boardtest.models.board;

import jdk.jfr.ContentType;
import org.koreait.boardtest.validators.Validator;
import org.springframework.stereotype.Component;

@Component
public class BoardSaveValidator implements Validator<BoardForm> {
	@Override
	public void check(BoardForm boardForm) {
		String subject = boardForm.getSubject();
		String content = boardForm.getContent();

		if(subject == null || subject.isBlank()){
			throw new BadRequestException("제목을 입력하세요.");
		}
		if(content == null || content.isBlank()){
			throw new BadRequestException("내용을 입력하세요.");
		}
	}
}
