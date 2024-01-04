use dbshop;


CREATE TABLE Category (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          level INT,
                          parent_id BIGINT,
                          order_number BIGINT,
                          name VARCHAR(20) NOT NULL,
                          price DECIMAL(19,2),
                          img VARCHAR(255),
                          detail TEXT,

                          CONSTRAINT fk_category_parent FOREIGN KEY (parent_id)
                              REFERENCES Category (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO Category (level, parent_id, order_number, name, price, img, detail)
VALUES (0, NULL, 1, 'Electronics', 1500.00, 'electronics.jpg', 'Electronic gadgets and devices');

INSERT INTO Category (level, parent_id, order_number, name, price, img, detail)
VALUES (1, 1, 1, 'Laptops', 1000.00, 'laptops.jpg', 'Various kinds of laptops');

INSERT INTO Category (level, parent_id, order_number, name, price, img, detail)
VALUES (1, 1, 2, 'Smartphones', 500.00, 'smartphones.jpg', 'Latest smartphones in the market');

INSERT INTO Category (level, parent_id, order_number, name, price, img, detail)
VALUES (2, 2, 1, 'Gaming Laptops', 1200.00, 'gaming_laptops.jpg', 'High performance laptops for gaming');

INSERT INTO Category (level, parent_id, order_number, name, price, img, detail)
VALUES (2, 3, 1, 'Android Phones', 300.00, 'android_phones.jpg', 'Variety of Android smartphones');


CREATE TABLE User (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(5),
                      password VARCHAR(255),
                      phone VARCHAR(255),
                      address TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO User (name, password, phone, address)
VALUES ('John', 'pwd123', '1234567890', '123 Baker Street, London');

INSERT INTO User (name, password, phone, address)
VALUES ('Jane', 'pwd456', '0987654321', '456 Elm Street, Springfield');



CREATE TABLE `Order` (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         datetime DATETIME,
                         summoney DECIMAL(19,2),
                         state INT,
                         user_id BIGINT,

                         CONSTRAINT fk_order_user FOREIGN KEY (user_id)
                             REFERENCES User (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `Order` (datetime, summoney, state, user_id)
VALUES ('2024-01-01 10:00:00', 100.00, 1, 1);

INSERT INTO `Order` (datetime, summoney, state, user_id)
VALUES ('2024-01-02 15:30:00', 200.50, 2, 2);



CREATE TABLE OrderCategory (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               orderId BIGINT,
                               categoryId BIGINT,
                               num INT,
                               createTime DATETIME,

                               CONSTRAINT fk_ordercategory_order FOREIGN KEY (orderId)
                                   REFERENCES `Order` (id),
                               CONSTRAINT fk_ordercategory_category FOREIGN KEY (categoryId)
                                   REFERENCES Category (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO OrderCategory (orderId, categoryId, num, createTime)
VALUES (1, 1, 10, '2024-01-01 00:00:00');

INSERT INTO OrderCategory (orderId, categoryId, num, createTime)
VALUES (2, 2, 5, '2024-01-02 00:00:00');








