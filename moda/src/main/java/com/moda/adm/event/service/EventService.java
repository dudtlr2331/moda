package com.moda.adm.event.service;

import com.moda.adm.event.EventDto;
import com.moda.adm.event.EventSearch;
import com.moda.adm.paging.PagingResponse;
import com.moda.adm.search.SearchDto;

import java.util.List;

public interface EventService {
    public Long saveEvent(final EventSearch params);
    public EventDto findPostById(final Long id) ;
    public Long updateEvent(final EventSearch params);
    public Long deleteEvent(final Long id);
    public PagingResponse<EventDto> findAllEvent(final SearchDto params);
}
