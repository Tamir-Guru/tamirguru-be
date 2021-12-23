CREATE TABLE countries
(
    id         bigserial  not null
        constraint countries_pk
            primary key,
    code       varchar(3) not null,
    name       text       not null,
    phone_code varchar(4) not null
);

create index countries_asc_index on countries (name asc);

INSERT INTO countries(code, name, phone_code)
VALUES ('TR', 'Türkiye', '+90'),
       ('USA', 'Amerika Birleşik Devletleri', '+1');


