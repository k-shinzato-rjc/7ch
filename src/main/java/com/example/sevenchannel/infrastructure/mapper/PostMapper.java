package com.example.sevenchannel.infrastructure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sevenchannel.domain.model.posts.PostEntity;

/**
 * Mybatis投稿データ取得用マッパー
 * @author koki_shinzato
 */
@Mapper
public interface PostMapper {
	
	List<PostEntity> findById(Integer threadId);
	
	void save(PostEntity postEntity);
}
