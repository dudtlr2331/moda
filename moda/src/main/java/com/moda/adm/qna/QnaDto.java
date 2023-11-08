package com.moda.adm.qna;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QnaDto {           // Response
    private Long qnaNum;       // PK 질문 일련 번호
    private String uId;          // 작성자 아이디
    private String qnaTitle;       // 제목
    private String qnaQ;   // 질문
    private String qnaA;   // 답변
    private int qnaStat;       // 답변 상태
    private LocalDateTime qnaDate;    // 질문한 날짜 및 시간
}