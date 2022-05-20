USE [ProyectoBasesDatos2]
GO


CREATE TABLE [bureau_balance](
	[SK_ID_BUREAU] [varchar](50) NULL,/*Agregar la FK*/
	[MONTHS_BALANCE] [varchar](50) NULL,
	[STATUS] [varchar](50) NULL
) 


ALTER TABLE Creditos.bureau_balance
   ADD CONSTRAINT FK_bureau_balance_bureau FOREIGN KEY (SK_ID_BUREAU)
      REFERENCES Creditos.bureau(SK_ID_BUREAU)
      ON DELETE no action
      ON UPDATE no action
;