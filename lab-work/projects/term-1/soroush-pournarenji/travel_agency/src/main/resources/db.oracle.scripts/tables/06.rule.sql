begin
    execute immediate 'drop table rule';
    DBMS_OUTPUT.PUT_LINE('Table rule dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table rule did not exist');
end ;
begin
    execute immediate 'drop sequence rule_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence rule_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence rule_seq did not exist');
end;

create table p
(
    id         number(19) not null,
    rule       varchar(1) not null,
    account_id number(19) not null,
    constraint rule_pk_id primary key (id),
    constraint rule_fk_account_id foreign key (account_id) references account (id),
    constraint rule_un_check_rule check (rule in ('a', 'u'))
    --account status (admin(a) , user(u)
);

create sequence rule_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;

