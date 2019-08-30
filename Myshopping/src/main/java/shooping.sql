--用户表
create table users(
id number primary key ,--用户id
name varchar2(50) not null,--用户姓名
pwd varchar2(50) not null ,--用户密码
email varchar2(100) not null ,--邮箱
tel varchar(20) not null ,--电话
grade number(2) default 1 not null --等级 

);
--用户序列
create sequence seq_user
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20; 

--插入数据
insert into users values
(seq_user.nextval,'aa','202cb962ac59075b964b07152d234b70','416926039@qq.com','18049790340',1);


--商品表
create table book(
id number primary key ,--书的编号
name varchar2(50) not null,--书的名字
autor varchar2(100)  not null,--书的作者
publish_Housr varchar2(100) not null ,--出版社
price number not null ,--价格
nums number default 1000 not null, --库存
photo varchar2(200),--图片路径
info varchar2(300),--描述
amount number  default 0  --数量
);
--商品序列
create sequence seq_book
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20; 

--插入商品数据
insert into  book values
(seq_book.nextval,'java core','fujt','电子工业出版社',99,1000,'01.jpg','这是java书',1);
insert into  book values
(seq_book.nextval,'c++ ','fujt','电子工业出版社',79,1000,'02.jpg','这是c++书',1);
insert into  book values
(seq_book.nextval,'php','fujt','电子工业出版社',69,1000,'03.jpg','这是php书',1);

--订单表
create table orders(
id number primary key,--订单的编号
user_Id number references users(id),--下订单的用户编号
tatal_Price number default 0 not null,--该订单的总价格
order_Date date  default  sysdate  not null--下订单的时间
);






--订单表序列
create sequence seq_orders
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20; 

--订单细节表（该订单究竟买了什么商品）
create table order_item(
id number primary key ,--编号
order_Id number references orders(id),--外键，指向orders表的id
book_Id number references book(id),--书号
book_Num number default 0 not null--商品数量
);
--订单详细表序列
create sequence seq_orderItem
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20; 











