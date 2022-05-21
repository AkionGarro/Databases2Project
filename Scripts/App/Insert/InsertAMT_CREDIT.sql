USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertAMT_CREDIT;
CREATE PROCEDURE SPInsertAMT_CREDIT 
			@SK_ID_BUREAU VARCHAR
           ,@MAX_OVERDUE VARCHAR
           ,@SUM VARCHAR
           ,@SUM_DEBT VARCHAR
           ,@SUM_LIMIT VARCHAR
           ,@SUM_OVERDUE VARCHAR
           ,@ANNUITY VARCHAR
AS
	BEGIN
	INSERT INTO [Creditos].[AMT_CREDIT]
           ([SK_ID_BUREAU]
           ,[MAX_OVERDUE]
           ,[SUM]
           ,[SUM_DEBT]
           ,[SUM_LIMIT]
           ,[SUM_OVERDUE]
           ,[ANNUITY])
     VALUES
           (@SK_ID_BUREAU
           ,@MAX_OVERDUE
           ,@SUM
           ,@SUM_DEBT
           ,@SUM_LIMIT
           ,@SUM_OVERDUE
           ,@ANNUITY)

	END
GO




