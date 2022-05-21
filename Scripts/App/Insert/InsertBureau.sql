USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertBureau;
CREATE PROCEDURE SPInsertBureau 
			@SK_ID_BUREAU VARCHAR
           ,@SK_ID_CURR VARCHAR
           ,@CREDIT_ACTIVE VARCHAR
           ,@CREDIT_CURRENCY VARCHAR
           ,@DAYS_CREDIT VARCHAR
           ,@CREDIT_DAY_OVERDUE VARCHAR
           ,@DAYS_CREDIT_ENDDATE VARCHAR
           ,@DAYS_ENDDATE_FACT VARCHAR
           ,@CNT_CREDIT_PROLONG VARCHAR
           ,@CREDIT_TYPE VARCHAR
           ,@DAYS_CREDIT_UPDATE VARCHAR
AS
	BEGIN
	INSERT INTO [Creditos].[bureau]
           ([SK_ID_BUREAU]
           ,[SK_ID_CURR]
           ,[CREDIT_ACTIVE]
           ,[CREDIT_CURRENCY]
           ,[DAYS_CREDIT]
           ,[CREDIT_DAY_OVERDUE]
           ,[DAYS_CREDIT_ENDDATE]
           ,[DAYS_ENDDATE_FACT]
           ,[CNT_CREDIT_PROLONG]
           ,[CREDIT_TYPE]
           ,[DAYS_CREDIT_UPDATE])
     VALUES
           (@SK_ID_BUREAU
           ,@SK_ID_CURR
           ,@CREDIT_ACTIVE
           ,@CREDIT_CURRENCY
           ,@DAYS_CREDIT
           ,@CREDIT_DAY_OVERDUE
           ,@DAYS_CREDIT_ENDDATE
           ,@DAYS_ENDDATE_FACT
           ,@CNT_CREDIT_PROLONG
           ,@CREDIT_TYPE
           ,@DAYS_CREDIT_UPDATE)
	END
GO




