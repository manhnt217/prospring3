DROP TABLE IF EXISTS CONTACT; 
CREATE TABLE CONTACT ( 
ID INT NOT NULL AUTO_INCREMENT 
, FIRST_NAME VARCHAR(60) NOT NULL 
, LAST_NAME VARCHAR(40) NOT NULL 
, BIRTH_DATE DATE 
, DESCRIPTION VARCHAR(2000) 
, PHOTO BLOB 
, VERSION INT NOT NULL DEFAULT 0 
, UNIQUE UQ_CONTACT_1 (FIRST_NAME, LAST_NAME) 
, PRIMARY KEY (ID) 
); 