package com.example.sevenchannel.domain.model.threads;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class ThreadDto {
	
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
	 * Dto → Entity 変換
	 * @return Entity
	 */
	public ThreadEntity toEntity() {
		
		ThreadEntity threadEntity = new ThreadEntity();
		threadEntity.setId(id);
		threadEntity.setBoardId(boardId);
		threadEntity.setTitle(title);
		threadEntity.setUserId(userId);
		threadEntity.setPostCount(postCount);
		threadEntity.setCreatedAt(createdAt);
		
		return threadEntity;
		
	}
}
