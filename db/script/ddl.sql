-- 회원
create table member (
                        member_id bigint not null AUTO_INCREMENT,
                        email varchar(255),
                        member_name varchar(255),
                        password varchar(255),
                        reg_date timestamp,
                        primary key (member_id)
);

-- 책
create table book (
                      book_id bigint not null AUTO_INCREMENT,
                      book_author varchar(255),
                      book_name varchar(255),
                      book_price integer not null,
                      book_stock_quantity integer not null,
                      reg_date timestamp,
                      primary key (book_id)
);

-- 주문
create table orders (
                        order_id bigint not null AUTO_INCREMENT,
                        member_id varchar(255),
                        order_date timestamp,
                        order_status CHARACTER VARYING(255),
                        primary key (order_id)
);

-- 주문_책_매핑
create table order_book_mapping (
                                    order_book_id bigint not null AUTO_INCREMENT,
                                    order_id varchar(255),
                                    book_id varchar(255),
                                    order_price integer not null,
                                    order_count integer not null,
                                    reg_date timestamp,
                                    primary key (order_book_id)
);




