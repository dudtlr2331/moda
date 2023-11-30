package com.moda.adm.category;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class CateVO {

    private long goodsCataSeq;
    private String catgryCd;
    private int goodsCd;
    private String catgryNm;
    private String noteCont;
    private String classLvlCd;
    private String uprClassCd;
    private String rgstId;
    private String rgstDate;
    private String useYn;
    private String upCateType;
}