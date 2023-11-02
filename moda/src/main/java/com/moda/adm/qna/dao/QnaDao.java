package com.moda.adm.qna.dao;

import com.moda.adm.qna.service.QnaReqDto;
import com.moda.adm.qna.service.QnaResDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnaDao {
    /**
     *  문의 상세 정보 조회
     *  @param num - 문의 일련번호(PK)
     * @return 문의 상세 정보
     */
    QnaResDto findByNum(Long num);

    /**
     *  문의글 답변 추가
     * @param params - 문의 정보
     */
    void update(QnaReqDto params);

    /**
     *  문의 답변 추가
     * @return 문의 리스트
     */
    List<QnaResDto> findAll();
}