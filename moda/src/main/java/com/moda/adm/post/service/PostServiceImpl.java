package com.moda.adm.post.service;

import com.moda.adm.post.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostDao postDao;

    @Autowired
    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }
}
