SELECT * FROM DBA_USERS WHERE USERNAME LIKE 'USUARIO1';
SELECT * FROM DBA_USERS WHERE USERNAME LIKE 'USUARIO2';
SELECT * FROM DBA_USERS WHERE USERNAME LIKE 'ANA';

CONN USUARIO1/USUARIO1
CONN USUARIO2/USUARIO2
CONN ANA/ANA

CREATE USER USUARIO1 IDENTIFIED BY USUARIO1;
CREATE USER USUARIO2 IDENTIFIED BY USUARIO2;
CREATE USER ANA IDENTIFIED BY ANA;



GRANT CREATE SESSION TO USUARIO1;
GRANT CREATE SESSION TO USUARIO2 WITH ADMIN OPTION;

CONN USUARIO2/USUARIO2
GRANT CREATE SESSION TO ANA;

ALTER USER USUARIO1 ACCOUNT LOCK;
DROP USER USUARIO2;
ALTER USER ANA ACCOUNT LOCK;

ALTER USER USUARIO1 ACCOUNT UNLOCK;
ALTER USER ANA ACCOUNT UNLOCK;


SELECT USERNAME, ACCOUNT_STATUS FROM DBA_USERS WHERE USERNAME LIKE 'USUARIO1';
SELECT USERNAME, ACCOUNT_STATUS FROM DBA_USERS WHERE USERNAME LIKE 'USUARIO2';
SELECT USERNAME, ACCOUNT_STATUS FROM DBA_USERS WHERE USERNAME LIKE 'ANA';
