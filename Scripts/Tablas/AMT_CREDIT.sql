USE [ProyectoBasesDatos2]
GO


CREATE TABLE [AMT_CREDIT](
	[SK_ID_BUREAU] [varchar](50) NULL, /*Agregar la FK*/

	[MAX_OVERDUE] [varchar](50) NULL,
	[SUM] [varchar](50) NULL,
	[SUM_DEBT] [varchar](50) NULL,
	[SUM_LIMIT] [varchar](50) NULL,
	[SUM_OVERDUE] [varchar](50) NULL,
	[ANNUITY] [varchar](50) NULL
) 

ALTER TABLE Creditos.AMT_CREDIT
   ADD CONSTRAINT FK_AMT_CREDIT_bureau FOREIGN KEY (SK_ID_BUREAU)
      REFERENCES Creditos.bureau(SK_ID_BUREAU)
      ON DELETE no action
      ON UPDATE no action
;

