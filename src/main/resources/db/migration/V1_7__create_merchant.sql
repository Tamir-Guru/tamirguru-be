CREATE TABLE merchants
(
    id             bigserial   not null
        constraint merchants_pk
            primary key,
    name           text        not null,
    user_id        bigint      not null,
    phone_number   varchar(11) not null,
    merchant_types text[]      not null,
    address        text        not null,
    details        text        not null,
    photo          text,
    district_id    bigint      not null,
    longitude      decimal     not null,
    latitude       decimal     not null
);

create index merchants_merchant_types_index
    on merchants (merchant_types);

create index merchants_district_id_index
    on merchants (district_id);