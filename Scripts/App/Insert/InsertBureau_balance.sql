USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertBureauBalance;
CREATE PROCEDURE SPInsertBureauBalance 
			@SK_ID_BUREAU VARCHAR
           ,@MONTHS_BALANCE VARCHAR
           ,@STATUS VARCHAR
AS
	BEGIN
	INSERT INTO [Creditos].[bureau_balance]
           ([SK_ID_BUREAU]
           ,[MONTHS_BALANCE]
           ,[STATUS])
     VALUES
           (@SK_ID_BUREAU
           ,@MONTHS_BALANCE
           ,@STATUS)
	END
GO




