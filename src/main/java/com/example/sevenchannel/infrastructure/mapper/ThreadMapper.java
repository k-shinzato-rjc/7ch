package com.example.sevenchannel.infrastructure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sevenchannel.domain.model.threads.ThreadEntity;

/**
 * Mybatisマッパー（スレッド用）
 * @author koki_shinzato
 */
@Mapper
public interface ThreadMapper {
	
	// 掲示板IDに該当したスレッドリストを取得
	List<ThreadEntity> findById(Integer boardId);
}
