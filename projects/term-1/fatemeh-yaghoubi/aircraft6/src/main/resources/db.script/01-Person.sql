begin

    execute immediate 'drop table Person';

    dbms_output.put_line('Table Person dropped');

exception

    when others then dbms_output.put_line('Table Person did not exist');

end;

/

begin

    execute immediate 'drop sequence Person_seq';

    dbms_output.put_line('Sequence Person_seq dropped');

exception

    when others then dbms_output.put_line('Sequence Person_seq did not exist');

end;

/



create table Person

(

    id            number(19) not null,

    age           varchar(1) not null,

    first_name    varchar(50),

    last_name     varchar(50),

    National_code varchar(10),
    phone         varchar(50),

    constraint Person_pk_id primary key (id)

);



create sequence Person_seq
    minvalue 10000 maxvalue 9999999999999999999 cycle
    start with 10000 increment by 1000 cache 1000;

/