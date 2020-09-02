begin
    execute immediate ('drop table ACCOUNT');
    DBMS_OUTPUT.PUT('table ACCOUNT dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('ACCOUNT table is not exist');
end;
/
begin
    execute immediate ('drop sequence ACCOUNT_SEQUENCE ');
    DBMS_OUTPUT.PUT_LINE('sequence ACCOUNT_SEQUENCE dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('ACCOUNT_SEQUENCE is not exist');
end;
/
create TABLE ACCOUNT
(
    /*id number(19) not null  unique ,*/ --error  and when  constriant for primaryKey is not set
    --sequence is not set
    id number(19)  ,
    email varchar2(100) not null ,
    password varchar2(10) not null  unique ,
    first_name varchar2(50)  ,
    last_name varchar2(50) ,
    national_code varchar2(10)  unique ,
    phone varchar2(11)  ,
    age number(3) ,
    address varchar2(255) ,
    constraint account_pk_id primary key (id)

);

create SEQUENCE ACCOUNT_SEQUENCE
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;

--flight
begin
    execute immediate ('drop table FLIGHT');
    DBMS_OUTPUT.PUT_LINE('table FLIGHT dropped');
exception
    when OTHERS THEN DBMS_OUTPUT.PUT_LINE('FLIGHT table is not exist');
end;
/
BEGIN
    EXECUTE IMMEDIATE ('DROP SEQUENCE FLIGHT_SEQUENCE');
    DBMS_OUTPUT.PUT_LINE('sequnce FLIGHT_SEQUENCE dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('FLIGHT_SEQUENCE is not exist');
end;
/
create table FLIGHT
(
    /* id number(19) not null unique ,*/ /*id number(19) not null  unique ,*/ --error  and when  constriant for primaryKey is not set
    --sequence is not set
    id number(19),
    name varchar2(100) not null ,
    company varchar2(100) not null ,
    origin varchar2(100) not null ,
    destination varchar2(100) not null ,
    flight_date timestamp(7) not null ,
    arival_date timestamp(7) not null ,
    airplane_seat_number number(10) not null ,
    fee number(15,4) not null ,
    description varchar2(255),
    constraint flight_pk_id primary key (id)
);
create sequence FLIGHT_SEQUENCE
    MINVALUE 10000 MAXVALUE 9999999999999999999 CYCLE
    Start With 10000 increment by 1000 cache 1000;
--airplane_set
begin
    execute immediate ('drop table AIRPLANE_SEAT');
    DBMS_OUTPUT.PUT('table AIRPLANE_SEAT dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('AIRPLANE_SEAT table is not exist');
end;
/
begin
    execute immediate ('drop sequence AIRPLANE_SEAT_SEQUENCE ');
    DBMS_OUTPUT.PUT_LINE('sequence AIRPLANE_SEAT_SEQUENCE dropped');
exception
    when others THEN DBMS_OUTPUT.PUT_LINE('AIRPLANE_SEAT_SEQUENCE is not exist');
end;
/
create TABLE AIRPLANE_SEAT
(
    /*id number(19) not null  unique ,*/ --error  and when  constriant for primaryKey is not set
    --sequence is not set
    id number(19)  ,
    flight number(19) not null ,
    seat_number number(19) not null ,
    status varchar2(1) not null ,--0=free & 1=busy
    constraint AIRPLANE_SEAT_pk_id primary key (id),
    constraint AIRPLANE_SEAT_fk_flight_id foreign key (flight) references FLIGHT(id)

);

create SEQUENCE AIRPLANE_SEAT_SEQUENCE
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;

--cart
begin
    execute immediate ('drop table CART');
    DBMS_OUTPUT.PUT_LINE('table CART dropped');
exception
    when OTHERS THEN DBMS_OUTPUT.PUT_LINE('CART table is not exist');
end;
/
BEGIN
    EXECUTE IMMEDIATE ('DROP SEQUENCE CART_SEQUENCE');
    DBMS_OUTPUT.PUT_LINE('sequnce CART_SEQUENCE dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('CART_SEQUENCE is not exist');
end;
/
create table CART
(
    /* id number(19) not null unique ,*/ /*id number(19) not null  unique ,*/ --error  and when  constriant for primaryKey is not set
    --sequence is not set
    id number(19),
    date_create timestamp(7) not null ,
    status varchar2(2) ,
    flight number(19) not null ,
    account number(19) not null,
    airplane_seat number(19) not null ,
    constraint cart_pk_id primary key (id),
    constraint cart_fk_flight_id foreign key (flight) references FLIGHT(id),
    constraint cart_fk_airplane_seat_id foreign key (airplane_seat) references AIRPLANE_SEAT(id),
    constraint cart_fk_account_id foreign key (account) references ACCOUNT(id)
);
create sequence CART_SEQUENCE
    MINVALUE 10000 MAXVALUE 9999999999999999999 CYCLE
    Start With 10000 increment by 1000 cache 1000;