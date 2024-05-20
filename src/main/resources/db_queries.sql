create schema brd_cart;

use brd_cart;

CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `img` varchar(255) DEFAULT NULL,
  `quantity` int NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_by` varchar(255) DEFAULT NULL,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` varchar(50) NOT NULL,
  `user_created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
