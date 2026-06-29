package com.example.sevenchannel.domain.model.users;

import java.time.OffsetDateTime;

import lombok.Data;

/**
 * 登録ユーザー情報格納用Dto
 * @author koki_shinzato
 */
@Data
public class UserDto {
	
	// 登録ユーザーID
	private String id;
	
	// 登録ユーザー名
	private String username;
	
	// 登録パスワード
	private String pwdHash;
	
	// 登録日
	private OffsetDateTime createdAt;
	
	/**
	 * Dto → Form 変換
	 * @return　ユーザー情報(Form)
	 */
	public UserForm toForm() {
		
		UserForm userForm = new UserForm();
		userForm.setId(id);
		userForm.setPwdHash(pwdHash);
		userForm.setUsername(username);
		
		return userForm;
	}
	
	/**
	 * Dto → Entity　変換
	 * @return ユーザー情報（Entity）
	 */
	public UserEntity toEntity() {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setId(id);
		userEntity.setPwdHash(pwdHash);
		userEntity.setUsername(username);
		
		return userEntity;
	}
}
