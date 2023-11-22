/******************************************* 테이블 **********************************************/
DROP TABLE USR_BASE;
DROP TABLE GOODS_INFO;
DROP TABLE SALE_BOARD_RVW;
DROP TABLE QNA_BOARD;
DROP TABLE STD_CD_BASE;
DROP TABLE ENTR_BASE;
DROP TABLE GOODS_CATA;
DROP TABLE SALE_BOARD;
DROP TABLE ORD_BASE;
DROP TABLE ORD_DTL;
DROP TABLE ORD_BASKET;
DROP TABLE ORD_BASKET_HIST;
DROP TABLE COUPON_TBL;
DROP TABLE EVENT_TBL;

CREATE TABLE IF NOT EXISTS `cart` (
    `cart_num` int(11) NOT NULL AUTO_INCREMENT,
    `u_id` varchar(50) NOT NULL,
    `prod_code` int(11) NOT NULL,
    `cart_amount` int(11) NOT NULL,
    PRIMARY KEY (`cart_num`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `category` (
    `cate_code` int(11) NOT NULL AUTO_INCREMENT,
    `cate_name` varchar(30) NOT NULL,
    PRIMARY KEY (`cate_code`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `event` (
    `no_id` int(11) NOT NULL AUTO_INCREMENT,
    `u_id` varchar(50) NOT NULL,
    `no_image` varchar(1000) DEFAULT NULL,
    `no_date_st` varchar(20) NOT NULL,
    `no_date_ed` varchar(20) NOT NULL,
    PRIMARY KEY (`no_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `order` (
    `ord_num` int(11) NOT NULL AUTO_INCREMENT,
    `u_id` varchar(50) NOT NULL,
    `ord_date` varchar(45) NOT NULL,
    `ord_owner` varchar(50) NOT NULL,
    `ord_phone` varchar(30) NOT NULL,
    `ord_addr` varchar(100) DEFAULT NULL,
    `ord_post` varchar(200) NOT NULL,
    `ord_amount` int(11) NOT NULL,
    `ord_pay` tinyint(4) NOT NULL,
    PRIMARY KEY (`ord_num`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `order_dtl` (
    `ord_dtl_num` int(11) NOT NULL AUTO_INCREMENT,
    `ord_num` int(11) NOT NULL,
    `prod_code` int(11) NOT NULL,
    `ord_dtl_cnt` int(11) NOT NULL,
    PRIMARY KEY (`ord_dtl_num`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `product` (
    `prod_code` int(11) NOT NULL AUTO_INCREMENT,
    `cate_code` int(11) NOT NULL,
    `prod_name` varchar(100) NOT NULL,
    `prod_stock` int(11) NOT NULL,
    `prod_desc` varchar(3000) NOT NULL,
    `prod_dete` varchar(45) NOT NULL,
    `prod_price` int(11) NOT NULL,
    `prod_img` varchar(1000) DEFAULT NULL,
    `prod_img_dtl` varchar(1000) NOT NULL,
    `prod_dcnt` int(11) DEFAULT NULL,
    PRIMARY KEY (`prod_code`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `review` (
    `rvw_num` int(11) NOT NULL AUTO_INCREMENT,
    `ord_num` int(11) NOT NULL,
    `prod_code` int(11) NOT NULL,
    `rvw_name` varchar(50) NOT NULL,
    `rvw_title` varchar(250) NOT NULL,
    `rvw_cont` varchar(3000) NOT NULL,
    `rvw_date` varchar(45) NOT NULL,
    PRIMARY KEY (`rvw_num`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `sub_category` (
    `sub_cate_code` int(11) NOT NULL AUTO_INCREMENT,
    `cate_code2` int(11) NOT NULL,
    `sub_cate_name` varchar(30) NOT NULL,
    PRIMARY KEY (`sub_cate_code`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE IF NOT EXISTS `users` (
    `u_num` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `u_id` varchar(50) NOT NULL,
    `u_pass` varchar(50) NOT NULL DEFAULT '',
    `u_name` varchar(15) NOT NULL DEFAULT '',
    `u_email` varchar(100) NOT NULL DEFAULT '',
    `u_post` int(11) DEFAULT NULL,
    `u_addr` varchar(200) DEFAULT NULL,
    `u_phone` varchar(30) DEFAULT NULL,
    `u_date` datetime NOT NULL,
    `u_admin` varchar(1) NOT NULL DEFAULT '0',
    PRIMARY KEY (`u_num`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* QnA 테이블 */
CREATE TABLE `qna` (
     `qna_num`       bigint(20)    NOT NULL AUTO_INCREMENT COMMENT 'PK',
     `u_id`          VARCHAR(20)  NOT NULL COMMENT '작성자 ID',
     `qna_title`     VARCHAR(100)   NOT NULL COMMENT '제목',
     `qna_q`         VARCHAR(3000) NOT NULL COMMENT '질문 내용',
     `qna_a`         VARCHAR(3000) NULL COMMENT '답변 내용',
     `qna_stat`      tinyint(1)    NOT NULL DEFAULT 0 COMMENT '답변대기:0, 답변종료:1',
     `qna_date`  	 datetime      NOT NULL DEFAULT current_timestamp() COMMENT '문의일',
     PRIMARY KEY (`qna_num`)
) COMMENT '문의DB';
/* QnA 테이블 예시 데이터 */
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`) VALUES ('test123', '문의 입니다.', '이렇게 팔면 안됩니다!');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`) VALUES ('test234', '문의 합니다.', '이게 맞는건가..싶습니다.');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`) VALUES ('test345', '문의 있습니다.', '잘 생각해보세요.');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`) VALUES ('test6363', '꼭 봐주세요.', '환불은 안되나요?');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`, `qna_a`, `qna_stat`) VALUES ('ddd123', '환불해주세요.', '청바지 샀는데 환불 안되면 고소합니다.', '환불 해드렸습니다.', '1');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`, `qna_a`, `qna_stat`) VALUES ('aaa6234', '교환가능?', '교환해주세요. 사이즈가 안맞네요.', '교환 해드렸습니다.', '1');