create table comments
(
    id          bigserial not null
        constraint comments_pk
            primary key,
    comment     text      not null,
    user_id     bigint    not null,
    merchant_id bigint    not null,
    date        timestamp not null,
    positive    bigint    not null default 0,
    negative    bigint    not null default 0,
    approved    boolean   not null default false
);

create index comments_user_id_index
    on comments (user_id);

create index comments_merchant_id_index
    on comments (merchant_id);

create index comments_date_index
    on comments (date DESC);

