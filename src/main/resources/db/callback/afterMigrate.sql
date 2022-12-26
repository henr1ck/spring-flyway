delete from player;
delete from statistics;
delete from team_tournament;
delete from team;
delete from tournament;
delete from organization;

alter table player auto_increment = 0;
alter table statistics auto_increment = 0;
alter table team auto_increment = 0;
alter table tournament auto_increment = 0;
alter table organization auto_increment = 0;

insert into organization (name) values ("UEFA");
insert into tournament (name, organization_id) values ("CHAMPIONS LEAGUE", 1);

insert into team (name) values ('BAYERN MÜNCHEN');
insert into team (name) values ('LIVERPOOL');
insert into team (name) values ('PARIS SAINT GERMAIN');
insert into team (name) values ('REAL MADRID');

insert into team_tournament (team_id, tournament_id) values (1,1), (2,1), (3,1), (4,1);

insert into statistics (goals, assists, matches) values (1,0,5);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('DAYOT UPAMECANO', 3, '1998-10-27', 1,(select last_insert_id()));

insert into statistics (goals, assists, matches) values (0,0,6);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('ALISSON BECKER', 4, '1991-07-08', 2, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (5,4,6);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('LIONEL MESSI', 1, '1987-06-24', 3, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (3,2,6);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('LUKA MODRIĆ', 2, '1985-09-09', 4, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (1,1,5);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('JOSHUA KIMMICH', 2, '1995-02-08', 1, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (0,1,4);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('DARWIN NÚÑEZ', 1, '1999-06-24', 2, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (1,0,6);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('ACHRAF HAKIMI', 3, '1998-11-04', 3, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (0,0,6);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('THIBAUT COURTOIS ', 4, '1992-05-11', 4, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (6,1,6);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('SADIO MANÉ', 1, '1992-04-10', 1, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (0,2,4);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('THIAGO ALCÂNTARA', 2, '1991-04-11', 2, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (0,0,6);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('GIANLUIGI DONNARUMMA', 4, '1999-02-25', 3, (select last_insert_id()));

insert into statistics (goals, assists, matches) values (0,2,5);
insert into player (name, position_id, birth_date, team_id, statistics_id) values ('ÉDER MILITÃO', 3, '1998-01-18', 4, (select last_insert_id()));
