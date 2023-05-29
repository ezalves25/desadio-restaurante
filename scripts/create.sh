CREATE DATABASE 'delivery'
  USER 'SYSDBA' PASSWORD 'masterkey'
  PAGE_SIZE 8192
  DEFAULT CHARACTER SET UTF8;

CONNECT 'localhost:/delivery' USER 'SYSDBA' PASSWORD 'masterkey';

-- Criação da tabela 'customers'
CREATE TABLE customers (
  id INTEGER NOT NULL,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  phone VARCHAR(20),
  PRIMARY KEY (id)
);

-- Criação da tabela 'orders'
CREATE TABLE orders (
  id INTEGER NOT NULL,
  customer_id INTEGER NOT NULL,
  order_date DATE NOT NULL,
  total DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (customer_id) REFERENCES customers (id)
);

-- Criação da tabela 'order_items'
CREATE TABLE order_items (
  id INTEGER NOT NULL,
  order_id INTEGER NOT NULL,
  product VARCHAR(100) NOT NULL,
  quantity INTEGER NOT NULL,
  price DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (order_id) REFERENCES orders (id)
);

-- Inserção de dados de exemplo na tabela 'customers'
INSERT INTO customers (id, name, email, phone)
VALUES
  (1, 'John Doe', 'john@example.com', '1234567890'),
  (2, 'Jane Smith', 'jane@example.com', '9876543210');

-- Inserção de dados de exemplo na tabela 'orders'
INSERT INTO orders (id, customer_id, order_date, total)
VALUES
  (1, 1, '2023-05-01', 50.00),
  (2, 2, '2023-05-05', 100.00);

-- Inserção de dados de exemplo na tabela 'order_items'
INSERT INTO order_items (id, order_id, product, quantity, price)
VALUES
  (1, 1, 'Product A', 2, 10.00),
  (2, 1, 'Product B', 3, 15.00),
  (3, 2, 'Product C', 1, 50.00);