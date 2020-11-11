INSERT INTO Brand (id, name) VALUES (1, 'First brand');
INSERT INTO Brand (id, name) VALUES (2, 'Second brand');
INSERT INTO Brand (id, name) VALUES (3, 'Third brand');

INSERT INTO Product (id, brand_id, name, price, quantity) VALUES (1, 1, 'Shoes', 1000, 3);
INSERT INTO Product (id, brand_id, name, price, quantity) VALUES (2, 2, 'Laptop', 20000, 2);
INSERT INTO Product (id, brand_id, name, price, quantity) VALUES (3, 2, 'Phone', 15000, 10);
INSERT INTO Product (id, brand_id, name, price, quantity) VALUES (4, 3, 'Cheese', 200, 100);
INSERT INTO Product (id, brand_id, name, price, quantity) VALUES (5, 3, 'Milk', 80, 50);
INSERT INTO Product (id, brand_id, name, price, quantity) VALUES (6, 3, 'Eggs', 50, 80);

INSERT INTO User_Info (id, username, password, is_admin) VALUES (1, 'Alan', '$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm', true);
INSERT INTO User_Info (id, username, password, is_admin) VALUES (2, 'Steve', '$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm', false);