package com.moda.adm.event.service;

import com.moda.adm.event.EventDto;
import com.moda.adm.event.EventSearch;
import com.moda.adm.event.dao.EventDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
     * @return 게시글 리스트
     */
    public List<EventDto> findAllEvent() {
        return eventDao.findAll();
    }

}