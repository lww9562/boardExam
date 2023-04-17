package org.koreait.boardtest.models.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class BoardForm {
	@NotBlank(message="제목을 입력하세요")
	private String subject;
	@NotBlank(message="내용을 입력하세요")
	private String content;
}
