begin
    execute immediate 'drop table p';
    DBMS_OUTPUT.PUT_LINE('Table p dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Table p did not exist');
end ;
begin
    execute immediate 'drop sequence p_seq';
    DBMS_OUTPUT.PUT_LINE('Sequence p_seq dropped');
exception
    when others then DBMS_OUTPUT.PUT_LINE('Sequence p_seq did not exist');
end;

create table p
(
    id         number(19) not null,
    person_id  number(19) not null,
    account_id number(19) not null,
    constraint p_pk_id primary key (id),
    constraint p_fk_account_id foreign key (account_id) references account (id),
    constraint p_fk_person_id foreign key (person_id) references person (id)
);

create sequence p_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;

