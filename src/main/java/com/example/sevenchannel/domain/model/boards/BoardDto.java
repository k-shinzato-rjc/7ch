package com.example.sevenchannel.domain.model.boards;

import java.time.OffsetDateTime;

import lombok.Data;

/**
 * 掲示板用（Dto）
 * @author koki_shinzato
 */
@Data
public class BoardDto {
	
	// 掲示板ID
	private String id;
		
	// 掲示板名
	private String name;
		
	// 説明
	private String description;
		
	// 作成日
	private OffsetDateTime createdAt;
	
	/**
	 * Dto → Entity 変換
	 * @return Entity
	 */
	public BoardEntity toEntity() {
		
		BoardEntity boardEntity = new BoardEntity();
		boardEntity.setId(id);
		boardEntity.setName(name);
		boardEntity.setDescription(description);
		boardEntity.setCreatedAt(createdAt);
		
		return boardEntity;
		
	}
}
