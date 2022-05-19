USE [ProyectoBasesDatos2]
GO



CREATE TABLE [bureau](
	[SK_ID_BUREAU] [varchar](50) NULL, /*Agregar la PK*/
	[SK_ID_CURR] [varchar](50) NULL, /*Agregar la FK*/
	
	[CREDIT_ACTIVE] [varchar](50) NULL,
	[CREDIT_CURRENCY] [varchar](50) NULL,
	[DAYS_CREDIT] [varchar](50) NULL,
	[CREDIT_DAY_OVERDUE] [varchar](50) NULL,
	[DAYS_CREDIT_ENDDATE] [varchar](50) NULL,
	[DAYS_ENDDATE_FACT] [varchar](50) NULL,
	[CNT_CREDIT_PROLONG] [varchar](50) NULL,
	[CREDIT_TYPE] [varchar](50) NULL,
	[DAYS_CREDIT_UPDATE] [varchar](50) NULL,

)

