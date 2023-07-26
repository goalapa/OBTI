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
VALUES(4,'칙촉','한국','과자',4.3,1800);


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
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');
INSERT INTO request_pic(request_url)
VALUES('link');


INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(1,'한국', '보통 초코와 커피의 맛의 조화는 한가지 맛이 지배적이고 나머지 한 맛이 향 추임새를 넣어주어야하는데, 이 초콜릿은 두 맛이 모두 난잡하게 싸우는 느낌. 거기에 카푸치노의 향이 너무 인공적이다.','김말이','2023-06-01',4.0,1,1,'가성비갑',1000.0,'link', 10);

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(2, '한국', '보통 초코와 커피의 맛의 조화는 한가지 맛이 지배적이고 나머지 한 맛이 향 추임새를 넣어주어야하는데, 이 초콜릿은 두 맛이 모두 난잡하게 싸우는 느낌. 거기에 카푸치노의 향이 너무 인공적이다.','쌍쌍바','2023-06-10',2.0,2,1,'개별포장',2000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(3,'한국','보통 초코와 커피의 맛의 조화는 한가지 맛이 지배적이고 나머지 한 맛이 향 추임새를 넣어주어야하는데, 이 초콜릿은 두 맛이 모두 난잡하게 싸우는 느낌. 거기에 카푸치노의 향이 너무 인공적이다.','프레첼','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(4,'한국','보통 초코와 커피의 맛의 조화는 한가지 맛이 지배적이고 나머지 한 맛이 향 추임새를 넣어주어야하는데, 이 초콜릿은 두 맛이 모두 난잡하게 싸우는 느낌. 거기에 카푸치노의 향이 너무 인공적이다.','김말이','2023-06-01',4.0,1,1,'가성비갑',1000.0,'link', 10);

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(5,'한국','기분좋은 진함에 바나나킥향이 적당히 첨가되어있다. 바나나킥 먹고 나면 봉지에 남은 가루를 타먹는 맛. 조화가 전혀 어색하지 않다.','쌍쌍바', '2023-06-10',2.0,2,1,'개별포장',2000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(6,'한국','기분좋은 진함에 바나나킥향이 적당히 첨가되어있다. 바나나킥 먹고 나면 봉지에 남은 가루를 타먹는 맛. 조화가 전혀 어색하지 않다.','프레첼', '2023-06-20',5.0,2,2,'선물추천',1000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(7,'한국','리뷰 예시01','김말이','2023-06-01',4.0,1,1,'가성비갑',1000.0,'link', 10);


INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(8,'한국','기분좋은 진함에 바나나킥향이 적당히 첨가되어있다. 바나나킥 먹고 나면 봉지에 남은 가루를 타먹는 맛. 조화가 전혀 어색하지 않다.','오레오','2023-06-10',2.0,2,1,'개별포장',2000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(9,'한국','기분좋은 진함에 바나나킥향이 적당히 첨가되어있다. 바나나킥 먹고 나면 봉지에 남은 가루를 타먹는 맛. 조화가 전혀 어색하지 않다.','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');


INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link,like_cnt)
VALUES(10,'한국','기분좋은 진함에 바나나킥향이 적당히 첨가되어있다. 바나나킥 먹고 나면 봉지에 남은 가루를 타먹는 맛. 조화가 전혀 어색하지 않다.','오레오','2023-06-01',4.0,1,1,'가성비갑',1000.0,'link', 10);


INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(11,'한국','미국에서 상당히 인기있는 리세스 초콜릿을 M&M 스타일로 줄인 버젼. 오리지널 리세스는 꽤 큰편인데, 저 작은 한알에도 그 맛이 전부 표현된다는게 신기하다. 내가 원래 리세스를 그리 좋아하지는 않았지만, 저렇게 작게작게 먹으니 뭔가 더 맛있었다.','오레오','2023-06-10',2.0,2,1,'개별포장',2000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(12,'한국','미국에서 상당히 인기있는 리세스 초콜릿을 M&M 스타일로 줄인 버젼. 오리지널 리세스는 꽤 큰편인데, 저 작은 한알에도 그 맛이 전부 표현된다는게 신기하다. 내가 원래 리세스를 그리 좋아하지는 않았지만, 저렇게 작게작게 먹으니 뭔가 더 맛있었다.','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');

INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(13,'한국','미국에서 상당히 인기있는 리세스 초콜릿을 M&M 스타일로 줄인 버젼. 오리지널 리세스는 꽤 큰편인데, 저 작은 한알에도 그 맛이 전부 표현된다는게 신기하다. 내가 원래 리세스를 그리 좋아하지는 않았지만, 저렇게 작게작게 먹으니 뭔가 더 맛있었다.','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(14,'한국','미국에서 상당히 인기있는 리세스 초콜릿을 M&M 스타일로 줄인 버젼. 오리지널 리세스는 꽤 큰편인데, 저 작은 한알에도 그 맛이 전부 표현된다는게 신기하다. 내가 원래 리세스를 그리 좋아하지는 않았지만, 저렇게 작게작게 먹으니 뭔가 더 맛있었다.','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(15,'한국','미국에서 상당히 인기있는 리세스 초콜릿을 M&M 스타일로 줄인 버젼. 오리지널 리세스는 꽤 큰편인데, 저 작은 한알에도 그 맛이 전부 표현된다는게 신기하다. 내가 원래 리세스를 그리 좋아하지는 않았지만, 저렇게 작게작게 먹으니 뭔가 더 맛있었다.','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(16,'한국','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(17,'한국','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');
INSERT INTO review(review_no, country, review_content,food_name,review_date,review_rate,member_no,food_no,review_keyword,review_price,review_link)
VALUES(18,'한국','리뷰 예시03','오레오','2023-06-20',5.0,2,2,'선물추천',1000.0,'link');



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


INSERT INTO stat(update_date,food_no, review_cnt,food_rate,like_cnt,member_age_group, member_gender)
VALUES('2023-06-01',20,200,4.5,100,20,'M');
INSERT INTO stat(update_date,food_no, review_cnt,food_rate,like_cnt,member_age_group, member_gender)
VALUES('2023-06-01',21,255,3.8,200,10,'F');
INSERT INTO stat(update_date,food_no, review_cnt,food_rate,like_cnt,member_age_group, member_gender)
VALUES('2023-06-01',22,150,5.0,120,30,'F');