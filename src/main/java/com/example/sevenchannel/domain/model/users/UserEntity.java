package com.example.sevenchannel.domain.model.users;

import java.time.OffsetDateTime;

import lombok.Data;

/**
 * 登録ユーザー情報格納用Entity(Mybatis仕様）
 * @author koki_shinzato
 */
@Data
public class UserEntity {
	
	// 登録ユーザーID
	private String id;
	
	// 登録ユーザー名
	private String username;
	
	// 登録パスワード
	private String pwdHash;
	
	// 登録日
	private OffsetDateTime createdAt;
	
	/**
	 * Entity → Dto 変換
	 * @return　ユーザー情報（Dto）
	 */
	public UserDto toDto() {
		
		UserDto userDto = new UserDto();
		userDto.setId(id);
		userDto.setPwdHash(pwdHash);
		userDto.setUsername(username);
		userDto.setCreatedAt(createdAt);
		
		return userDto;
	}
}
