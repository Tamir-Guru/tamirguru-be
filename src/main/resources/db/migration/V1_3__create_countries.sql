CREATE TABLE countries
(
    id       bigserial  not null
        constraint countries_pk
            primary key,
    code     varchar(3) not null,
    name     text,
    language varchar(3) not null
);

create index countries_language_index
    on countries (language);

create index countries_asc_index on countries (language asc, name asc);

INSERT INTO countries(code, name, language)
VALUES ('TR', 'Türkiye', 'TR');


