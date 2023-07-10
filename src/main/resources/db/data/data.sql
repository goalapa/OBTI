INSERT INTO blacklist(blacklist_no,blacklist_reg_date,blacklist_rel_date,member_no)
VALUES(1,'2023-05-15','2023-06-30',1);
INSERT INTO blacklist(blacklist_no,blacklist_reg_date,blacklist_rel_date,member_no)
VALUES(2,'2023-07-25','2023-08-20',2);


INSERT INTO category(category_name)
VALUES('과자');
INSERT INTO category(category_name)
VALUES('빵');
INSERT INTO category(category_name)
VALUES('음료');


INSERT INTO food(food_no,food_name,category_no,food_rate,food_price)
VALUES(1,'오레오',1,4.7,2000);
INSERT INTO food(food_no,food_name,category_no,food_rate,food_price)
VALUES(2,'초코롤',2,5.0,3000);
INSERT INTO food(food_no,food_name,category_no,food_rate,food_price)
VALUES(3,'초록매실',3,4.3,1800);


INSERT INTO food_pic(food_no,food_pic_url)
VALUES(1,'link');
INSERT INTO food_pic(food_no,food_pic_url)
VALUES(2,'link');
INSERT INTO food_pic(food_no,food_pic_url)
VALUES(3,'link');


INSERT INTO member(member_no,member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth)
VALUES(1,'abc000','pwd000','초코맛있다','dkem@gmail.com',20,0,'2001-08-04');
INSERT INTO member(member_no,member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth)
VALUES(2,'abc111','pwd111','오늘은뭐먹지','zmzlsk@gmail.com',30,20,'1990-01-20');
INSERT INTO member(member_no,member_id,member_pwd,member_nickname,member_email,member_grant,member_report_cnt,member_birth)
VALUES(3,'abc222','pwd222','돼징','ehowld@gmail.com',10,10,'2008-11-30');



INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(1,1,2,3,1);
INSERT INTO report(report_no,review_no,report_member_no,reported_member_no,report_type)
VALUES(2,3,3,2,1);


INSERT INTO request(country, food_type, request_food,request_price,member_no)
VALUES('한국','과자','신상요청1',1500,1);
INSERT INTO request(country, food_type, request_food,request_price,member_no)
VALUES('일본','과자','신상요청2',1500,2);
INSERT INTO request(country, food_type, request_food,request_price,member_no)
VALUES('대만','과자','신상요청3',1500,3);



INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');


INSERT INTO review(review_no,review_content,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(1,'리뷰 예시01','2023-06-01',4.5,1,1,'가성비갑',1000.0,'link');

INSERT INTO review(review_no,review_content,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(2,'리뷰 예시02','2023-06-10',2.0,2,1,'개별포장',2000.0,'link');

INSERT INTO review(review_no,review_content,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(3,'리뷰 예시03','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');


INSERT INTO review_like(review_no,member_no)
VALUES(1,2);
INSERT INTO review_like(review_no,member_no)
VALUES(2,2);
INSERT INTO review_like(review_no,member_no)
VALUES(1,1);
INSERT INTO review_like(review_no,member_no)
VALUES(3,2);


INSERT INTO review_pic(review_no,review_pic_no,review_pic_url)
VALUES(1,1,'link');
INSERT INTO review_pic(review_no,review_pic_no,review_pic_url)
VALUES(2,2,'link');
INSERT INTO review_pic(review_no,review_pic_no,review_pic_url)
VALUES(2,3,'link');
INSERT INTO review_pic(review_no,review_pic_no,review_pic_url)
VALUES(2,4,'link');


INSERT INTO stat(update_date,review_cnt,food_rate,like_cnt,report_type,member_age_group)
VALUES('2023-06-01',20,3.5,100,1,1);
INSERT INTO stat(update_date,review_cnt,food_rate,like_cnt,report_type,member_age_group)
VALUES('2023-06-02',20,4.5,150,1,1);
INSERT INTO stat(update_date,review_cnt,food_rate,like_cnt,report_type,member_age_group)
VALUES('2023-06-03',20,2.5,200,1,1);