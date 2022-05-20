USE [ProyectoBasesDatos2]
GO


CREATE TABLE [credit_card_balance](
	[ID_CCB]  [varchar](50) NOT NULL, /*Agregar la PK*/
	CONSTRAINT PK_credit_card_balance_ID_CCB PRIMARY KEY CLUSTERED (ID_CCB),
	[SK_ID_PREV] [varchar](50) NULL, /*Agregar la FK*/
	[SK_ID_CURR] [varchar](50) NULL, /*Agregar la FK*/

	[MONTHS_BALANCE] [varchar](50) NULL,
	[NAME_CONTRACT_STATUS] [varchar](50) NULL,
	[SK_DPD] [varchar](50) NULL,
	[SK_DPD_DEF] [varchar](50) NULL
	
) 

ALTER TABLE Saldos.credit_card_balance
   ADD CONSTRAINT FK_credit_card_previousA FOREIGN KEY (SK_ID_PREV)
      REFERENCES Saldos.previous_application(SK_ID_PREV)
      ON DELETE no action
      ON UPDATE no action
;

ALTER TABLE Saldos.credit_card_balance
   ADD CONSTRAINT FK_credit_card_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
      ON DELETE no action
      ON UPDATE no action
;

