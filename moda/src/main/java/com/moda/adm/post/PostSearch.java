package com.moda.adm.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSearch {

    private Long id;             // PK
    private String title;        // 제목
    private String content;      // 내용
    private String writer;       // 작성자
    private Boolean noticeYn;    // 공지글 여부
}
