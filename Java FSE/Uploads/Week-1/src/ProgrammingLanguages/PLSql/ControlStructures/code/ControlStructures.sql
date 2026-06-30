--Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old

BEGIN
FOR customer_rec IN (
        SELECT CustomerID
        FROM CUSTOMERS
        WHERE Age > 60
    )
    LOOP
UPDATE LOANS
SET InterestRate = InterestRate - 1
WHERE CustomerID = customer_rec.CustomerID;
END LOOP;

COMMIT;
END;
/


--Scenario 2: A customer can be promoted to VIP status based on their balance

BEGIN
FOR customer_rec IN (
        SELECT CustomerID
        FROM CUSTOMERS
        WHERE Balance > 10000
    )
    LOOP
UPDATE CUSTOMERS
SET IsVIP = 'Y'
WHERE CustomerID = customer_rec.CustomerID;
END LOOP;

COMMIT;
END;
/

--Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.

BEGIN
FOR loan_rec IN (
        SELECT c.Name,
               l.LoanID,
               l.DueDate
        FROM CUSTOMERS c
        JOIN LOANS l
          ON c.CustomerID = l.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ID '
            || loan_rec.LoanID
            || ' for customer '
            || loan_rec.Name
            || ' is due on '
            || TO_CHAR(loan_rec.DueDate, 'DD-MON-YYYY')
        );
END LOOP;
END;
/