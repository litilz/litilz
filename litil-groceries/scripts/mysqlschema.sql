mysql -uroot -proot

create USER 'litil'@'localhost' IDENTIFIED BY 'litil@1234';

grant all privileges on * . * to 'litil'@'localhost';

FLUSH PRIVILEGES;

mysql -ulitil -plitil@1234

create DATABASE litil;

grant all privileges on litil.* TO 'litil'@'localhost';

use litil;

create TABLE `product` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`selling` varchar(255)NOT NULL,
	`original_price` VARCHAR(255) NOT NULL,
	`discount` VARCHAR(255),
	`imageUrl`  varchar(255) NOT NULL,
	`category` VARCHAR(255) NOT NULL,
	`weight` VARCHAR(255) NOT NULL,
	`availability` boolean NOT NULL,
	PRIMARY KEY (`id`)
);

create TABLE `address` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL,
	`line1` varchar(255) NOT NULL,
	`phone` varchar(255) NOT NULL,
	`city` VARCHAR(255) NOT NULL,
	`state` VARCHAR(255) NOT NULL,
	`country` VARCHAR(255)NOT NULL,
	`pincode` VARCHAR(255) NOT NULL,
	`landmark` VARCHAR(255),
	`mobile` VARCHAR(255) NOT NULL,
	`user_id` INT NOT NULL,
	`active` boolean NOT NULL,
	`enabled` boolean NOT NULL,
	PRIMARY KEY (`id`)
);


create TABLE `user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_name` VARCHAR(255) NOT NULL,
	`name` VARCHAR(255) ,
	`phone` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255),
    PRIMARY KEY (`id`)
);

create TABLE `help_support` (
`id` INT NOT NULL AUTO_INCREMENT,
`category` VARCHAR(255) NOT NULL,
`value` VARCHAR(255) NOT NULL,
 PRIMARY KEY (`id`)
  );

  create TABLE `about_us` (
`id` INT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(255) NOT NULL,
`description` VARCHAR(255) NOT NULL,
 PRIMARY KEY (`id`)
  );

create TABLE `orders` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`address_id` INT NOT NULL,
	`selling` VARCHAR(255) NOT NULL,
	`original` VARCHAR(255) NOT NULL,
	`discount` VARCHAR(255) NOT NULL,
	`status` VARCHAR(255) NOT NULL,
	`deliveryby` VARCHAR(255) NOT NULL,
    `date_ordered` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

create TABLE `order_items` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`orderid` BIGINT NOT NULL,
	`productid` INT NOT NULL,
	`price` INT NOT NULL,
	PRIMARY KEY (`id`)
);

create TABLE `wish_items` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`productid` INT NOT NULL,
	`user_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

create TABLE `offers` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `image` VARCHAR(255) NOT NULL,
    `title` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);

create TABLE `notifications` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `notification` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);


create TABLE `category` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`category` VARCHAR(255) NOT NULL,
	`image` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);

create TABLE `media_categories` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`category` VARCHAR(255) NOT NULL,
	`image` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`)
);

create TABLE `media_order` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`user_id` int(11) NOT NULL,
	`description` VARCHAR(255) NOT NULL,
	`category` VARCHAR(255),
	`phone` VARCHAR(255)  NOT NULL,
	`amount` VARCHAR(255),
	`status` VARCHAR(255) NOT NULL,
    `ordered` DATE NOT NULL,
	`deliveryby` VARCHAR(255),
	PRIMARY KEY (`id`)
);



create TABLE `cart` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`productid` INT NOT NULL,
	`user_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    `price` INT NOT NULL,
	PRIMARY KEY (`id`)
);

create TABLE `pincode` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`pincode` VARCHAR(255),
	PRIMARY KEY (`id`)
);

alter table `address` ADD CONSTRAINT `address_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

alter table `orders` ADD CONSTRAINT `orders_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

alter table `orders` ADD CONSTRAINT `orders_fk1` FOREIGN KEY (`address_id`) REFERENCES `address`(`id`);

alter table `order_items` ADD CONSTRAINT `order_items_fk0` FOREIGN KEY (`orderid`) REFERENCES `orders`(`id`);

alter table `order_items` ADD CONSTRAINT `order_items_fk1` FOREIGN KEY (`productid`) REFERENCES `product`(`id`);

alter table `wish_items` ADD CONSTRAINT `wish_items_fk0` FOREIGN KEY (`productid`) REFERENCES `product`(`id`);

alter table `wish_items` ADD CONSTRAINT `wish_items_fk1` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

alter table `media_order` ADD CONSTRAINT `media_order_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

alter table `cart` ADD CONSTRAINT `cart_fk0` FOREIGN KEY (`productid`) REFERENCES `product`(`id`);

alter table `cart` ADD CONSTRAINT `cart_fk1` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);


--SET SQL_SAFE_UPDATES=0;