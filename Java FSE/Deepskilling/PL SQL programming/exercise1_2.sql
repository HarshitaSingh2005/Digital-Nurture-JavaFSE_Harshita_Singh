-- Exercise 1 : Control Structures

-- Scenario 1
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Age FROM Customers;
BEGIN
    FOR cust IN c_customers LOOP
        IF cust.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 2
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance FROM Customers;
BEGIN
    FOR cust IN c_customers LOOP
        IF cust.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = cust.CustomerID;
        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3
BEGIN
    FOR loan_rec IN (
        SELECT CustomerID, LoanID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ' || loan_rec.CustomerID ||
            ' has loan ' || loan_rec.LoanID ||
            ' due on ' || loan_rec.DueDate
        );
    END LOOP;
END;
/

-- Exercise 2 : Error Handling

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001,'Insufficient Funds');
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_empid NUMBER,
    p_percent NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + Salary * p_percent / 100
    WHERE EmployeeID = p_empid;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE NO_DATA_FOUND;
    END IF;

    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee ID does not exist');
END;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customerid NUMBER,
    p_name VARCHAR2,
    p_balance NUMBER
)
IS
BEGIN
    INSERT INTO Customers(CustomerID, Name, Balance)
    VALUES (p_customerid, p_name, p_balance);

    COMMIT;

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer already exists');
        ROLLBACK;
END;
/