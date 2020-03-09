drop table if exists company;

create table company (
  id bigint(20) auto_increment primary key,
  name varchar(250) not null,

  PRIMARY KEY (id)
);

insert into company (name) values
  ('Berkshire Hathaway Homestate Companies');