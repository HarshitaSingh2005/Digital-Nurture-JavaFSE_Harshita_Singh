CREATE TABLE CUSTOMERS (
                           CustomerID NUMBER PRIMARY KEY,
                           Name VARCHAR2(100),
                           Age NUMBER,
                           Balance NUMBER,
                           IsVIP CHAR(1)
);

CREATE TABLE LOANS (
                       LoanID NUMBER PRIMARY KEY,
                       CustomerID NUMBER,
                       InterestRate NUMBER,
                       DueDate DATE
);