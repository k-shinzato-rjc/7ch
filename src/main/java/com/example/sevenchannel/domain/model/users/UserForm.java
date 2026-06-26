package com.example.sevenchannel.domain.model.users;

import lombok.Data;

/**
 * ログイン画面入力フォーム用
 * @author koki_shinzato
 */
@Data
public class UserForm {

	// 登録ユーザーID
	private String id;
	
	// 登録ユーザー名
	private String username;
	
	// 登録パスワード
	private String pwdHash;
	
	/**
	 * Form → Dto 変換
	 * @return ユーザー情報（Dto）
	 */
	public UserDto toDto() {
		
		UserDto userDto = new UserDto();
		userDto.setId(id);
		userDto.setUsername(username);
		userDto.setPwdHash(pwdHash);
		
		return userDto;
	}
}
