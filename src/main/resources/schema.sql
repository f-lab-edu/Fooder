DROP TABLE MEMBER IF EXISTS CASCADE;
CREATE TABLE MEMBER
(
    ID           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY NOT NULL,
    PHONE_NUMBER VARCHAR(20)                                     NOT NULL,
    NAME         VARCHAR(20)                                     NOT NULL,
    NICK_NAME    VARCHAR(20)                                     NOT NULL
)
