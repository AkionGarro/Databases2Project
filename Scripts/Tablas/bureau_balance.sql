USE [ProyectoBasesDatos2]
GO

DROP  TABLE Creditos.bureau_balance;
CREATE TABLE [Creditos].[bureau_balance](
	[SK_ID_BUREAU] INT NULL,/*Agregar la FK*/
	[MONTHS_BALANCE] [varchar](50) NULL,
	[STATUS] [varchar](50) NULL
) 

TRUNCATE TABLE  Creditos.bureau_balance;

ALTER TABLE Creditos.bureau_balance
DROP CONSTRAINT FK_bureauBalance_CredBureau;

ALTER TABLE Creditos.bureau_balance
   ADD CONSTRAINT FK_bureauBalance_CredBureau FOREIGN KEY (SK_ID_BUREAU)
      REFERENCES Creditos.bureau(SK_ID_BUREAU);