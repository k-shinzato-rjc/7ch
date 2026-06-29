package com.example.sevenchannel.domain.model.users;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * ユーザー認証用Bean
 * @author koki_shinzato
 */
public class CustomUserDetails implements UserDetails {
	
	private final String id;
	
	private final String pwdHash;
	
	public CustomUserDetails(UserEntity userEntity) {
		this.id = userEntity.getId();
		this.pwdHash = userEntity.getPwdHash();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return id;
	}
	
	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return pwdHash;
	}
	
	@Override
	public boolean isAccountNonExpired() {
	    return true; // アカウント有効期限：切れていない
	}

	@Override
	public boolean isAccountNonLocked() {
	    return true; // アカウントロック：されていない
	}

	@Override
	public boolean isCredentialsNonExpired() {
	    return true; // パスワード有効期限：切れていない
	}

	@Override
	public boolean isEnabled() {
	    return true; // ユーザーのアカウント：有効
	}
}
