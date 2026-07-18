CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN

UPDATE ACCOUNTS
SET Balance = Balance * 1.01
WHERE AccountType = 'SAVINGS';

COMMIT;

END;
/


--Execute and check
EXEC ProcessMonthlyInterest;
SELECT * FROM ACCOUNTS;