
create table Model(
id serial primary key,
name varchar(50) not null
);

create table Company(
id serial primary key,
name varchar(50) not null
);

create table FUEL_TYPE(
id serial primary key,
name varchar(50) not null
);

create table car(
	id serial primary key,
	company int not null,
	model numeric(4, 0) not null, --year
	seater smallint not null,
	fuel_type int not null,
	type int not null,
	price numeric(8, 2) not null,
	sold boolean not null,

	foreign key(type) references Model(id),
	foreign key(company) references Company(id),
	foreign key(fuel_type) references FUEL_TYPE(id)
);

