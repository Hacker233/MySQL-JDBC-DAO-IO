drop table  if exists training.employees;
CREATE TABLE training.employees
(
    id                          INT NOT NULL,
    name                        VARCHAR(50),
    gender                      CHAR(1),
    age                         INT default 18,
    degree                      VARCHAR(20),
    email                       VARCHAR(20),
    entry_date                  CHAR(8),
    CONSTRAINT PRIMARY KEY (id)
);