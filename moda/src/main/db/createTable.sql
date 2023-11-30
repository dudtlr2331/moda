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


CREATE TABLE IF NOT EXISTS CATEGORY
( `GOODS_CATA_SEQ`   INT(20)      AUTO_INCREMENT PRIMARY KEY
    , `CATGRY_CD`   VARCHAR(20)      NOT NULL
    , `GOODS_CD`   INT(12)      NOT NULL
    , `CATGRY_NM`   VARCHAR(400)      NULL
    , `NOTE_CONT`   VARCHAR(4000)      NULL
    , `CLASS_LVL_CD`   VARCHAR(20)      NULL
    , `UPR_CLASS_CD`   VARCHAR(20)      NULL
    , `RGST_ID`   VARCHAR(200)      NULL
    , `RGST_DATE`    DATETIME       NULL
    , `USE_YN` VARCHAR(1) NULL
    )ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


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


CREATE TABLE IF NOT EXISTS `tb_file` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '파일 번호 (PK)',
    `prod_id` bigint(20) DEFAULT NULL COMMENT '상품 번호 (FK)',
    `original_name` varchar(255) NOT NULL COMMENT '원본 파일명',
    `save_name` varchar(40) NOT NULL COMMENT '저장 파일명',
    `size` int(11) NOT NULL COMMENT '파일 크기',
    `delete_yn` tinyint(1) NOT NULL COMMENT '삭제 여부',
    `created_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
    `deleted_date` datetime DEFAULT NULL COMMENT '삭제일시',
    `event_id` bigint(20) DEFAULT NULL COMMENT '이벤트 번호',
    `dvsn_value` varchar(10) NOT NULL COMMENT 'DIVISION_VALUE 구분 값',
    PRIMARY KEY (`id`),
    KEY `fk_post_file` (`prod_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=42;
    /* tb_file 테이블 데이터 삽입 */
INSERT INTO `tb_file` (`id`, `prod_id`, `original_name`, `save_name`, `size`, `delete_yn`, `created_date`, `deleted_date`, `event_id`, `dvsn_value`) VALUES
(21, 21, '1.jpg', 'b761cd9319cf4f4a8452464423f3c051.jpg', 652562, 0, '2023-11-16 20:29:27', NULL, NULL, 'product'),
(22, 22, '2.jpg', 'e627943942664326bf346d59f7bb67f5.jpg', 703052, 0, '2023-11-16 20:37:29', NULL, NULL, 'product'),
(23, 23, '3.jpg', '9aa90ae9e4394529a1bc17c4887e11bc.jpg', 679501, 0, '2023-11-16 20:38:02', NULL, NULL, 'product'),
(24, 24, '4.jpg', 'd02e30ff490742fba73a84324406cfb5.jpg', 172807, 0, '2023-11-16 20:38:29', NULL, NULL, 'product'),
(25, 25, '5.jpg', '0ea570fcb3b843c48245c3c480b9bdd1.jpg', 253362, 0, '2023-11-16 20:39:05', NULL, NULL, 'product'),
(26, 26, '6.jpg', '56e37a60f8fd4fddb0c90d02f2598de8.jpg', 201821, 0, '2023-11-16 20:39:36', NULL, NULL, 'product'),
(27, 27, '7.jpg', 'bb7cf45b6ef94163bb6252c9a0131cdf.jpg', 39460, 0, '2023-11-16 20:40:06', NULL, NULL, 'product'),
(28, 28, '10.jpg', '4f3babab321a4a7283b44d5252734484.jpg', 178875, 0, '2023-11-16 20:40:48', NULL, NULL, 'product'),
(29, 29, 'man_to_man_04.jpg', '0478541aaa3746cc91454735bb6eabfd.jpg', 22542, 0, '2023-11-16 20:42:17', NULL, NULL, 'product'),
(30, 30, 'short_sleeved_shirt_10.jpg', '17ec1e08a6454f55aa478520d33d79ee.jpg', 311584, 0, '2023-11-16 20:42:40', NULL, NULL, 'product'),
(32, NULL, 'dress_sample6.png', 'a578a4a23af6490a925958ace7aca5cb.png', 365574, 0, '2023-11-19 05:43:12', NULL, 31, 'product'),
(33, NULL, 'dress_sample7.png', '7eb6b6781b784a14ba025fb8f915901f.png', 1253967, 0, '2023-11-19 06:05:10', NULL, 32, 'product'),
(34, NULL, 'dress_sample11.jpg', '17521530e0f840a79c645af4b69c8755.jpg', 97436, 0, '2023-11-19 06:12:23', NULL, 33, 'product'),
(35, NULL, 'dress_sample6.png', '5f2b7d7bea214ad4aa024f07474032c4.png', 365574, 0, '2023-11-19 06:13:20', NULL, 34, 'product'),
(36, NULL, 'dress_sample6.png', '8031d16233634dbc88c1de5e45e45e86.png', 365574, 0, '2023-11-20 02:19:38', NULL, 35, 'product'),
(37, NULL, 'dress_sample7.png', '22285262d22c445cb3ad50976156ba11.png', 1253967, 0, '2023-11-20 02:21:11', NULL, 36, 'product'),
(38, 37, 'dress_sample11.jpg', '5282e2040c414a4bb0f03cd77a969b7f.jpg', 97436, 0, '2023-11-20 02:24:14', NULL, NULL, 'product'),
(39, NULL, 'banner_01.png', 'dbbf056a64054f8da6ff1f8709972af9.png', 188912, 0, '2023-11-20 03:27:36', NULL, 10, 'event'),
(40, NULL, 'banner_03.png', '077fc5109d10415dbd7ff4e66c9106de.png', 65092, 0, '2023-11-20 03:28:43', NULL, 11, 'event'),
(41, NULL, 'banner2.jpg', '511c1c3f3c5042c48b7742f4512b9c83.jpg', 67401, 0, '2023-11-20 03:29:12', NULL, 12, 'event');

/**/