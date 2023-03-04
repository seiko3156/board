create table employee(
    num NUMBER PRIMARY KEY,
    name VARCHAR2(30),
    phone VARCHAR2(30),
    position VARCHAR2(30),
    email VARCHAR2(50)
);
create sequence aboard increment by 1 start with 1;