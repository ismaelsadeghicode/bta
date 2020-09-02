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