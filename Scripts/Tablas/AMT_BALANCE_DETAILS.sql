USE [ProyectoBasesDatos2]
GO


CREATE TABLE [AMT_BALANCE_DETAILS](

	[ID_CCB]  [varchar](50) NULL, /*Agregar la FK */
	[BALANCE] [varchar](50) NULL,
	[CREDIT_LIMIT_ACTUAL] [varchar](50) NULL,
	[DRAWINGS_ATM_CURRENT] [varchar](50) NULL,
	[DRAWINGS_CURRENT] [varchar](50) NULL,
	[DRAWINGS_OTHER_CURRENT] [varchar](50) NULL,
	[DRAWINGS_POS_CURRENT] [varchar](50) NULL,
	[INST_MIN_REGULARITY] [varchar](50) NULL,
	[PAYMENT_CURRENT] [varchar](50) NULL,
	[PAYMENT_TOTAL_CURRENT] [varchar](50) NULL,
	[RECEIVABLE_PRINCIPAL] [varchar](50) NULL,
	[RECIVABLE] [varchar](50) NULL,
	[TOTAL_RECEIVABLE] [varchar](50) NULL,
	
) 

ALTER TABLE Saldos.AMT_BALANCE_DETAILS
   ADD CONSTRAINT FK_AMT_BALANCE_Credit_Card FOREIGN KEY (ID_CCB)
      REFERENCES Saldos.credit_card_balance(ID_CCB)
      ON DELETE no action
      ON UPDATE no action
;