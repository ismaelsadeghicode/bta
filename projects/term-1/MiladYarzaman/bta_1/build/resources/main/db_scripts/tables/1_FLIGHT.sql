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