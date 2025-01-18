CREATE TABLE categories (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        parent BIGINT,
        depth_level INT,
        is_leaf BOOLEAN
);

CREATE TABLE products (
      id BIGSERIAL PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      description VARCHAR(255),
      price DOUBLE PRECISION,
      category_id BIGINT REFERENCES categories (id),
      available BOOLEAN,
      obsolete BOOLEAN,
      year_creation INT,
      serial_number VARCHAR(255)
);
