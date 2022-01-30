CREATE TABLE features
(
    name         varchar(20) not null
        constraint features_pk
            primary key,
    category_ids text[]      not null,
    cache_name   varchar     not null,
    location     text        not null
);

CREATE INDEX idx_categories ON features USING GIN (category_ids);

insert into features
values ('CAR_BRAND', ARRAY ['OTMR', 'OELK'], 'carBrands', 'car.brand.')