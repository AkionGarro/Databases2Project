USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertBureau;
CREATE PROCEDURE SPInsertBureau @SK_ID_BUREAU VARCHAR(50)
           ,@SK_ID_CURR VARCHAR(50)
           ,@CREDIT_ACTIVE VARCHAR(50)
           ,@CREDIT_CURRENCY VARCHAR(50)
           ,@DAYS_CREDIT VARCHAR(50)
           ,@CREDIT_DAY_OVERDUE VARCHAR(50)
           ,@DAYS_CREDIT_ENDDATE VARCHAR(50)
           ,@DAYS_ENDDATE_FACT VARCHAR(50)
           ,@CNT_CREDIT_PROLONG VARCHAR(50)
           ,@CREDIT_TYPE VARCHAR(50)
           ,@DAYS_CREDIT_UPDATE VARCHAR(50)
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




