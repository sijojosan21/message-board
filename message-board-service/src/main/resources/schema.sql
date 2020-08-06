CREATE TABLE MESSAGE (
    Id   number      NOT NULL AUTO_INCREMENT,
    UserName VARCHAR(128) NOT NULL,
    Header TEXT NOT NULL,
    Body TEXT NOT NULL,
    Message_TimeStamp number,
    PRIMARY KEY (id)
);