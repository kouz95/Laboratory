create table if not exists MY_AGGREGATE
(
  id bigint auto_increment not null,
  name varchar(255) not null,
  primary key (id)
);

create table if not exists REF_AGGREGATE
(
    id bigint auto_increment not null,
    my_aggregate_id bigint not null,
    primary key (id)
);