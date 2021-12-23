CREATE TABLE merchant_types
(
    id       bigserial  not null
        constraint merchant_types_pk
            primary key,
    name     text       not null,
    type_id  varchar(5) not null,
    language varchar(3) not null
);

create index merchant_types_language_index
    on merchant_types (language);

create index merchant_types_name_index
    on merchant_types (name asc);


insert into merchant_types(name, language, type_id)
VALUES ('Oto Tamir', 'TR', 'OTMR'),
       ('Oto Elektrik', 'TR', 'OELK'),
       ('Çekici', 'TR', 'CKC'),
       ('Lastik', 'TR', 'OLST');