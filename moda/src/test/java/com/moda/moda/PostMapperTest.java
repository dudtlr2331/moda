package com.moda.moda;

import com.moda.adm.event.EventDto;
import com.moda.adm.event.EventSearch;
import com.moda.adm.event.service.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostMapperTest {
//    @Autowired PostDao postDao;

    @Autowired
    EventService postService;

    @Test
    void save() {
        EventSearch params = new EventSearch();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        postService.saveEvent(params);

        List<EventDto> posts = postService.findAllEvent();
        System.out.println("전체 게시글 개수는 : " + posts.size() + "개입니다.");
    }

//    @Test
//    void findById() {
//        PostDto post = postDao.findById(1L);
//        try {
//            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
//            System.out.println(postJson);
//
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    void update() {
//        // 1. 게시글 수정
//        PostSearch params = new PostSearch();
//        params.setId(1L);
//        params.setTitle("1번 게시글 제목 수정합니다.");
//        params.setContent("1번 게시글 내용 수정합니다.");
//        params.setWriter("도뎡이");
//        params.setNoticeYn(true);
//        postDao.update(params);
//
//        // 2. 게시글 상세정보 조회
//        PostDto post = postDao.findById(1L);
//        try {
//            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
//            System.out.println(postJson);
//
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    void delete() {
//        System.out.println("삭제 이전의 전체 게시글 개수는 : " + postDao.findAll().size() + "개입니다.");
//        postDao.deleteById(1L);
//        System.out.println("삭제 이후의 전체 게시글 개수는 : " + postDao.findAll().size() + "개입니다.");
//    }
}
