SQLPLUS/ NOLOG 
CONN ESCUELA/123
SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE='ESCUELA';


CREATE TABLE DEPARTAMENTO (DEPT CHAR(4),
                           EDIF CHAR(2),
						   DESPACHO NUMBER(8,0),
						   CHFNO CHAR(3)
                            );
							
CREATE TABLE CURSO (NO CHAR(3),
                    NOMBRE VARCHAR2(25),
					DESCP CHAR(25),
					RED NUMBER(8,0),
					TARIFA NUMBER(8,2),
					DEPT VARCHAR(4)
					);
					
CREATE TABLE CLAUSTRO (NO VARCHAR(3),
                       NOMBRE CHAR(15),
					   DOMI CHAR(20),
					   FCANTI DATE,
					   NUMDEP NUMBER(8,0),
					   SUELDO NUMBER(10,4),
					   DEPT CHAR(4)
					   );
					   
CREATE TABLE CLASE(NO CHAR(3),
                   SEC VARCHAR(2),
				   INSTRFNO CHAR(2),
				   DIA CHAR(2),
				   HORA CHAR(14),
				   EDIF CHAR(2),
				   DESPACHO NUMBER(9,0)
				   );
				   
CREATE TABLE ESTUDIANTE(NO CHAR(3),
                        NOMBRE CHAR(30),
						DOMI CHAR(15),
						TLFNO CHAR(12),
						FNACIM CHAR(6),
						IQ NUMBER(7,0),
						ADVFNO CHAR(3),
						ESP CHAR(4)
                        );
	
CREATE TABLE MATRICULA (NO CHAR(3), 
                        SEC CHAR(2),
						FECHAMAT DATE,
						HORAMAT CHAR(10)
						);
						
CREATE TABLE PERSONAL (NOMBRE CHAR(15),
                       CARGO CHAR(10),
					   SUELDO NUMBER(18,0),
					   DEPT CHAR(4)
					   );
				
SELECT * FROM ESCUELA;