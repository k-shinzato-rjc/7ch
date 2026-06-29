package com.example.sevenchannel.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.sevenchannel.domain.model.users.UserEntity;

/**
 * ログイン認証用Mybatisマッパー
 * @author koki_shinzato
 */
@Mapper
public interface UserAccountMapper {
	
	UserEntity findById(String id);
}