package com.moda.cmm;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    /**
     * 파일 정보 저장
     * @param files - 파일 정보 리스트
     */
    void saveAll(List<FileRequest> files);

    /**
     * 상품 파일 리스트 조회
     * @param prodId - 상품 번호 (FK)
     * @return 파일 리스트
     */
    List<FileResponse> findAllFileByProdId(Long prodId);

    /**
     *  이벤트 파일 리스트 조회
     * @param eventId - 이벤트 번호 (FK)
     * @return 파일 리스트
     */
    List<FileResponse> findAllFileByEventId(Long eventId);

    /**
     * 파일 리스트 조회
     * @param ids - PK 리스트
     * @return 파일 리스트
     */
    List<FileResponse> findAllByIds(List<Long> ids);

    /**
     * 파일 삭제
     * @param ids - PK 리스트
     */
    void deleteAllByIds(List<Long> ids);

    /**
     * 파일 상세정보 조회
     * @param id - PK
     * @return 파일 상세정보
     */
    FileResponse findById(Long id);
}