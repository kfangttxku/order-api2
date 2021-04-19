USE salesman;

CREATE TABLE orders (
   order_id INT NOT NULL AUTO_INCREMENT,
   customer_id INT NOT NULL,
   product_id INT NOT NULL,
   product_amount INT NOT NULL,
   order_status VARCHAR(30) NOT NULL,
   order_date DATE NOT NULL,
   PRIMARY KEY (order_id)
);
