package com.example.sevenchannel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sevenchannel.domain.model.threads.ThreadDto;
import com.example.sevenchannel.domain.model.threads.ThreadEntity;
import com.example.sevenchannel.infrastructure.mapper.ThreadMapper;

/**
 * スレッドサービス
 * @author koki_shinzato
 */
@Service
public class ThreadService {
	
	@Autowired
	private ThreadMapper threadMapper;
	
	/**
	 * 掲示板IDに該当したスレッドリストを取得
	 * @param boardId
	 * @return スレッドリスト（Dto）
	 */
	public List<ThreadDto> findById(Integer boardId) {
		return toDtoList(threadMapper.findById(boardId));
	}
	
	/**
	 * Entityリスト → Dtoリスト 変換
	 * @param entityList
	 * @return dtoList
	 */
	public List<ThreadDto> toDtoList(List<ThreadEntity> entityList) {
		List<ThreadDto> dtoList = new ArrayList<ThreadDto>();
		entityList.stream().forEach(e -> dtoList.add(e.toDto()));
		return dtoList;
	}
}
