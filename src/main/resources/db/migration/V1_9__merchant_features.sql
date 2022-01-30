CREATE TABLE merchant_features
(
    id          bigserial   not null
        constraint merchant_features_pk
            primary key,
    type        varchar(25) not null,
    merchant_id bigint      not null,
    type_id     varchar(5)  not null,
    values      bigint[]    not null
);


create index merchant_features_type_index
    on merchant_features (type);

create index merchant_features_merchant_id_index
    on merchant_features (merchant_id);

create unique index merchant_type_id_uindex
    on merchant_features (merchant_id, type_id);