USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertBureauBalance;
CREATE PROCEDURE SPInsertBureauBalance 
			@SK_ID_BUREAU INT
           ,@MONTHS_BALANCE VARCHAR(50)
           ,@STATUS VARCHAR(50)
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




