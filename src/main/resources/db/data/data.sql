INSERT INTO blacklist(blacklist_no,blacklist_reg_date,blacklist_rel_date,member_no)
VALUES(1,'2023-05-15','2023-06-30',1);
INSERT INTO blacklist(blacklist_no,blacklist_reg_date,blacklist_rel_date,member_no)
VALUES(2,'2023-07-25','2023-08-20',2);
INSERT INTO blacklist(blacklist_no,blacklist_reg_date,blacklist_rel_date,member_no)
VALUES(3,'2023-05-15', null, 3);


-- INSERT INTO category(category_no,category_name,sub_category_name)
-- VALUES(1,'한국','과자');
-- INSERT INTO category(category_no,category_name,sub_category_name)
-- VALUES(2,'일본','과자');
-- INSERT INTO category(category_no,category_name,sub_category_name)
-- VALUES(3,'대만','과자');


INSERT INTO food(food_no,food_name,country,food_type,food_rate,food_price)
VALUES(1,'오레오','한국','과자',4.7,2000);
INSERT INTO food(food_no,food_name,country,food_type,food_rate,food_price)
VALUES(2,'초코롤','미국','차',5.0,3000);
INSERT INTO food(food_no,food_name,country,food_type,food_rate,food_price)
VALUES(3,'초록매실','일본','빵',4.3,1800);
INSERT INTO food(food_no,food_name,country,food_type,food_rate,food_price)
VALUES(4,'nullTest','일본','빵',0.0,1000);


INSERT INTO food_pic(food_no,food_pic_url)
VALUES(1,'link');
INSERT INTO food_pic(food_no,food_pic_url)
VALUES(2,'link');
INSERT INTO food_pic(food_no,food_pic_url)
VALUES(3,'link');



INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc000','pwd000','초코맛있다','dkem@gmail.com',20,0,'2001-08-04');
VALUES('abc000','$2a$12$jirbZeEp2BWrrlwXxIjb5uAFhF//a.nMocLQlYb58mV4wKNq5GvCC','초코맛있다','myrhymetree@gmail.com','ROLE_MEMBER',0,'2001-08-04','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc001','pwd111','오늘은뭐먹지','zmzlsk@gmail.com',30,20,'1990-01-20');
VALUES('abc001','$2a$12$S.uKNb4nk6g4RFUsxDYyZO6UTbdvotNsOJPmvUM/E2O7gMVguv7Cu','오늘은뭐먹지','zmzlsk@gmail.com','ROLE_MEMBER',20,'1990-01-20','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc002','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc002','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc003','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc003','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc004','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc004','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc005','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc005','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc006','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc006','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc007','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc007','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc008','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc008','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc009','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc009','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc010','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc010','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');
INSERT INTO member(member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth,member_country)
-- VALUES('abc011','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');
VALUES('abc011','$2a$12$Zvaej4PNgRURKlAMPurdsuq3y/ScO/wU8g0iRyHj8yYlDypmbjwhq','돼징','ehowld@gmail.com','ROLE_MEMBER',0,'2008-11-30','한국');



INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(1,1,2,3,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(2,3,3,2,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(3,1,2,3,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(4,3,3,2,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(5,1,2,3,3);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(6,3,3,2,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(7,1,2,3,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(8,3,3,2,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(9,1,2,3,2);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(10,3,3,2,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(11,1,2,3,3);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(12,3,3,2,2);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(13,1,2,3,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(14,3,3,2,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(15,1,2,3,2);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(16,3,3,2,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(17,1,2,3,3);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(18,3,3,2,2);


INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('한국','과자','신상요청1',1500,1, 'test1');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('일본','과자','신상요청2',1500,2, 'test2');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('대만','과자','신상요청3',1500,3, 'test3');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('한국','과자','신상요청1',1500,1, 'test1');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('일본','과자','신상요청2',1500,2, 'test2');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('대만','과자','신상요청3',1500,3, 'test3');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('한국','과자','신상요청1',1500,1, 'test1');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('일본','과자','신상요청2',1500,2, 'test2');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('대만','과자','신상요청3',1500,3, 'test3');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('한국','과자','신상요청1',1500,1, 'test1');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('일본','과자','신상요청2',1500,2, 'test2');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('대만','과자','신상요청3',1500,3, 'test3');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('한국','과자','신상요청1',1500,1, 'test1');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('일본','과자','신상요청2',1500,2, 'test2');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('대만','과자','신상요청3',1500,3, 'test3');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('한국','과자','신상요청1',1500,1, 'test1');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('일본','과자','신상요청2',1500,2, 'test2');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('대만','과자','신상요청3',1500,3, 'test3');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('한국','과자','신상요청1',1500,1, 'test1');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('일본','과자','신상요청2',1500,2, 'test2');
INSERT INTO request(request_country, request_food_type, request_food,request_price,request_member_no, request_content)
VALUES('대만','과자','신상요청3',1500,3, 'test3');



INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');
INSERT INTO request_pic(request_url)
VALUES('2d1543c9-3745-4012-ac11-de703a6f8d81_dog_test.jpg');


INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(1,'ko', '리뷰 예시01','김말이','2023-06-01',4.0,1,1,'가성비갑',1000.0,'link', 10);

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(2, 'ko', '리뷰 예시02','쌍쌍바','2023-06-10',2.0,2,1,'개별포장',2000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(3,'ko','리뷰 예시03','프레첼','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(4,'ko','리뷰 예시01','김말이','2023-06-01',4.0,1,1,'가성비갑',1000.0,'link', 10);

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(5,'ko','리뷰 예시02','쌍쌍바', '2023-06-10',2.0,2,1,'개별포장',2000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(6,'ko','리뷰 예시03','프레첼', '2023-06-20',5.0,2,2,'선물추천',1000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(7,'ko','리뷰 예시01','김말이','2023-06-01',4.0,1,1,'가성비갑',1000.0,'link', 10);


INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(8,'ko','리뷰 예시02','오레오','2023-06-10',2.0,2,1,'개별포장',2000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(9,'ko','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');


INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(10,'ko','리뷰 예시01','오레오','2023-06-01',4.0,1,1,'가성비갑',1000.0,'link', 10);


INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(11,'ko','리뷰 예시02','오레오','2023-06-10',2.0,2,1,'개별포장',2000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(12,'ko','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link',20);

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(13,'ko','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(14,'ko','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(15,'ko','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(16,'ko','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(17,'ko','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(18,'ko','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(19,'ko','리뷰 예시03','오레오','2023-06-20',5.0,3,3,'선물추천',1000.0,'link', 20);
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(20,'ko','리뷰 예시03','오레오','2023-06-20',4.0,3,3,'선물추천',1000.0,'link', 20);
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(21,'ko','리뷰 예시03','오레오','2023-06-20',2.0,3,3,'선물추천',1000.0,'link', 5);
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(22,'ko','리뷰 예시03','오레오','2023-06-20',3.5,3,3,'선물추천',1000.0,'link', 3);
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(23,'ko','리뷰 예시03','오레오','2023-06-20',5.0,3,3,'선물추천',1000.0,'link', 4);
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(24,'ko','리뷰 예시03','오레오','2023-06-20',5.0,3,3,'선물추천',1000.0,'link', 5);



-- INSERT INTO review_like(review_no,member_no)
-- VALUES(1,2);
-- INSERT INTO review_like(review_no,member_no)
-- VALUES(2,2);
-- INSERT INTO review_like(review_no,member_no)
-- VALUES(1,1);
-- INSERT INTO review_like(review_no,member_no)
-- VALUES(3,2);


-- INSERT INTO review_pic(review_no,review_pic_no,review_pic_url)
-- VALUES(1,1,'link');
-- INSERT INTO review_pic(review_no,review_pic_no,review_pic_url)
-- VALUES(2,2,'link');
-- INSERT INTO review_pic(review_no,review_pic_no,review_pic_url)
-- VALUES(2,3,'link');
-- INSERT INTO review_pic(review_no,review_pic_no,review_pic_url)
-- VALUES(2,4,'link');


INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',20,'감동란',200,4.5,100,20,'M','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',21,'통크',255,3.8,200,10,'F','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',22,'SUI',150,5.0,120,30,'F','한국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',23,'빼빼로',188,3.02,100,20,'M','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',24,'콘칩',6,3.94,200,10,'F','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',25,'오감자',499,1.8,120,30,'F','한국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',26,'스윙칩',123,4.5,100,20,'M','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',27,'핫소스빵',321,1.0,200,10,'F','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',28,'개구리',22,4.9,120,30,'F','한국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',29,'미니언',33,2.8,100,20,'M','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',30,'물',166,1.88,200,10,'F','한국');

INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',20,'미국감동란',200,4.5,100,20,'M','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',21,'미국통크',255,3.8,200,10,'F','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',22,'미국SUI',150,5.0,120,30,'F','미국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',23,'미국빼빼로',188,3.02,100,20,'M','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',24,'미국콘칩',6,3.94,200,10,'F','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',25,'미국오감자',499,1.8,120,30,'F','미국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',26,'미국스윙칩',123,4.5,100,20,'M','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',27,'미국핫소스빵',321,1.0,200,10,'F','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',28,'미국개구리',22,4.9,120,30,'F','미국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',29,'미국미니언',33,2.8,100,20,'M','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-25',30,'미국물',166,1.88,200,10,'F','미국');

INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',20,'감동란',200,4.5,100,20,'M','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',21,'통크',255,3.8,200,10,'F','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',22,'SUI',150,5.0,120,30,'F','한국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',23,'빼빼로',188,3.02,100,20,'M','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',24,'콘칩',6,3.94,200,10,'F','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',25,'오감자',499,1.8,120,30,'F','한국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',26,'스윙칩',123,4.5,100,20,'M','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',27,'핫소스빵',321,1.0,200,10,'F','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',28,'개구리',22,4.9,120,30,'F','한국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',29,'미니언',33,2.8,100,20,'M','한국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',30,'물',166,1.88,200,10,'F','한국');

INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',20,'미국감동란',200,5.0,100,20,'M','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',21,'미국통크',255,3.8,200,10,'F','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',22,'미국SUI',150,5.0,120,30,'F','미국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',23,'미국빼빼로',188,3.02,100,20,'M','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',24,'미국콘칩',6,3.94,200,10,'F','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',25,'미국오감자',499,1.8,120,30,'F','미국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',26,'미국스윙칩',123,4.5,100,20,'M','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',27,'미국핫소스빵',321,1.0,200,10,'F','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',28,'미국개구리',22,4.9,120,30,'F','미국');
INSERT INTO stat(update_date,food_no, food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',29,'미국미니언',33,2.8,100,20,'M','미국');
INSERT INTO stat(update_date,food_no,food_name, review_cnt,food_rate,like_cnt,member_age_group, member_gender, country)
VALUES('2023-07-21',30,'미국물',166,1.88,200,10,'F','미국');