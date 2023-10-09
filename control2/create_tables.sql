create table if not exists "user" (
	id serial primary key,
	username varchar(50) not null unique,
	password varchar(50) not null
);

create table if not exists task (
	id serial primary key,
	title varchar(50) not null,
	description varchar(50) not null,
	expire_date date not null,
	completed boolean default false,
	id_user int,
	constraint fk_user
		foreign key (id_user)
			references "user"(id)
);