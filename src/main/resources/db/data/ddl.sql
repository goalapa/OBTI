create table app_review (
                            app_review_no integer not null auto_increment,
                            app_review_content varchar(255),
                            app_review_rate float,
                            member_nickname varchar(255),
                            member_no integer,
                            primary key (app_review_no)
);
 

create table blacklist (
                           blacklist_no integer not null auto_increment,
                           member_no integer,
                           blacklist_reg_date date,
                           blacklist_rel_date date,
                           primary key (blacklist_no)
);
 

create table category (
                          category_no integer not null auto_increment comment '상위카테고리와 하위카테고리를 포함한 고유번호',
                          country varchar(255) comment '국가명',
                          food_type varchar(255) comment '식품 종류',
                          primary key (category_no)
);
 

create table food (
                      food_no integer not null auto_increment,
                      country varchar(255),
                      food_name varchar(255),
                      food_price integer,
                      food_rate double precision,
                      food_type varchar(255),
                      primary key (food_no)
);
 

create table food_pic (
                          food_no integer not null auto_increment,
                          food_pic_url varchar(255),
                          primary key (food_no)
);
 

create table member (
                        member_no integer not null auto_increment,
                        member_birth date,
                        blacklist_type boolean default false,
                        member_country varchar(255),
                        member_email varchar(255),
                        member_gender varchar(255),
                        member_grant varchar(255),
                        member_id varchar(255),
                        member_nickname varchar(255),
                        member_pwd varchar(255),
                        member_report_cnt integer default 0,
                        primary key (member_no)
);
 

create table report (
                        report_no integer not null auto_increment,
                        report_member_no integer,
                        report_type integer,
                        reported_member_no integer,
                        review_no integer,
                        primary key (report_no)
);
 

create table request (
                         request_no integer not null auto_increment,
                         request_content varchar(255),
                         request_country varchar(255),
                         request_food varchar(255),
                         request_food_type varchar(255),
                         request_member_no integer,
                         request_price integer,
                         primary key (request_no)
);
 

create table request_pic (
                             request_no integer not null auto_increment,
                             request_url varchar(255),
                             primary key (request_no)
);
 

create table review (
                        review_no integer not null auto_increment,
                        country varchar(255),
                        food_name varchar(255),
                        food_no integer,
                        food_type varchar(255),
                        like_cnt integer,
                        report_cnt integer,
                        review_content varchar(255) comment '리뷰 내용',
                        review_date date,
                        review_keyword varchar(255),
                        review_link varchar(255),
                        review_price integer,
                        review_rate double precision,
                        member_no integer,
                        primary key (review_no)
);
 

create table review_like (
                             like_no integer not null auto_increment,
                             member_no integer,
                             review_no integer,
                             primary key (like_no)
);
 

create table review_pic (
                            review_pic_no integer not null auto_increment,
                            review_pic_url varchar(255),
                            review_no integer,
                            primary key (review_pic_no)
);
 

create table stat (
                      stat_no integer not null auto_increment,
                      country varchar(255),
                      food_image_url varchar(255),
                      food_name varchar(255),
                      food_no integer,
                      food_rate float,
                      like_cnt integer,
                      member_age_group integer,
                      member_gender varchar(255),
                      review_cnt integer,
                      update_date date,
                      primary key (stat_no)
);
 

alter table review_pic
    add constraint FK6wp6s32m419ed65c8trmmpiq9
        foreign key (review_no)
            references review (review_no);