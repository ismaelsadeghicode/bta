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
