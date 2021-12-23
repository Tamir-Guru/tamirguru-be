CREATE TABLE merchants
(
    id            bigserial   not null
        constraint merchants_pk
            primary key,
    name          text        not null,
    phone_number  varchar(11) not null,
    merchant_type varchar(5)  not null,
    address       text        not null,
    district_id   bigint      not null,
    longitude     decimal     not null,
    latitude      decimal     not null
);

create index merchants_merchant_types_index
    on merchants (merchant_type);

create index merchants_district_id_index
    on merchants (district_id);