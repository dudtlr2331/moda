package com.moda.moda.product;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProdVO {
    private int prodCode;
    private int cateCode;
    private String prodName;
    private int prodStock;
    private String prodDesc;
    private String prodDete;
    private int prodPrice;
    private String prodImg;
    private String prodImgDtl;
    private int prodDcnt;
    private List<MultipartFile> files = new ArrayList<>();    // 첨부파일 List
    private List<Long> removeFileIds = new ArrayList<>(); // 삭제할 첨부파일 id List
}
