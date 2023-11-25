package com.moda.adm.event;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class EventDto {
    private Long id;                       // PK
    private String title;                  // 제목
    private String content;                // 내용
    private String writer;                 // 작성자
    private int viewCnt;                   // 조회 수
    private Boolean noticeYn;              // 공지글 여부
    private Boolean deleteYn;              // 삭제 여부
    private LocalDateTime createdDate;     // 생성일시
    private LocalDateTime modifiedDate;    // 최종 수정일시
    private String imgPath;      // 이미지 패스
    private String imgNm;        // 이미지 이름
}
