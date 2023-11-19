package com.moda.cmm;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FileRequest {
    private Long id;                // 파일 번호 (PK)
    private Long prodId;            // 상품 번호 (FK)
    private Long eventId;           // 이벤트 번호
    private String originalName;    // 원본 파일명
    private String saveName;        // 저장 파일명
    private long size;              // 파일 크기
    private String filePath;        // 추가된 부분
    private String dvsnValue;       // 구분 값 (ex "event", "product")

    @Builder
    public FileRequest(String originalName, String saveName, long size, String filePath) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.size = size;
        this.filePath = filePath;
    }

    // 파일 경로를 설정하는 메서드 추가
    public FileRequest filePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setDvsnValue(String dvsnValue) {
        this.dvsnValue = dvsnValue;
    }
}