package com.example.sevenchannel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sevenchannel.domain.model.users.UserDto;
import com.example.sevenchannel.infrastructure.mapper.UserMapper;

/**
 * ユーザーサービス
 * @author koki_shinzato
 */
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * 新規ユーザー登録処理
	 * パスワードのエンコード実施
	 * @param userDto
	 */
	public void save(UserDto userDto) {
		String encodePass = passwordEncoder.encode(userDto.getPwdHash());
		userDto.setPwdHash(encodePass);
		userMapper.save(userDto.toEntity());
	}
}
