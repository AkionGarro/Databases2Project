USE [ProyectoBasesDatos2]
GO


DROP PROCEDURE SPInsertPosCashBalance;
CREATE PROCEDURE SPInsertPosCashBalance  
  		@SK_ID_PREV INT
           ,@SK_ID_CURR INT
           ,@MONTHS_BALANCE VARCHAR(50)
           ,@CNT_INSTALMENT VARCHAR(50)
           ,@CNT_INSTALMENT_FUTURE VARCHAR(50)
           ,@NAME_CONTRACT_STATUS VARCHAR(50)
           ,@SK_DPD VARCHAR(50)
           ,@SK_DPD_DEF VARCHAR(50)
AS
	BEGIN
	INSERT INTO [Saldos].[POS_CASH_balance]
           ([SK_ID_PREV]
           ,[SK_ID_CURR]
           ,[MONTHS_BALANCE]
           ,[CNT_INSTALMENT]
           ,[CNT_INSTALMENT_FUTURE]
           ,[NAME_CONTRACT_STATUS]
           ,[SK_DPD]
           ,[SK_DPD_DEF])
     VALUES
           (@SK_ID_PREV
           ,@SK_ID_CURR
           ,@MONTHS_BALANCE
           ,@CNT_INSTALMENT
           ,@CNT_INSTALMENT_FUTURE
           ,@NAME_CONTRACT_STATUS
           ,@SK_DPD
           ,@SK_DPD_DEF)
	END