CREATE TABLE categories (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        parent BIGINT,
        depth_level INT,
        is_leaf BOOLEAN,
        creation_user BIGINT,
        creation_date TIMESTAMP,
        update_user BIGINT,
        update_date TIMESTAMP
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
      serial_number VARCHAR(255),
      creation_user BIGINT,
      creation_date TIMESTAMP,
      update_user BIGINT,
      update_date TIMESTAMP
);
