DROP TABLE IF EXISTS CALC;

CREATE TABLE CALC (
  id  int PRIMARY KEY,
  input1 VARCHAR(250) NOT NULL,
  input2 VARCHAR(250) NOT NULL,
  operator VARCHAR(250) NOT NULL,
  result VARCHAR(250) NOT NULL
);