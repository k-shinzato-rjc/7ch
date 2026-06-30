package com.example.sevenchannel.service;

import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sevenchannel.domain.model.users.CustomUserDetails;
import com.example.sevenchannel.domain.model.users.UserEntity;
import com.example.sevenchannel.infrastructure.mapper.UserAccountMapper;

/**
 * 認証用ユーザーサービス
 * @author koki_shinzato
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserAccountMapper userAccountMapper;
	
	/**
	 * Mybatisマッパーの取得
	 * @param userAccountMapper
	 */
	public CustomUserDetailsService(UserAccountMapper userAccountMapper) {
		this.userAccountMapper = userAccountMapper;
	}
	
	/**
	 * username該当のユーザーデータを取得
	 * Entity →　認証用Beanへ移し替えて返す
	 */
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
	
		UserEntity userEntity = userAccountMapper.findById(id);
		
		if(Objects.isNull(userEntity)) {
			throw new UsernameNotFoundException("ユーザーが見つかりません：" + id);
		}
		
	    System.out.println("【デバッグ】DBから取得したパスワードハッシュ: " + userEntity.getPwdHash());
		
		return new CustomUserDetails(userEntity);
	}
}
