create table comments
(
    id          bigserial not null
        constraint comments_pk
            primary key,
    comment     text      not null,
    user_id     bigint    not null,
    merchant_id bigint    not null,
    date        date      not null,
    positive    bigint    not null default 0,
    negative    bigint    not null default 0,
    stars       smallint  not null default 1,
    approved    boolean   not null default false
);

create index comments_user_id_index
    on comments (user_id);

create index comments_merchant_id_index
    on comments (merchant_id);

create unique index comments_user_merchant_id_uindex
    on comments (merchant_id, user_id, date);

create index comments_date_index
    on comments (date DESC);

create index comments_stars_index
    on comments (stars);

create index comments_stars_merchant_id_index
    on comments (stars, merchant_id);

