package com.moda.adm.category;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class CateVO {

    private String goodsCataSeq;
    private String catgryCd;
    private String catgryNm;
    private String noteCont;
    private String classLvlCd;
    private String uprClassCd;
    private String rgstId;
    private LocalDateTime rgstDate;
    private String useYn;
    private String cateType;

    List<CateVO> subCate = new ArrayList<>();
}