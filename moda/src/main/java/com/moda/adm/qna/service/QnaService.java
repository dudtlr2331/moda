package com.moda.adm.qna.service;

import com.moda.adm.qna.QnaDto;
import com.moda.adm.qna.QnaSearch;
import com.moda.adm.qna.dao.QnaDao;
import com.moda.adm.search.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaService {
    private final QnaDao qnaDao;

    /**
     *  문의 상세 정보 조회
     *  @param num - 문의 일련번호(PK)
     * @return 문의 상세 정보
     */
    @Transactional
    public QnaDto findQnaByNum(final Long num){
        return qnaDao.findByNum(num);
    }

    /**
     *  문의 답변 추가
     * @param params - 문의 정보
     */
    @Transactional
    public Long updateQna(final QnaSearch params){
        qnaDao.update(params);
        return params.getQnaNum();
    }

    /**
     *  문의 리스트 조회
     * @return 문의 리스트
     */
    @Transactional
    public List<QnaDto> findAllQna(final SearchDto params){
        return qnaDao.findAll(params);
    }

    /**
     *  문의 상세 정보 조회
     *  @param uId - 문의 일련번호(PK)
     * @return 문의 상세 정보
     */
    @Transactional
    public List<QnaDto> findQnaById(final String uId){
        return qnaDao.findById(uId);
    }

    /**
     *  문의 작성
     * @param params - 문의 정보
     */
    @Transactional
    public void insertQna(QnaSearch params){
        qnaDao.insert(params);
    }
}
