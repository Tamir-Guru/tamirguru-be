create table users
(
    id        bigserial    not null
        constraint users_pk
            primary key,
    name      varchar(100) not null,
    surname   varchar(50)  not null,
    tckn      varchar(11),
    birthdate date,
    email     varchar(255) not null,
    password  text         not null,
    role      varchar(10)  not null,
    verified  bool         not null
);

create
    unique index users_email_uindex
    on users (email);

create
    unique index users_tckn_uindex
    on users (tckn);

