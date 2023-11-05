package com.moda.adm.qna;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QnaDto {           // Response
    private Long qnaNum;       // 질문 일련 번호
    private String id;          // PK 작성자 아이디
    private String title;       // 제목
    private String qContent;   // 질문
    private String aContent;   // 답변
    private Boolean stat;       // 답변 상태
    private LocalDateTime qnaDate;    // 질문한 날짜 및 시간
}