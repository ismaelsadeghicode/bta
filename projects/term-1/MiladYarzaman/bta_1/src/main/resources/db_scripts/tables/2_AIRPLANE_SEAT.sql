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
    flight number(19) ,
    seat_number number(19) not null ,
    status varchar2(1) not null ,--0=free & 1=busy
    constraint AIRPLANE_SEAT_pk_id primary key (id),
        constraint AIRPLANE_SEAT_fk_flight_id foreign key (flight) references FLIGHT(id)

);

create SEQUENCE AIRPLANE_SEAT_SEQUENCE
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;
