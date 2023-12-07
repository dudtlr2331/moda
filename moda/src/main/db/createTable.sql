-- 테이블 moda.category 구조 내보내기
CREATE TABLE IF NOT EXISTS `category` (
    `GOODS_CATA_SEQ` int(20) NOT NULL AUTO_INCREMENT,
    `CATGRY_CD` varchar(20) NOT NULL,
    `GOODS_CD` int(12) NOT NULL,
    `CATGRY_NM` varchar(400) DEFAULT NULL,
    `NOTE_CONT` varchar(4000) DEFAULT NULL,
    `CLASS_LVL_CD` varchar(20) DEFAULT NULL,
    `UPR_CLASS_CD` varchar(20) DEFAULT NULL,
    `RGST_ID` varchar(200) DEFAULT NULL,
    `RGST_DATE` datetime DEFAULT NULL,
    `USE_YN` varchar(1) DEFAULT NULL,
    PRIMARY KEY (`GOODS_CATA_SEQ`)
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 moda.category:~2 rows (대략적) 내보내기
INSERT INTO `category` (`GOODS_CATA_SEQ`, `CATGRY_CD`, `GOODS_CD`, `CATGRY_NM`, `NOTE_CONT`, `CLASS_LVL_CD`, `UPR_CLASS_CD`, `RGST_ID`, `RGST_DATE`, `USE_YN`) VALUES
                                                                                                                                                                   (1, 'CT1', 1, 'your_catgry_nm_value', 'your_note_cont_value', 'lvl_cd_value', 'class_cd_value', '_id_value', NULL, '1'),
                                                                                                                                                                   (2, 'CT1', 1, 'your_catgry_nm_value', 'your_note_cont_value', 'lvl_cd_value', 'class_cd_value', '_id_value', NULL, '1'),
                                                                                                                                                                   (3, 'CT1', 1, 'your_catgry_nm_value', 'your_note_cont_value', 'lvl_cd_value', 'class_cd_value', '_id_value', NULL, '1');

-- 테이블 moda.ord_base 구조 내보내기
CREATE TABLE IF NOT EXISTS `ord_base` (
    `ORD_NO` varchar(200) NOT NULL,
    `USR_ID` varchar(200) NOT NULL,
    `ORD_STAT` varchar(8) DEFAULT NULL,
    `ORDR_ID` varchar(200) DEFAULT NULL,
    `ORDR_NM` varchar(200) DEFAULT NULL,
    `ORDR_PHON` varchar(20) DEFAULT NULL,
    `ORDR_EMAIL` varchar(200) DEFAULT NULL,
    `ACQR_PHON` varchar(20) DEFAULT NULL,
    `ACQR_NM` varchar(200) DEFAULT NULL,
    `ACQR_ADDR` varchar(1000) DEFAULT NULL,
    `ACQR_ADDR_DTL` varchar(500) DEFAULT NULL,
    `ACQR_EMAIL` varchar(200) DEFAULT NULL,
    `PAY_WAY` varchar(100) DEFAULT NULL,
    `PAY_MNY` int(12) DEFAULT NULL,
    `REQ_MEMO` varchar(500) DEFAULT NULL,
    `ORD_DATE` datetime DEFAULT NULL,
    `BILL_NUM` int(12) DEFAULT NULL,
    `PROD_CODE` int(12) NOT NULL,
    PRIMARY KEY (`ORD_NO`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 moda.ord_base:~9 rows (대략적) 내보내기
INSERT INTO `ord_base` (`ORD_NO`, `USR_ID`, `ORD_STAT`, `ORDR_ID`, `ORDR_NM`, `ORDR_PHON`, `ORDR_EMAIL`, `ACQR_PHON`, `ACQR_NM`, `ACQR_ADDR`, `ACQR_ADDR_DTL`, `ACQR_EMAIL`, `PAY_WAY`, `PAY_MNY`, `REQ_MEMO`, `ORD_DATE`, `BILL_NUM`, `PROD_CODE`) VALUES
('ORD_20231207042347', 'test1', '주문완료', 'test1', 'test', '010', 'test', '010', 'test', 'test', '107동 202호', 'test', 'card', 40000, '요청 사항 입니다.', '2023-12-07 04:23:47', 11111111, 22);

-- 테이블 moda.ord_dtl 구조 내보내기
CREATE TABLE IF NOT EXISTS `ord_dtl` (
    `ORD_DTL_NO` int(12) NOT NULL AUTO_INCREMENT,
    `USR_ID` varchar(20) NOT NULL,
    `ORD_NO` varchar(200) NOT NULL,
    `PROD_NAME` varchar(200) DEFAULT NULL,
    `PROD_CODE` int(12) DEFAULT NULL,
    `PROD_QTY` int(11) DEFAULT NULL,
    PRIMARY KEY (`ORD_DTL_NO`)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 moda.ord_dtl:~0 rows (대략적) 내보내기
INSERT INTO `ord_dtl` (`ORD_DTL_NO`, `USR_ID`, `ORD_NO`, `PROD_NAME`, `PROD_CODE`, `PROD_QTY`) VALUES
(2, 'test1', 'ORD_20231207042347', '검정바지', 22, 1);

-- 테이블 moda.product 구조 내보내기
CREATE TABLE IF NOT EXISTS `product` (
    `prod_code` int(11) NOT NULL AUTO_INCREMENT,
    `cate_code` int(11) NOT NULL,
    `prod_name` varchar(100) NOT NULL,
    `prod_stock` int(11) NOT NULL,
    `prod_desc` varchar(3000) NOT NULL,
    `prod_dete` datetime NOT NULL DEFAULT current_timestamp(),
    `prod_price` int(11) NOT NULL,
    `prod_img` varchar(1000) DEFAULT NULL,
    `prod_img_dtl` varchar(1000) DEFAULT NULL,
    `prod_dcnt` int(11) DEFAULT NULL,
    PRIMARY KEY (`prod_code`)
    ) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 moda.product:~12 rows (대략적) 내보내기
INSERT INTO `product` (`prod_code`, `cate_code`, `prod_name`, `prod_stock`, `prod_desc`, `prod_dete`, `prod_price`, `prod_img`, `prod_img_dtl`, `prod_dcnt`) VALUES
(21, 1, '흰바지', 10, '1', '2023-11-16 20:29:27', 40000, '/images/231116', '/b761cd9319cf4f4a8452464423f3c051.jpg', 0),
(22, 1, '검정바지', 10, '10', '2023-11-16 20:37:28', 40000, '/images/231116', '/e627943942664326bf346d59f7bb67f5.jpg', 0),
(23, 1, '청바지', 10, '10', '2023-11-16 20:38:02', 50000, '/images/231116', '/9aa90ae9e4394529a1bc17c4887e11bc.jpg', 0),
(24, 10, '회색바지', 10, '1', '2023-11-16 20:38:29', 40000, '/images/231116', '/d02e30ff490742fba73a84324406cfb5.jpg', 0),
(25, 1, '회색 조끼', 10, '10', '2023-11-16 20:39:05', 38000, '/images/231116', '/0ea570fcb3b843c48245c3c480b9bdd1.jpg', 0),
(26, 1, '트레이닝복 세트', 10, '10', '2023-11-16 20:39:36', 59000, '/images/231116', '/56e37a60f8fd4fddb0c90d02f2598de8.jpg', 0),
(27, 1, '검정색 니트', 10, '10', '2023-11-16 20:40:06', 49000, '/images/231116', '/bb7cf45b6ef94163bb6252c9a0131cdf.jpg', 0),
(28, 1, '파란색 맨투맨', 10, '10', '2023-11-16 20:40:48', 69000, '/images/231116', '/4f3babab321a4a7283b44d5252734484.jpg', 0),
(29, 1, '나이키 회색 맨투맨', 10, '10', '2023-11-16 20:42:17', 69000, '/images/231116', '/0478541aaa3746cc91454735bb6eabfd.jpg', 0),
(30, 1, '흰색 반팔', 10, '10', '2023-11-16 20:42:40', 29000, '/images/231116', '/17ec1e08a6454f55aa478520d33d79ee.jpg', 0),
(31, 10, '테스트 상품', 12, '12', '2023-11-19 05:43:12', 124003, '/images/231119', '/a578a4a23af6490a925958ace7aca5cb.png', 0);

-- 테이블 moda.qna 구조 내보내기
CREATE TABLE IF NOT EXISTS `qna` (
    `qna_num` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `u_id` varchar(20) NOT NULL COMMENT '작성자 ID',
    `qna_title` varchar(100) NOT NULL COMMENT '제목',
    `qna_q` varchar(3000) NOT NULL COMMENT '질문 내용',
    `qna_a` varchar(3000) DEFAULT NULL COMMENT '답변 내용',
    `qna_stat` tinyint(1) NOT NULL DEFAULT 0 COMMENT '답변대기:0, 답변종료:1',
    `qna_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '문의일',
    PRIMARY KEY (`qna_num`)
    ) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='문의DB';

-- 테이블 데이터 moda.qna:~9 rows (대략적) 내보내기
INSERT INTO `qna` (`qna_num`, `u_id`, `qna_title`, `qna_q`, `qna_a`, `qna_stat`, `qna_date`) VALUES
(1, '사용자_아이디', '질문 제목', '질문 내용', '답변 내용', 1, '2023-11-05 19:18:53'),
(2, '사용자_아이디', '질문 제목', '질문 내용', '답변 내용', 0, '2023-11-05 19:19:57'),
(3, 'test123', '문의 입니다.', '이렇게 팔면 안됩니다!', NULL, 0, '2023-11-09 20:42:25'),
(4, 'test234', '문의 합니다.', '이게 맞는건가..싶습니다.', NULL, 0, '2023-11-09 20:42:27'),
(5, 'test234', '문의 합니다.', '이게 맞는건가..싶습니다.', NULL, 0, '2023-11-09 20:42:27'),
(6, 'test345', '문의 있습니다.', '잘 생각해보세요.', NULL, 0, '2023-11-09 20:42:29'),
(7, 'test6363', '꼭 봐주세요.', '환불은 안되나요?', NULL, 0, '2023-11-09 20:42:30'),
(8, 'ddd123', '환불해주세요.', '청바지 샀는데 환불 안되면 고소합니다.', '환불 해드렸습니다.', 1, '2023-11-09 20:42:31'),
(9, 'aaa6234', '교환가능?', '교환해주세요. 사이즈가 안맞네요.', '교환 해드렸습니다.', 1, '2023-11-09 20:42:32');

-- 테이블 moda.tb_file 구조 내보내기
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
    ) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='파일';

-- 테이블 데이터 moda.tb_file:~18 rows (대략적) 내보내기
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
(41, NULL, 'banner2.jpg', '511c1c3f3c5042c48b7742f4512b9c83.jpg', 67401, 0, '2023-11-20 03:29:12', NULL, 12, 'event'),
(42, NULL, 'banner_04.png', '4ccd6239f5de45f9bc9a36740e6e7721.png', 393664, 0, '2023-11-27 02:31:13', NULL, 13, 'event'),
(43, NULL, '짱구.jpg', '1749398ccc724c698d716342a3f10b32.jpg', 36662, 0, '2023-12-03 21:33:32', NULL, 14, 'event');

-- 테이블 moda.tb_post 구조 내보내기
CREATE TABLE IF NOT EXISTS `tb_post` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `title` varchar(100) NOT NULL COMMENT '제목',
    `content` varchar(3000) NOT NULL COMMENT '내용',
    `writer` varchar(20) NOT NULL COMMENT '작성자',
    `view_cnt` int(11) NOT NULL COMMENT '조회 수',
    `notice_yn` tinyint(1) NOT NULL COMMENT '공지글 여부',
    `delete_yn` tinyint(1) NOT NULL COMMENT '삭제 여부',
    `created_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
    `modified_date` datetime DEFAULT NULL COMMENT '최종 수정일시',
    `img_path` varchar(500) DEFAULT NULL COMMENT '이미지 패스',
    `img_nm` varchar(500) DEFAULT NULL COMMENT '이미지 이름',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='게시글';

-- 테이블 데이터 moda.tb_post:~4 rows (대략적) 내보내기
INSERT INTO `tb_post` (`id`, `title`, `content`, `writer`, `view_cnt`, `notice_yn`, `delete_yn`, `created_date`, `modified_date`, `img_path`, `img_nm`) VALUES
(10, '봄 특가 배너', '봄 특가 배너', '이벤트 배너1', 0, 0, 0, '2023-11-20 03:27:36', NULL, '/images/231120', '/dbbf056a64054f8da6ff1f8709972af9.png'),
(11, '빼빼로 데이', '빼빼로 데이', '이벤트 배너2', 0, 0, 0, '2023-11-20 03:28:43', NULL, '/images/231120', '/077fc5109d10415dbd7ff4e66c9106de.png'),
(12, '지금까지 이런 쇼핑몰은 없었다', '지금까지 이런 쇼핑몰은 없었다', '이벤트 배너3', 0, 0, 0, '2023-11-20 03:29:12', NULL, '/images/231120', '/511c1c3f3c5042c48b7742f4512b9c83.jpg'),
(13, 'test', 'test', 'test', 0, 0, 0, '2023-11-27 02:31:13', NULL, '/images/231127', '/4ccd6239f5de45f9bc9a36740e6e7721.png'),
(14, '123', '123', '123', 0, 0, 1, '2023-12-03 21:33:31', NULL, '/images/231203', '/1749398ccc724c698d716342a3f10b32.jpg');

-- 테이블 moda.users 구조 내보내기
CREATE TABLE IF NOT EXISTS `users` (
    `u_num` bigint(20) NOT NULL AUTO_INCREMENT,
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
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 moda.users:~0 rows (대략적) 내보내기
INSERT INTO `users` (`u_num`, `u_id`, `u_pass`, `u_name`, `u_email`, `u_post`, `u_addr`, `u_phone`, `u_date`, `u_admin`) VALUES
(1, 'test1', '1234', 'test', 'test', 12354, 'test', '010', '2023-11-20 20:37:51', '1'),
(2, 'test', '1234', 'test', 'test@naver.com', 10111, 'asd', 'asd', '2023-11-28 20:00:24', '0');


/******************************************* 낡은 테이블 **********************************************/
CREATE TABLE IF NOT EXISTS `cart` (
    `cart_num` int(11) NOT NULL AUTO_INCREMENT,
    `u_id` varchar(50) NOT NULL,
    `prod_code` int(11) NOT NULL,
    `cart_amount` int(11) NOT NULL,
    PRIMARY KEY (`cart_num`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `tb_post` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `title` varchar(100) NOT NULL COMMENT '제목',
    `content` varchar(3000) NOT NULL COMMENT '내용',
    `writer` varchar(20) NOT NULL COMMENT '작성자',
    `img_nm` varchar(100) DEFAULT NULL,
    `img_path` varchar(100) DEFAULT NULL,
    `view_cnt` int(11) NOT NULL COMMENT '조회 수',
    `notice_yn` tinyint(1) NOT NULL COMMENT '공지글 여부',
    `delete_yn` tinyint(1) NOT NULL COMMENT '삭제 여부',
    `created_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일시',
    `modified_date` datetime DEFAULT NULL COMMENT '최종 수정일시',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='게시글';

CREATE TABLE IF NOT EXISTS CATEGORY
( `GOODS_CATA_SEQ`   INT(20)      AUTO_INCREMENT PRIMARY KEY
    , `CATGRY_CD`   VARCHAR(20)      NOT NULL
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

CREATE TABLE IF NOT EXISTS `product` (
    `prod_code` int(11) NOT NULL AUTO_INCREMENT,
    `cate_code` varchar(40) NOT NULL,
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


/* 주문 테이블 */
CREATE TABLE ORD_BASE (
  ORD_NO	VARCHAR(100)		PRIMARY KEY,
  USR_ID	VARCHAR(200)		NOT NULL,
  ORD_STAT	VARCHAR(8)		NULL,
  ORDR_ID	VARCHAR(200)		NULL,
  ORDR_NM	VARCHAR(200)		NULL,
  ORDR_PHON	VARCHAR(20)		NULL,
  ORDR_EMAIL	VARCHAR(200)		NULL,
  ACQR_PHON	VARCHAR(20)		NULL,
  ACQR_NM	VARCHAR(200)		NULL,
  ACQR_ADDR	VARCHAR(1000)		NULL,
  ACQR_ADDR_DTL	VARCHAR(500)		NULL,
  ACQR_EMAIL	VARCHAR(200)		NULL,
  PAY_WAY	VARCHAR(100)		NULL,
  PAY_MNY	INT(12)		NULL,
  REQ_MEMO	VARCHAR(500)		NULL,
  ORD_DATE 	DATETIME 		NULL,
  BILL_NUM	INT(12)		NULL,
  PROD_CODE	INT(12)		NOT NULL
);

/* 주문 상세 테이블 */
CREATE TABLE ORD_DTL (
    ORD_DTL_NO	INT(12)	AUTO_INCREMENT PRIMARY KEY,
    USR_ID	VARCHAR(20)	NOT NULL,
    ORD_NO	VARCHAR(200)	NOT NULL,
    PROD_NAME	VARCHAR(200)	NULL,
    PROD_CODE	INT(12)	NULL,
    PROD_QTY	INT	NULL
);


/* 카테고리 예시 데이터 */
INSERT INTO category VALUES(1,'a101','상의','모든상의','1',NULL,'test1234',NOW(),'Y');
INSERT INTO category VALUES(2,'a102','아우터','겉옷','2','a101','test1234',NOW(),'Y');
INSERT INTO category VALUES(3,'a103','코트','따뜻해요','2','a101','test1234',NOW(),'Y');
INSERT INTO category VALUES(4,'b104','하의','모든하의','1',NULL,'test1234',NOW(),'N');
INSERT INTO category VALUES(5,'b105','셔츠','셔츠','2','a101','test1234',NOW(),'Y');
INSERT INTO category VALUES(6,'c106','청바지','청바지','2','b104','test1234',NOW(),'Y');


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


/* QnA 테이블 예시 데이터 */
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`) VALUES ('test123', '문의 입니다.', '이렇게 팔면 안됩니다!');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`) VALUES ('test234', '문의 합니다.', '이게 맞는건가..싶습니다.');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`) VALUES ('test345', '문의 있습니다.', '잘 생각해보세요.');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`) VALUES ('test6363', '꼭 봐주세요.', '환불은 안되나요?');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`, `qna_a`, `qna_stat`) VALUES ('ddd123', '환불해주세요.', '청바지 샀는데 환불 안되면 고소합니다.', '환불 해드렸습니다.', '1');
INSERT INTO `moda`.`qna` (`u_id`, `qna_title`, `qna_q`, `qna_a`, `qna_stat`) VALUES ('aaa6234', '교환가능?', '교환해주세요. 사이즈가 안맞네요.', '교환 해드렸습니다.', '1');

