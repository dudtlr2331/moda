package com.moda.adm.event.dao;

import com.moda.adm.event.EventDto;
import com.moda.adm.event.EventSearch;
import com.moda.adm.search.SearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventDao {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    void save(EventSearch params);

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    EventDto findById(Long id);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void update(EventSearch params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<EventDto> findAll(SearchDto params);

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count(SearchDto params);

    /**
     * 이벤트 Ajax
     * @return 이벤트 리스트
     */
    List<EventDto> admEventListAjax();
}