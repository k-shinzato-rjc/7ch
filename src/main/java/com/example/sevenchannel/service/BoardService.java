package com.example.sevenchannel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sevenchannel.domain.model.boards.BoardDto;
import com.example.sevenchannel.domain.model.boards.BoardEntity;
import com.example.sevenchannel.infrastructure.mapper.BoardMapper;

/**
 * 掲示板用サービスクラス
 * @author koki_shinzato
 */
@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	/**
	 * MyBatisマッパーから掲示板リストを取得
	 * Dtoリストに変換して返す
	 * @return 掲示板データ（dtoリスト）
	 */
	public List<BoardDto> findAll() {
		return toDtoList(boardMapper.findAll());
	}
	
	/**
	 * Entityリスト → Dtoリスト 変換
	 * @param entityList
	 * @return dtoList
	 */
	public List<BoardDto> toDtoList(List<BoardEntity> entityList) {
		List<BoardDto> dtoList = new ArrayList<BoardDto>();
		entityList.stream().forEach(e -> dtoList.add(e.toDto()));
		return dtoList;
	}
}
