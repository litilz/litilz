CREATE TABLE `restaurant_categories` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`type` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `item_categories` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`type` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);



CREATE TABLE `restaurants` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`image` varchar(255) NOT NULL,
	`name` varchar(255) NOT NULL,
	`type` varchar(255) NOT NULL,
	`categories` varchar(255) NOT NULL,
	`rating` DECIMAL NOT NULL,
	`min_order` INT NOT NULL,
	`delivery_time` varchar(255) NOT NULL,
	`phone` varchar(255) NOT NULL,
	`restaurant_loc` varchar(255) NOT NULL,
	`active` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `items` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`type` varchar(255) NOT NULL,
	`image` varchar(255) NOT NULL,
	`name` varchar(255) NOT NULL,
	`category` varchar(255) NOT NULL,
	`active` BOOLEAN NOT NULL,
	`price` INT NOT NULL,
	`quantity` INT NOT NULL,
	`restaurant_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_ordered_items` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`order_id` INT NOT NULL,
	`item_id` INT NOT NULL,
	`price` INT NOT NULL,
    `item_quantity` INT NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `food_order` (
	`id` INT(255) NOT NULL UNIQUE,
	`user_id` INT NOT NULL,
	`restaurant_id` INT NOT NULL,
	`grand_total` INT NOT NULL,
	`ordered_items_count` INT NOT NULL,
	`address_id` INT NOT NULL,
	`ordered_date` DATE NOT NULL,
	`status` varchar(255) NOT NULL,
	`delivered_by` varchar(255) NOT NULL,
	`delivery_charge` INT NOT NULL,
	PRIMARY KEY (`id`)
);



CREATE TABLE `food_cart` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`user_id` INT NOT NULL,
	`item_id` INT NOT NULL,
	`quantity` INT NOT NULL,
	`price` INT NOT NULL,
	PRIMARY KEY (`id`)
);


ALTER TABLE `items` ADD CONSTRAINT `items_fk0` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants`(`id`);

ALTER TABLE `user_ordered_items` ADD CONSTRAINT `user_ordered_items_fk0` FOREIGN KEY (`order_id`) REFERENCES `food_order`(`id`);

ALTER TABLE `user_ordered_items` ADD CONSTRAINT `user_ordered_items_fk1` FOREIGN KEY (`item_id`) REFERENCES `items`(`id`);

ALTER TABLE `food_order` ADD CONSTRAINT `food_order_fk0` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

ALTER TABLE `food_order` ADD CONSTRAINT `food_order_fk1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants`(`id`);

ALTER TABLE `food_order` ADD CONSTRAINT `food_order_fk2` FOREIGN KEY (`address_id`) REFERENCES `address`(`id`);

ALTER TABLE `food_cart` ADD CONSTRAINT `food_cart_fk1` FOREIGN KEY (`user_id`) REFERENCES `user`(`id`);

ALTER TABLE `food_cart` ADD CONSTRAINT `food_cart_fk2` FOREIGN KEY (`item_id`) REFERENCES `items`(`id`);
