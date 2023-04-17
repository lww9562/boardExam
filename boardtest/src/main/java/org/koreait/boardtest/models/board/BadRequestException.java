package org.koreait.boardtest.models.board;

public class BadRequestException extends RuntimeException{
	public BadRequestException(String message) {
		super(message);
	}
}
