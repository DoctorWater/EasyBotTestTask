create table easybot.public.hard_drive (
    left_number integer,
    memory_size integer,
    price float(24),
    id bigint not null,
    manufacturer varchar(255),
    primary key (id));

create table easybot.public.laptop (
    left_number integer,
    price float(24),
    id bigint not null,
    manufacturer varchar(255),
    size varchar(255) check (size in ('THIRTEEN_INCHES','FOURTEEN_INCHES','FIFTEEN_INCHES','SEVENTEEN_INCHES')),
    primary key (id));

create table easybot.public.monitor (
    diagonal float(24),
    left_number integer,
    price float(24),
    id bigint not null,
    manufacturer varchar(255),
    primary key (id));

create table easybot.public.personal_computer (
    left_number integer,
    price float(24),
    id bigint not null,
    form_factor varchar(255) check (form_factor in ('DESKTOP','NETTOP','MONOBLOCK')),
    manufacturer varchar(255),
    primary key (id))