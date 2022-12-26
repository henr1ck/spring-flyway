create table position (
	id bigint auto_increment,
    name varchar(20),

    primary key (id)
);

-- insert into position (name) select distinct p.position from player p;
insert into position (name) values ('ATTACKING');
insert into position (name) values ('MIDFIELD');
insert into position (name) values ('DEFENSIVE');
insert into position (name) values ('GOALKEEPER');

alter table player add column position_id bigint not null;

update player p0 set position_id = (select p1.id from position p1 where p0.position = p1.name);

alter table player add constraint foreign key (position_id) references position (id);

alter table player drop column position;
