begin
    execute immediate 'drop table flight';
    DBMS_OUTPUT.PUT_LINE('Table flight dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table flight did not exist');
end;
begin
    execute immediate 'drop sequence flight_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence flight_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence flight_seq did not exist');
end;

create table flight
(
    id           number(19)     not null,
    name         varchar(50),
    company      varchar(50),
    origin       varchar(50)    not null,
    destination  varchar(50)    not null,
    flight_date  timestamp      not null,
    arrival_date timestamp      not null,
    quantity     number(3)      not null,
    fee          decimal(15, 4) not null,
    description  varchar(255),
    constraint flight_pk_id primary key (id),
    constraint flight_un_check_date_great
        check (arrival_date > flight_date)
--     arrival_date > flight_date
);

create sequence flight_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;