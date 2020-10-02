begin
    execute immediate 'drop table information';
    DBMS_OUTPUT.PUT_LINE('Table information dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table information did not exist');
end ;
begin
    execute immediate 'drop sequence information_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence information_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence information_seq did not exist');
end;

create table information
(
    id            number(19)  not null,
    first_name    varchar(50) not null,
    last_name     varchar(50) not null,
    national_code varchar(10) not null,
    phone         varchar(11) not null,
    age           number(3)   not null,
    address       varchar(255),
    account_id    number(19)  not null,
    constraint information_pk_id primary key (id),
    constraint inf_unique_national_code unique (national_code),
    constraint information_un_check_age check (age between 0 and 120)
    -- age(0-120)
    ,
    constraint information_fk_account_id foreign key (account_id) references account (id)
);
create sequence information_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;
