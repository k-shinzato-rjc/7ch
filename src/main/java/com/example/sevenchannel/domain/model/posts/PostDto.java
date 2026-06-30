package com.example.sevenchannel.domain.model.posts;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class PostDto {

	// 一意ID
	private Integer id;
	
	// スレッドID
	private Integer threadId;
	
	// スレッド内通番
	private Integer postNum;
	
	// ユーザーID
	private String userId;
	
	// 入力された名前
	private String authorName;
	
	// 本文
	private String content;
	
	// IPアドレス
	private String ipAddress;
	
	// 作成日
	private OffsetDateTime createdAt;
	
	/**
	 * Dto → Entity 変換
	 * @return 投稿データ(Entity)
	 */
	public PostEntity toEntity() {
		PostEntity postEntity = new PostEntity();
		postEntity.setId(id);
		postEntity.setThreadId(threadId);
		postEntity.setPostNum(postNum);
		postEntity.setUserId(userId);
		postEntity.setAuthorName(authorName);
		postEntity.setContent(content);
		postEntity.setIpAddress(ipAddress);
		postEntity.setCreatedAt(createdAt);
		
		return postEntity;
	}
}
