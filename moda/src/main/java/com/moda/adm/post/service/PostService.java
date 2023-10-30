package com.moda.adm.post.service;

import com.moda.adm.post.PostDto;
import com.moda.adm.post.PostSearch;

import java.util.List;

public interface PostService {
    public Long savePost(final PostSearch params);
    public PostDto findPostById(final Long id) ;
    public Long updatePost(final PostSearch params);
    public Long deletePost(final Long id);
    public List<PostDto> findAllPost();
}
