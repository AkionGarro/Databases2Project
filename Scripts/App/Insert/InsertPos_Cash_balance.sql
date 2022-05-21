USE [ProyectoBasesDatos2]
GO


DROP PROCEDURE SPInsertPosCashBalance;
CREATE PROCEDURE SPInsertPosCashBalance  
  		@SK_ID_PREV VARCHAR
           ,@SK_ID_CURR VARCHAR
           ,@MONTHS_BALANCE VARCHAR
           ,@CNT_INSTALMENT VARCHAR
           ,@CNT_INSTALMENT_FUTURE VARCHAR
           ,@NAME_CONTRACT_STATUS VARCHAR
           ,@SK_DPD VARCHAR
           ,@SK_DPD_DEF VARCHAR
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