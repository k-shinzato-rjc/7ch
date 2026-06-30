package com.example.sevenchannel.domain.model.boards;

import java.time.OffsetDateTime;

import lombok.Data;

/**
 * 掲示板データ(Entity)
 * @author koki_shinzato
 */
@Data
public class BoardEntity {
	
	// 掲示板ID
	private String id;
	
	// 掲示板名
	private String name;
	
	// 説明
	private String description;
	
	// 作成日
	private OffsetDateTime createdAt;
	
	/**
	 * Entity → Dto 変換
	 * @return Dto
	 */
	public BoardDto toDto() {
		
		BoardDto boardDto = new BoardDto();
		boardDto.setId(id);
		boardDto.setName(name);
		boardDto.setDescription(description);
		boardDto.setCreatedAt(createdAt);
		
		return boardDto;
		
	}
}
