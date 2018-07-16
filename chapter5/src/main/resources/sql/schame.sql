create table user (
  id bigint not null AUTO_INCREMENT,
  username varchar(50) not null,
  password varchar(50) not null,
  primary key(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table role (
  id bigint not null AUTO_INCREMENT,
  role_name varchar(50) not null,
  primary key(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table permission (
  id bigint not null AUTO_INCREMENT,
  permission_name varchar(50) not null,
  primary key(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table user_role (
  id bigint not null AUTO_INCREMENT,
  user_id bigint not null,
  role_id bigint not null,
  primary key(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table role_permission (
  id bigint not null AUTO_INCREMENT,
  role_id bigint not null,
  permission_id bigint not null,
  primary key(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;