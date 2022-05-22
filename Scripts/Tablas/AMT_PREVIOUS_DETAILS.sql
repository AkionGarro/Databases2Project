USE [ProyectoBasesDatos2]
GO

CREATE TABLE [AMT_PREVIOUS_DETAILS](
	[SK_ID_PREV] [varchar](50) NULL, /*Agregar FK*/

	[AMT_ANNUITY] [varchar](50) NULL,
	[AMT_APPLICATION] [varchar](50) NULL,
	[AMT_CREDIT] [varchar](50) NULL,
	[AMT_DOWN_PAYMENT] [varchar](50) NULL,
	[AMT_GOODS_PRICE] [varchar](50) NULL,

) 

ALTER TABLE Saldos.AMT_PREVIOUS_DETAILS
   ADD CONSTRAINT FK_AMT_PREVIOUS_previousA FOREIGN KEY (SK_ID_PREV)
      REFERENCES Saldos.previous_application(SK_ID_PREV)
      ON DELETE no action
      ON UPDATE no action
;