CREATE TABLE IF NOT EXISTS patient (
    id INTEGER NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    age INTEGER NOT NULL,
    sex varchar(10) NOT NULL,
    diagnosis varchar(100) NOT NULL,
    mode_of_transmission varchar(100) NOT NULL,
    PRIMARY KEY(id)
    );