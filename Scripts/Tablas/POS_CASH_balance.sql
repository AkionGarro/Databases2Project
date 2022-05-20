USE [ProyectoBasesDatos2]

CREATE TABLE [POS_CASH_balance](
	[SK_ID_PREV] [varchar](50) NULL,/*Agregar la FK*/
	[SK_ID_CURR] [varchar](50) NULL,/*Agregar la FK*/

	[MONTHS_BALANCE] [varchar](50) NULL,
	[CNT_INSTALMENT] [varchar](50) NULL,
	[CNT_INSTALMENT_FUTURE] [varchar](50) NULL,
	[NAME_CONTRACT_STATUS] [varchar](50) NULL,
	[SK_DPD] [varchar](50) NULL,
	[SK_DPD_DEF] [varchar](50) NULL
) 

ALTER TABLE Saldos.POS_CASH_balance
   ADD CONSTRAINT FK_POS_CASH_previousA FOREIGN KEY (SK_ID_PREV)
      REFERENCES Saldos.previous_application(SK_ID_PREV)
      ON DELETE no action
      ON UPDATE no action
;

ALTER TABLE Saldos.POS_CASH_balance
   ADD CONSTRAINT FK_POS_CASH_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
      ON DELETE no action
      ON UPDATE no action
;

