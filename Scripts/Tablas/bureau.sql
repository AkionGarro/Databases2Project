USE [ProyectoBasesDatos2]
GO


drop table Creditos.bureau;

CREATE TABLE [Creditos].[bureau](
	[SK_ID_BUREAU] [varchar](50) NOT NULL, /*Agregar la PK*/
	CONSTRAINT PK_bureau_SK_ID_BUREAU PRIMARY KEY CLUSTERED (SK_ID_BUREAU),
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

truncate table Creditos.bureau;

ALTER TABLE   Creditos.bureau
DROP CONSTRAINT FK_Bureau_AppTrain;

ALTER TABLE [Creditos].[bureau]
   ADD CONSTRAINT FK_Bureau_AppTrain FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
      ON DELETE no action
      ON UPDATE no action
;