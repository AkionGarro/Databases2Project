USE [ProyectoBasesDatos2]
GO


DROP TABLE Acceso.AMT_REQ_CREDIT;
CREATE TABLE [Acceso].[AMT_REQ_CREDIT](
	[SK_ID_CURR] INT NULL, /*Agregar FK*/
	[BUREAU_HOUR] [varchar](50) NULL,
	[BUREAU_DAY] [varchar](50) NULL,
	[BUREAU_WEEK] [varchar](50) NULL,
	[BUREAU_MON] [varchar](50) NULL,
	[BUREAU_QRT] [varchar](50) NULL,
	[BUREAU_YEAR] [varchar](50) NULL
)


ALTER TABLE Acceso.AMT_REQ_CREDIT
   ADD CONSTRAINT FK_AMT_REQ_CREDIT_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
;
