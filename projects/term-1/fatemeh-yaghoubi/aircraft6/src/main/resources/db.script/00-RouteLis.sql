begin

    execute immediate 'drop table RouteList';

    dbms_output.put_line('Table RouteList dropped');

exception

    when others then dbms_output.put_line('Table RouteList did not exist');

end;

/

begin

    execute immediate 'drop sequence RouteList_seq';

    dbms_output.put_line('Sequence RouteList_seq dropped');

exception

    when others then dbms_output.put_line('Sequence RouteList_seq did not exist');

end;

/



create table RouteList

(

    id              number(19)    not null,

    Origin         nvarchar2(50) not null,

    Destination         varchar(50),

    movingTime   varchar(50),

    returningTime varchar(50),

    constraint RouteList_pk_id primary key (id)

);



create sequence RouteList_seq

    minvalue 10000 maxvalue 9999999999999999999 cycle

    start with 10000 increment by 1000 cache 1000;

/