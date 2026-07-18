-- Drop tables if they already exist

DROP TABLE ACCOUNTS CASCADE CONSTRAINTS;
DROP TABLE EMPLOYEES CASCADE CONSTRAINTS;

-- Accounts table

CREATE TABLE ACCOUNTS (
                          AccountID NUMBER PRIMARY KEY,
                          CustomerName VARCHAR2(100),
                          AccountType VARCHAR2(20),
                          Balance NUMBER(12,2)
);

-- Employees table

CREATE TABLE EMPLOYEES (
                           EmployeeID NUMBER PRIMARY KEY,
                           EmployeeName VARCHAR2(100),
                           DepartmentID NUMBER,
                           Salary NUMBER(12,2)
);