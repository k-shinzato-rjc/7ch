package com.example.sevenchannel.domain.model.posts;

import java.time.OffsetDateTime;

import lombok.Data;

/**
 * 投稿データ用Entity
 */
@Data
public class PostEntity {
	
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
	 * Entity → Dto 変換
	 * @return 投稿データ(Dto)
	 */
	public PostDto toDto() {
		PostDto postDto = new PostDto();
		postDto.setId(id);
		postDto.setThreadId(threadId);
		postDto.setPostNum(postNum);
		postDto.setUserId(userId);
		postDto.setAuthorName(authorName);
		postDto.setContent(content);
		postDto.setIpAddress(ipAddress);
		postDto.setCreatedAt(createdAt);
		
		return postDto;
	}
}
