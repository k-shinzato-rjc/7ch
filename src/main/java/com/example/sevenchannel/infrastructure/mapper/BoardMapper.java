package com.example.sevenchannel.infrastructure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sevenchannel.domain.model.boards.BoardEntity;

/**
 * Mybatis用マッパー（掲示板用）
 * @author koki_shinzato
 */
@Mapper
public interface BoardMapper {
	
	List<BoardEntity> findAll();
}
