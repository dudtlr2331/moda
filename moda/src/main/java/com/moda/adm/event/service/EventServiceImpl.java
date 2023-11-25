package com.moda.adm.event.service;

import com.moda.adm.event.EventDto;
import com.moda.adm.event.EventSearch;
import com.moda.adm.event.dao.EventDao;
import com.moda.adm.paging.Pagination;
import com.moda.adm.paging.PagingResponse;
import com.moda.adm.search.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventDao eventDao;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Long saveEvent(final EventSearch params) {
        eventDao.save(params);
        return params.getId();
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public EventDto findPostById(final Long id) {
        return eventDao.findById(id);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updateEvent(final EventSearch params) {
        eventDao.update(params);
        return params.getId();
    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    public Long deleteEvent(final Long id) {
        eventDao.deleteById(id);
        return id;
    }

    /**
     * 게시글 리스트 조회
     *
     * @return 게시글 리스트
     */
    public PagingResponse<EventDto> findAllEvent(final SearchDto params) {

        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
        int count = eventDao.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }

        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<EventDto> list = eventDao.findAll(params);
        return new PagingResponse<>(list, pagination);

    }

    @Override
    public List<EventDto> admEventListAjax() {
        return eventDao.admEventListAjax();
    }

}