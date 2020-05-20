
/*List customers*/

INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Jose','Calderon','joscompu@gmail.com','2020-05-17','default_1.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Noah','Calderon','joscompu@gmail.com','2020-05-17','default_2.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Gregorio','Calderon','joscompu@gmail.com','2020-05-17','default_3.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Daniel','Calderon','joscompu@gmail.com','2020-05-17','default_4.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Elba','Calderon','joscompu@gmail.com','2020-05-17','default_5.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Adan','Calderon','joscompu@gmail.com','2020-05-17','default_6.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Jessica','Colmenares','joscompu@gmail.com','2020-05-17','default_7.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Jose','Calderon','joscompu@gmail.com','2020-05-17','default_8.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Noah','Calderon','joscompu@gmail.com','2020-05-17','default_9.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Gregorio','Calderon','joscompu@gmail.com','2020-05-17','default_10.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Daniel','Calderon','joscompu@gmail.com','2020-05-17','default_11.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Elba','Calderon','joscompu@gmail.com','2020-05-17','default_12.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Adan','Calderon','joscompu@gmail.com','2020-05-17','default_13.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Jessica','Colmenares','joscompu@gmail.com','2020-05-17','default_14.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Jose','Calderon','joscompu@gmail.com','2020-05-17','default_15.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Noah','Calderon','joscompu@gmail.com','2020-05-17','default_16.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Gregorio','Calderon','joscompu@gmail.com','2020-05-17','default_17.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Daniel','Calderon','joscompu@gmail.com','2020-05-17','default_18.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Elba','Calderon','joscompu@gmail.com','2020-05-17','default_19.png');
INSERT INTO customers (name,last_name,email,create_at,photo) VALUES('Adan','Calderon','joscompu@gmail.com','2020-05-17','default_20.png');

/*List items*/

INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 1 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 2 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 3 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 4 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 5 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 6 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 7 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 8 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 9 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 10 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 11 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 12 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 13 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 14 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 15 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 16 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 17 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 18 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 19 User','33',NOW());
INSERT INTO items (name_item,price,create_at) VALUES('Sales Mobilizer 20 User','33',NOW());


/*List invoices*/

INSERT INTO invoices (description,observation,customer_id,create_at) VALUES('Invoice #1',null,1,NOW());
INSERT INTO invoices_items (quantity,invoice_id,item_id) VALUES(1,1,1);
INSERT INTO invoices_items (quantity,invoice_id,item_id) VALUES(2,1,4);
INSERT INTO invoices_items (quantity,invoice_id,item_id) VALUES(1,1,5);
INSERT INTO invoices_items (quantity,invoice_id,item_id) VALUES(1,1,7);

INSERT INTO invoices (description,observation,customer_id,create_at) VALUES('Invoice #2',null,1,NOW());
INSERT INTO invoices_items (quantity,invoice_id,item_id) VALUES(3,2,6);