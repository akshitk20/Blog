create table if not exists Post(
id int not null,
user_id int,
title varchar(255),
body varchar(255),
primary key (id)
);