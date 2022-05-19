USE [ProyectoBasesDatos2]
GO

CREATE TABLE [credit_card_balance](
	[ID_CCB]  [varchar](50) NULL, /*Agregar la PK*/
	[SK_ID_PREV] [varchar](50) NULL, /*Agregar la FK*/
	[SK_ID_CURR] [varchar](50) NULL, /*Agregar la FK*/

	[MONTHS_BALANCE] [varchar](50) NULL,
	[NAME_CONTRACT_STATUS] [varchar](50) NULL,
	[SK_DPD] [varchar](50) NULL,
	[SK_DPD_DEF] [varchar](50) NULL
	
) 

