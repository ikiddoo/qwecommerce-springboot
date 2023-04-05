CREATE TABLE `productdb`.`product` (
  `PRODUCT_ID` int NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(45) NOT NULL,
  `PRICE` float NOT NULL,
  `QUANTITY` int NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
);
INSERT INTO productdb.product(PRODUCT_NAME, PRICE, QUANTITY) VALUES ('Vessi Pro X', 199.99, 10);
select * from productdb.product;