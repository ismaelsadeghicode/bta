begin
    execute immediate 'drop table cart';
    DBMS_OUTPUT.PUT_LINE('Table cart dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table cart did not exist');
end ;
begin
    execute immediate 'drop sequence cart_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence cart_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence cart_seq did not exist');
end;

create table cart
(
    id          number(19)     not null,
    total_price decimal(15, 4) not null,
    date_create timestamp      not null,
    status      varchar(1)     not null,
    quantity    number(3)      not null,
    flight_id   number(19)     not null,
    account_id  number(19)     not null,
    constraint cart_pk_id primary key (id),
    constraint cart_un_check_status check (status in ('e', 'd'))
    --account status (enable(e) , disable(d))
    ,
    constraint cart_fk_account_id foreign key (account_id) references account (id),
    constraint cart_fk_flight_id foreign key (flight_id) references flight (id)
);
create sequence cart_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;
