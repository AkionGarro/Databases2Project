use ProyectoBasesDatos2;
DROP PROCEDURE SPGetAllLoansWithParamethers;
CREATE PROCEDURE SPGetAllLoansWithParamethers  
	@inputIncome VARCHAR(50),
    @inputActive VARCHAR(50),
	@inputContract VARCHAR(50),
	@inputTotal VARCHAR(50)
AS
	BEGIN
	

SELECT  at.SK_ID_CURR, at.NAME_CONTRACT_TYPE, 
at.AMT_INCOME_TOTAL,
at.NAME_INCOME_TYPE,
br.CREDIT_ACTIVE,
bb.MONTHS_BALANCE 
  FROM [ProyectoBasesDatos2].[Acceso].[application_train] as at
  JOIN Creditos.bureau AS br
  ON(at.SK_ID_CURR = br.SK_ID_CURR)
  JOIN Creditos.bureau_balance as bb
  ON(br.SK_ID_BUREAU = bb.SK_ID_BUREAU)
  WHERE AT.NAME_INCOME_TYPE = @inputIncome AND
  BR.CREDIT_ACTIVE = @inputActive AND 
  at.NAME_CONTRACT_TYPE = @inputContract AND
  CAST(at.AMT_INCOME_TOTAL AS DECIMAL) >  CAST(@inputTotal AS DECIMAL)
  END



DROP PROCEDURE SPGetCredidCardDetails ;
CREATE PROCEDURE SPGetCredidCardDetails 
	@inputID VARCHAR(50)

AS
	BEGIN
		SELECT app.SK_ID_CURR,app.CODE_GENDER,cb.MONTHS_BALANCE,
		bd.BALANCE,bd.CREDIT_LIMIT_ACTUAL
		FROM ACCESO.application_train AS app
		JOIN Saldos.credit_card_balance as cb
			ON(app.SK_ID_CURR = cb.SK_ID_CURR)
		JOIN Saldos.AMT_BALANCE_DETAILS  as bd
			ON (cb.ID_CCB = bd.ID_CCB)
		WHERE  app.SK_ID_CURR like @inputID +'%'
	
END


DROP PROCEDURE SPGetPaymentsCapacity;
CREATE PROCEDURE SPGetPaymentsCapacity
@userId VARCHAR(50)

AS
	BEGIN
		SELECT app.SK_ID_CURR,app.AMT_INCOME_TOTAL,
		isp.AMT_PAYMENT,ad.APARTMENTS_AVG,ad.HOUSETYPE_MODE,ad.WALLSMATERIAL_MODE
		FROM Acceso.application_train AS  app
		JOIN Saldos.installments_payments AS isp
		ON (app.SK_ID_CURR = isp.SK_ID_CURR) 
		JOIN Acceso.ClientApartmentsDetails AS ad
		ON(app.SK_ID_CURR = ad.SK_ID_CURR)
		WHERE app.SK_ID_CURR LIKE @userId +'%' 
END


DROP PROCEDURE SPGetContractType;
CREATE PROCEDURE SPGetContractType
AS
	BEGIN
SELECT 
      [SK_ID_PREV],[NAME_CONTRACT_TYPE]
  FROM [ProyectoBasesDatos2].[Saldos].[previous_application]
  END



 DROP PROCEDURE SPGetIncome;
CREATE PROCEDURE SPGetIncome
AS
	BEGIN
SELECT app.SK_ID_CURR,app.AMT_INCOME_TOTAL
  FROM [ProyectoBasesDatos2].[Saldos].[previous_application] as pv
  JOIN Acceso.application_train AS app
  ON(PV.SK_ID_CURR = APP.SK_ID_CURR)
  END