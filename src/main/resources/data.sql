DROP TABLE IF EXISTS data;

CREATE TABLE data (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  age NUMERIC NOT NULL
);

INSERT INTO billionaires (first_name, last_name, age) VALUES
  ('Aliko', 'Dangote', 25),
  ('Bill', 'Gates', 50),
  ('Folrunsho', 'Alakija', 75);