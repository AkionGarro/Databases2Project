
DROP PROCEDURE SPGetAllLoans;
CREATE PROCEDURE SPGetAllLoans  
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



 