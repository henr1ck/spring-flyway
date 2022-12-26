create table statistics (
	id bigint auto_increment,
    goals int not null,
    assists int not null,
    matches int not null,

    primary key (id)
);

insert into statistics (goals, assists, matches) select p.goals, p.assists, p.matches from player p;

alter table player add column statistics_id bigint not null;

update player p set statistics_id =
    (select s.id from statistics s where p.goals = s.goals and p.assists = s.assists and p.matches = s.matches);

alter table player add constraint foreign key (statistics_id) references statistics (id);

alter table player drop column goals;
alter table player drop column assists;
alter table player drop column matches;
