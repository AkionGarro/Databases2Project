USE [ProyectoBasesDatos2]
GO

DROP TABLE Saldos.credit_card_balance;
CREATE TABLE [credit_card_balance](
	[ID_CCB]  INT NOT NULL, /*Agregar la PK*/
	PRIMARY KEY(ID_CCB),
	[SK_ID_PREV] INT NULL, /*Agregar la FK*/
	[SK_ID_CURR] INT NULL, /*Agregar la FK*/
	[MONTHS_BALANCE] [varchar](50) NULL,
	[NAME_CONTRACT_STATUS] [varchar](50) NULL,
	[SK_DPD] [varchar](50) NULL,
	[SK_DPD_DEF] [varchar](50) NULL
	
) 

ALTER TABLE Saldos.credit_card_balance
   ADD CONSTRAINT FK_credit_card_previousA FOREIGN KEY (SK_ID_PREV)
      REFERENCES Saldos.previous_application(SK_ID_PREV)
;

ALTER TABLE Saldos.credit_card_balance
   ADD CONSTRAINT FK_credit_card_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
;

