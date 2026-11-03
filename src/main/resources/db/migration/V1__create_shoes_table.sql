CREATE TABLE `shoes`(
    `id` bigint NOT NULL  AUTO_INCREMENT,
    `brand` varchar(100) NOT NULL,
    `model` varchar(200) NOT NULL,
    `shoe_size` decimal(10,2) NOT NULL,
    `price` decimal(10, 2) NOT NULL,
    CONSTRAINT  pk_shoes PRIMARY KEY(`id`)
)