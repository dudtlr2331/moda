package com.moda.adm.event.service;

import com.moda.adm.event.EventDto;
import com.moda.adm.event.EventSearch;
import com.moda.adm.paging.PagingResponse;
import com.moda.adm.search.SearchDto;

import java.util.List;

public interface EventService {
    Long saveEvent(final EventSearch params);
    EventDto findPostById(final Long id) ;
    Long updateEvent(final EventSearch params);
    Long deleteEvent(final Long id);
    PagingResponse<EventDto> findAllEvent(final SearchDto params);
    List<EventDto> admEventListAjax();
}
