INSERT INTO categories (id, name, parent, depth_level, is_leaf, creation_user, creation_date, update_user, update_date)
VALUES
    (1, 'Electronics', NULL, 0, FALSE, 1, NOW(), 1, NOW()),
    (2, 'Computers', 1, 1, FALSE, 1, NOW(), 1, NOW()),
    (3, 'Laptops', 2, 2, TRUE, 1, NOW(), 1, NOW()),
    (4, 'Smartphones', 1, 1, TRUE, 1, NOW(), 1, NOW());
