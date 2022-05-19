
USE [ProyectoBasesDatos2]
GO

CREATE TABLE [CNT_BALANCE_DETAILS](
    [ID_CCB]  [varchar](50) NULL, /*Agregar la FK */
	[DRAWINGS_ATM_CURRENT] [varchar](50) NULL,
	[DRAWINGS_CURRENT] [varchar](50) NULL,
	[DRAWINGS_OTHER_CURRENT] [varchar](50) NULL,
	[DRAWINGS_POS_CURRENT] [varchar](50) NULL,
	[INSTALMENT_MATURE_CUM] [varchar](50) NULL,
) 

