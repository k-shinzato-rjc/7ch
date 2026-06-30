package com.example.sevenchannel.domain.model.threads;

import java.time.OffsetDateTime;

import lombok.Data;

/**
 * スレッドデータ（Entity）
 * @author koki_shinzato
 */
@Data
public class ThreadEntity {
	
	// スレッドId
	private Integer id;
	
	// 掲示板ID
	private Integer boardId;
	
	// タイトル
	private String title;
	
	// 作成ユーザーID
	private String userId;
	
	// 投稿数
	private Integer postCount;
	
	// スレッド作成日
	private OffsetDateTime createdAt;
	
	/**
	 * Entity → Dto 変換
	 * @return Dto
	 */
	public ThreadDto toDto() {
		
		ThreadDto threadDto = new ThreadDto();
		threadDto.setId(id);
		threadDto.setBoardId(boardId);
		threadDto.setTitle(title);
		threadDto.setUserId(userId);
		threadDto.setPostCount(postCount);
		threadDto.setCreatedAt(createdAt);
		
		return threadDto;
		
	}
}
