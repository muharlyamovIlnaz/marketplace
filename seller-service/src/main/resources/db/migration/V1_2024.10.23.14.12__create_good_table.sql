CREATE TABLE IF NOT EXISTS good (
    id SERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        price INTEGER NOT NULL,
        is_active BOOLEAN NOT NULL,
        good_category VARCHAR(255) NOT NULL,
        good_category_id BIGINT NOT NULL,
        description TEXT,
        picture_urls TEXT[]
    );