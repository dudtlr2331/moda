package com.moda.adm.post.dao;

import com.moda.adm.post.PostDto;
import com.moda.adm.post.PostSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostDao {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(PostSearch params);

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    PostDto findById(Long id);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(PostSearch params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<PostDto> findAll();

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count();

}