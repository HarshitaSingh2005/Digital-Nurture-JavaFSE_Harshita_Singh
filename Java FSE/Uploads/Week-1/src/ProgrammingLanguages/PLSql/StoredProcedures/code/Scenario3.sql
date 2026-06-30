CREATE OR REPLACE PROCEDURE TransferFunds (

    p_from_account IN NUMBER,
    p_to_account   IN NUMBER,
    p_amount        IN NUMBER

)
AS

    v_balance NUMBER;

BEGIN

SELECT Balance
INTO v_balance
FROM ACCOUNTS
WHERE AccountID = p_from_account;

IF v_balance >= p_amount THEN

UPDATE ACCOUNTS
SET Balance = Balance - p_amount
WHERE AccountID = p_from_account;

UPDATE ACCOUNTS
SET Balance = Balance + p_amount
WHERE AccountID = p_to_account;

COMMIT;

DBMS_OUTPUT.PUT_LINE('Transfer successful');

ELSE

        DBMS_OUTPUT.PUT_LINE('Insufficient balance');

END IF;

EXCEPTION

    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account not found');

WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed');

END;
/

--Execute and check output
EXEC TransferFunds(101, 103, 2000);
SELECT * FROM ACCOUNTS;