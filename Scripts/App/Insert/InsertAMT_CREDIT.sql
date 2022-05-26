USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertAMT_CREDIT;
CREATE PROCEDURE SPInsertAMT_CREDIT 
			@SK_ID_BUREAU INT
           ,@MAX_OVERDUE VARCHAR(50)
           ,@SUM VARCHAR(50)
           ,@SUM_DEBT VARCHAR(50)
           ,@SUM_LIMIT VARCHAR(50)
           ,@SUM_OVERDUE VARCHAR(50)
           ,@ANNUITY VARCHAR(50)
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




