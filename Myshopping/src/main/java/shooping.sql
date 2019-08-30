--�û���
create table users(
id number primary key ,--�û�id
name varchar2(50) not null,--�û�����
pwd varchar2(50) not null ,--�û�����
email varchar2(100) not null ,--����
tel varchar(20) not null ,--�绰
grade number(2) default 1 not null --�ȼ� 

);
--�û�����
create sequence seq_user
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20; 

--��������
insert into users values
(seq_user.nextval,'aa','202cb962ac59075b964b07152d234b70','416926039@qq.com','18049790340',1);


--��Ʒ��
create table book(
id number primary key ,--��ı��
name varchar2(50) not null,--�������
autor varchar2(100)  not null,--�������
publish_Housr varchar2(100) not null ,--������
price number not null ,--�۸�
nums number default 1000 not null, --���
photo varchar2(200),--ͼƬ·��
info varchar2(300),--����
amount number  default 0  --����
);
--��Ʒ����
create sequence seq_book
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20; 

--������Ʒ����
insert into  book values
(seq_book.nextval,'java core','fujt','���ӹ�ҵ������',99,1000,'01.jpg','����java��',1);
insert into  book values
(seq_book.nextval,'c++ ','fujt','���ӹ�ҵ������',79,1000,'02.jpg','����c++��',1);
insert into  book values
(seq_book.nextval,'php','fujt','���ӹ�ҵ������',69,1000,'03.jpg','����php��',1);

--������
create table orders(
id number primary key,--�����ı��
user_Id number references users(id),--�¶������û����
tatal_Price number default 0 not null,--�ö������ܼ۸�
order_Date date  default  sysdate  not null--�¶�����ʱ��
);






--����������
create sequence seq_orders
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20; 

--����ϸ�ڱ��ö�����������ʲô��Ʒ��
create table order_item(
id number primary key ,--���
order_Id number references orders(id),--�����ָ��orders���id
book_Id number references book(id),--���
book_Num number default 0 not null--��Ʒ����
);
--������ϸ������
create sequence seq_orderItem
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20; 











