USE [ProyectoBasesDatos2]
GO

CREATE TABLE [installments_payments](
	[SK_ID_PREV] [varchar](50) NULL, /*Agregar la FK*/
	[SK_ID_CURR] [varchar](50) NULL, /*Agregar la FK*/
	
	[NUM_INSTALMENT_VERSION] [varchar](50) NULL,
	[NUM_INSTALMENT_NUMBER] [varchar](50) NULL,
	[DAYS_INSTALMENT] [varchar](50) NULL,
	[DAYS_ENTRY_PAYMENT] [varchar](50) NULL,
	[AMT_INSTALMENT] [varchar](50) NULL,
	[AMT_PAYMENT] [varchar](50) NULL
) 

