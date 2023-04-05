CREATE TABLE `orderdb`.`orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `order_quantity` int NOT NULL,
  `order_status` varchar(45) NOT NULL,
  `order_date` datetime NOT NULL,
  `order_total_amount` float NOT NULL,
  `order_payment_mode` ENUM('CASH', 'PAYPAL', 'DEBIT_CARD', 'CREDIT_CARD') NOT NULL,
  PRIMARY KEY (`order_id`)
);
INSERT INTO orderdb.orders(order_total_amount, order_date, product_id, order_quantity, order_status, order_payment_mode)
values (299.98, '2023-03-31T10:35:47.601459700', 6, 100, 'CREATED', 'DEBIT_CARD');
select * from orderdb.orders;