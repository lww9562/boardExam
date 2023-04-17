package org.koreait.boardtest.models.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
	private Long id;
	@NotBlank
	private String subject;
	@NotBlank
	private String content;
	private LocalDateTime regDt;
}
