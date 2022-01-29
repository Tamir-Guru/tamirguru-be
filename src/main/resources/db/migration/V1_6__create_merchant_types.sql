CREATE TABLE merchant_types
(
    id        bigserial  not null
        constraint merchant_types_pk
            primary key,
    name      text       not null,
    parent_id bigint,
    type_id   varchar(5) not null,
    language  varchar(3) not null
);

create index merchant_types_language_index
    on merchant_types (language);

create index merchant_types_name_index
    on merchant_types (name asc);

insert into merchant_types(name, language, type_id)
VALUES ('Otomobil', 'TR', 'OTMBL');

insert into merchant_types(name, language, type_id, parent_id)
VALUES ('Oto Tamir', 'TR', 'OTMR', 1),
       ('Oto Elektrik', 'TR', 'OELK', 1),
       ('Çekici', 'TR', 'CKC', 1),
       ('Lastik', 'TR', 'OLST', 1);

