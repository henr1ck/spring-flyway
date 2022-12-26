create table team (
	id bigint auto_increment,
    name varchar(60) not null,

    primary key (id)
);

create table player (
	id bigint auto_increment,
    name varchar(60) not null,
    position varchar(12) not null,
    birth_date date not null,
    goals int,
    assists int,
    matches int,
    team_id bigint,

    foreign key (team_id) references team (id),
    primary key (id)
);

create table organization (
	id bigint auto_increment,
    name varchar(60) not null,

    primary key (id)
);

create table tournament (
	id bigint auto_increment,
    name varchar(60) not null,
    organization_id bigint,

    foreign key (organization_id) references organization (id),
    primary key (id)
);

create table team_tournament (
	team_id bigint,
    tournament_id bigint,

    foreign key (team_id) references team (id),
    foreign key (tournament_id) references tournament (id)
);
