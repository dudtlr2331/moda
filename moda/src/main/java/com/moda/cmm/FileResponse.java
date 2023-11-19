package com.moda.cmm;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FileResponse {
    private Long id;                      // 파일 번호 (PK)
    private Long prodId;                  // 상품 번호 (FK)
    private Long eventId;                 // 이벤트 번호
    private String originalName;          // 원본 파일명
    private String saveName;              // 저장 파일명
    private long size;                    // 파일 크기
    private Boolean deleteYn;             // 삭제 여부
    private String dvsnValue;             // 구분 값 (ex "event", "product")
    private LocalDateTime createdDate;    // 생성일시
    private LocalDateTime deletedDate;    // 삭제일시
}