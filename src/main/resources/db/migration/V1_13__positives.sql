create table votes
(
    id          bigserial not null
        constraint votes_pk
            primary key,
    user_id     bigint    not null,
    comment_id  bigint    not null,
    is_positive boolean   not null
);


create unique index votes_user_comments_id_uindex
    on votes (user_id, comment_id);

create index votes_comments_id_index
    on votes (comment_id);

create index votes_comments_id_positive_index
    on votes (comment_id, is_positive);