package com.example.sevenchannel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sevenchannel.domain.model.posts.PostDto;
import com.example.sevenchannel.domain.model.posts.PostEntity;
import com.example.sevenchannel.infrastructure.mapper.PostMapper;

/**
 * 投稿データ用サービス
 * @author koki_shinzato
 */
@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostMapper postMapper;
	
	/**
	 * スレッドごとの全投稿リストを取得
	 * @param threadId
	 * @return 投稿データ（Dto）
	 */
	public List<PostDto> findById(Integer threadId) {
		return toDtoList(postMapper.findById(threadId));
	}
	
	public void save(PostDto postDto) {
		postMapper.save(postDto.toEntity());
	}
	
	/**
	 * Entityリスト → Dtoリスト 変換
	 * @param entityList
	 * @return dtoList
	 */
	public List<PostDto> toDtoList(List<PostEntity> entityList) {
		List<PostDto> dtoList = new ArrayList<PostDto>();
		entityList.stream().forEach(e -> dtoList.add(e.toDto()));
		return dtoList;
	}
}
