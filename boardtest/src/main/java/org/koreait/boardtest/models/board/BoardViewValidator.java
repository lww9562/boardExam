package org.koreait.boardtest.models.board;

import org.koreait.boardtest.validators.Validator;
import org.springframework.stereotype.Component;

@Component
public class BoardViewValidator implements Validator<Long> {
	@Override
	public void check(Long aLong) {
		if(aLong == null){
			throw new BadRequestException("ID값을 입력하세요");
		}
	}
}
