USE [ProyectoBasesDatos2]
GO

DROP TABLE Saldos.installments_payments;
CREATE TABLE [installments_payments](
	[SK_ID_PREV] INT NULL, /*Agregar la FK*/
	[SK_ID_CURR] INT NULL, /*Agregar la FK*/
	[NUM_INSTALMENT_VERSION] [varchar](50) NULL,
	[NUM_INSTALMENT_NUMBER] [varchar](50) NULL,
	[DAYS_INSTALMENT] [varchar](50) NULL,
	[DAYS_ENTRY_PAYMENT] [varchar](50) NULL,
	[AMT_INSTALMENT] [varchar](50) NULL,
	[AMT_PAYMENT] [varchar](50) NULL
) 

ALTER TABLE Saldos.installments_payments
   ADD CONSTRAINT FK_installments_payments_previousA FOREIGN KEY (SK_ID_PREV)
      REFERENCES Saldos.previous_application(SK_ID_PREV)
;

ALTER TABLE Saldos.installments_payments
   ADD CONSTRAINT FK_installments_payments_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
;

