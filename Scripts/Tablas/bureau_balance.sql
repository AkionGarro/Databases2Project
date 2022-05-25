USE [ProyectoBasesDatos2]
GO

drop table Creditos.bureau_balance;
CREATE TABLE Creditos.[bureau_balance](
	[SK_ID_BUREAU] [varchar](50) NULL,/*Agregar la FK*/
	[MONTHS_BALANCE] [varchar](50) NULL,
	[STATUS] [varchar](50) NULL
) 

truncate table  Creditos.bureau_balance;
Alter table Creditos.bureau_balance
drop constraint FK_bureauBalance_CredBureau;
ALTER TABLE Creditos.bureau_balance
   ADD CONSTRAINT FK_bureauBalance_CredBureau FOREIGN KEY (SK_ID_BUREAU)
      REFERENCES Creditos.bureau(SK_ID_BUREAU)
      ON DELETE no action
      ON UPDATE no action
;