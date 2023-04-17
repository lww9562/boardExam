package org.koreait.boardtest.models.board;

import org.koreait.boardtest.validators.Validator;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BoardListValidator implements Validator<List<Board>> {
	@Override
	public void check(List<Board> boards) {
		Long id;
		String subject;
		String content;
		LocalDateTime regDt;
		for(Board board : boards){
			id = board.getId();
			subject = board.getSubject();
			content = board.getContent();
			regDt = board.getRegDt();

			if(id == null)
				throw new BadRequestException("ID 값이 없습니다.");

			requiredCheck(subject, new BadRequestException("제목이 없습니다."));
			requiredCheck(content, new BadRequestException("내용이 없습니다."));

			if(regDt == null)
				throw new BadRequestException("regDt 값이 없습니다.");
		}
	}
}
