USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertCreditCardBalance;
CREATE PROCEDURE SPInsertCreditCardBalance @ID_CCB varchar(50)
, @SK_ID_PREV varchar(50)
, @SK_ID_CURR varchar(50)
, @MONTHS_BALANCE varchar(50)
, @NAME_CONTRACT_STATUS varchar(50)
, @SK_DPD varchar(50)
, @SK_DPD_DEF varchar(50)
AS
BEGIN
  INSERT INTO [Saldos].[credit_card_balance] ([ID_CCB]
  , [SK_ID_PREV]
  , [SK_ID_CURR]
  , [MONTHS_BALANCE]
  , [NAME_CONTRACT_STATUS]
  , [SK_DPD]
  , [SK_DPD_DEF])

    VALUES (@ID_CCB, @SK_ID_PREV, @SK_ID_CURR, @MONTHS_BALANCE, 
	@NAME_CONTRACT_STATUS, @SK_DPD, @SK_DPD_DEF)
END