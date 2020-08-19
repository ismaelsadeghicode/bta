begin
    execute immediate 'drop table account';
    DBMS_OUTPUT.PUT_LINE('Table account dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table account did not exist');
end ;
begin
    execute immediate 'drop sequence account_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence account_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence account_seq did not exist');
end;

create table account
(
    id       number(19)   not null,
    username varchar(50)  not null,
    email    varchar(100) not null,
    password varchar(50)  not null,
    active   varchar (1)    not null,
    constraint account_pk_id primary key (id),
    constraint account_unique_email unique (email),
    constraint account_un_check_active check (active in ('e','d'))
    --account status (enable(e) , disable(d))
);
create sequence account_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;
