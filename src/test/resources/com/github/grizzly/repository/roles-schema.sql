drop table if exists public.roles CASCADE;

create table roles
(
    id   bigint generated by default as identity,
    role varchar(16),
    primary key (id)
);