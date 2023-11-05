package com.moda.adm.qna;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaSearch {        // Request
    private Long qnaNum;       // PK 질문 일련 번호
    private String id;          // 작성자 아이디
    private String title;       // 제목
    private String qContent;   // 질문
    private String aContent;   // 답변
    private int stat;       // 답변 상태
}
