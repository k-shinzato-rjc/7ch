package com.example.sevenchannel.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.sevenchannel.domain.model.users.UserEntity;

/**
 * ユーザーテーブル操作用（Mybatisマッパー）
 * @author koki_shinzato
 */
@Mapper
public interface UserMapper {
	
	/**
	 * ID指定で登録ユーザー情報を取得
	 * @param id
	 * @return Entity
	 */
	UserEntity findById(String id);
	
	/**
	 * 新規ユーザー登録
	 * @param userEntity
	 */
	void save(UserEntity userEntity);
}
