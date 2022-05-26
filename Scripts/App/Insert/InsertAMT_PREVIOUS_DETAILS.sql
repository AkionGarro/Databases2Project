USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertAMT_PREVIOUS_DETAILS;
CREATE PROCEDURE SPInsertAMT_PREVIOUS_DETAILS 
			@SK_ID_PREV INT
           ,@AMT_ANNUITY VARCHAR(50) 
           ,@AMT_APPLICATION VARCHAR(50) 
           ,@AMT_CREDIT VARCHAR(50) 
           ,@AMT_DOWN_PAYMENT VARCHAR(50) 
           ,@AMT_GOODS_PRICE VARCHAR(50) 
AS
	BEGIN
	INSERT INTO [Saldos].[AMT_PREVIOUS_DETAILS]
           ([SK_ID_PREV]
           ,[AMT_ANNUITY]
           ,[AMT_APPLICATION]
           ,[AMT_CREDIT]
           ,[AMT_DOWN_PAYMENT]
           ,[AMT_GOODS_PRICE])
     VALUES
           (@SK_ID_PREV
           ,@AMT_ANNUITY
           ,@AMT_APPLICATION
           ,@AMT_CREDIT
           ,@AMT_DOWN_PAYMENT
           ,@AMT_GOODS_PRICE)

	END
GO





