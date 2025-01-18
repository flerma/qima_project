INSERT INTO categories (id, name, parent, depth_level, is_leaf)
VALUES
    (1, 'Electronics', NULL, 0, FALSE),
    (2, 'Computers', 1, 1, FALSE),
    (3, 'Laptops', 2, 2, TRUE),
    (4, 'Smartphones', 1, 1, TRUE);
