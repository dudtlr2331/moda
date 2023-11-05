package com.moda.adm.qna;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaSearch {        // Request
    private Long qna_num;       // 질문 일련 번호
    private String id;          // PK 작성자 아이디
    private String title;       // 제목
    private String q_content;   // 질문
    private String a_content;   // 답변
    private Boolean stat;       // 답변 상태
}