create table users
(
    id         bigint auto_increment
        primary key,
    created_at date         null,
    email      varchar(255) not null,
    name       varchar(255) not null,
    password   varchar(255) not null,
    updated_at date         null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email)
);

create table rentals
(
    id          bigint auto_increment
        primary key,
    created_at  date          not null,
    description varchar(2000) not null,
    name        varchar(255)  not null,
    owner_id    bigint        not null,
    picture     varchar(255)  not null,
    price       int           not null,
    surface     int           not null,
    updated_at  date          null,
    constraint FKf462yhxa9vd3m2qdmcoixg1fv
        foreign key (owner_id) references users (id)
);

create table message
(
    id         bigint auto_increment
        primary key,
    created_at date         null,
    message    varchar(255) not null,
    rental_id  bigint       not null,
    updated_at date         null,
    user_id    bigint       not null,
    constraint FK4ywh7dsrn84akh3qs7awbg2qt
        foreign key (rental_id) references rentals (id),
    constraint FKpdrb79dg3bgym7pydlf9k3p1n
        foreign key (user_id) references users (id)
);
