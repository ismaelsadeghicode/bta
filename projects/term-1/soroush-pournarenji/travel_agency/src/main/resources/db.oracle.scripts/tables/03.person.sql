begin
    execute immediate 'drop table person';
    DBMS_OUTPUT.PUT_LINE('Table person dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table person did not exist');
end ;
begin
    execute immediate 'drop sequence person_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence person_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence person_seq did not exist');
end;

create table person
(
    id            number(19)  not null,
    first_name    varchar(50) not null,
    last_name     varchar(50) not null,
    national_code varchar(10) not null,
    phone         varchar(11) not null,
    age           varchar(1)  not null,
    account_id    number(19)  not null,
    constraint person_pk_id primary key (id),
    constraint person_unique_national_code unique (national_code),
    constraint person_un_check_age check (age in ('b', 'c', 'a'))
    --account status (baby(0-2) , Child(2-12),adult(12-120)
    ,
    constraint person_fk_account_id foreign key (account_id) references account (id)
);

create sequence person_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;
