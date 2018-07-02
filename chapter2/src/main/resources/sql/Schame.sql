CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
	`remark` text,
	PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
x

INSERT INTO `customer` values (''1'', ''customer1'', ''Jack'', ''13512345678'', ''jack@gmaol.com'', null);
INSERT INTO `customer` values (''2'', ''customer1'', ''Rose'', ''13612345678'', ''rose@gmaol.com'', null);