USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertApplication_train;
CREATE PROCEDURE SPInsertApplication_train 
			@SK_ID_CURR VARCHAR
           ,@TARGET VARCHAR
           ,@NAME_CONTRACT_TYPE VARCHAR
           ,@CODE_GENDER VARCHAR
           ,@CNT_CHILDREN VARCHAR
           ,@AMT_INCOME_TOTAL VARCHAR
           ,@AMT_CREDIT VARCHAR
           ,@AMT_ANNUITY VARCHAR
           ,@AMT_GOODS_PRICE VARCHAR
           ,@NAME_TYPE_SUITE VARCHAR
           ,@NAME_INCOME_TYPE VARCHAR
           ,@NAME_EDUCATION_TYPE VARCHAR
           ,@NAME_FAMILY_STATUS VARCHAR
           ,@NAME_HOUSING_TYPE VARCHAR
           ,@REGION_POPULATION_RELATIVE VARCHAR
           ,@DAYS_BIRTH VARCHAR
           ,@DAYS_EMPLOYED VARCHAR
           ,@DAYS_REGISTRATION VARCHAR
           ,@DAYS_ID_PUBLISH VARCHAR
           ,@OWN_CAR_AGE VARCHAR
           ,@OCCUPATION_TYPE VARCHAR
           ,@CNT_FAM_MEMBERS VARCHAR
           ,@OBS_30_CNT_SOCIAL_CIRCLE VARCHAR
           ,@DEF_30_CNT_SOCIAL_CIRCLE VARCHAR
           ,@OBS_60_CNT_SOCIAL_CIRCLE VARCHAR
           ,@DEF_60_CNT_SOCIAL_CIRCLE VARCHAR
           ,@DAYS_LAST_PHONE_CHANGE VARCHAR
AS
	BEGIN
	INSERT INTO [Acceso].[application_train]
           ([SK_ID_CURR]
           ,[TARGET]
           ,[NAME_CONTRACT_TYPE]
           ,[CODE_GENDER]
           ,[CNT_CHILDREN]
           ,[AMT_INCOME_TOTAL]
           ,[AMT_CREDIT]
           ,[AMT_ANNUITY]
           ,[AMT_GOODS_PRICE]
           ,[NAME_TYPE_SUITE]
           ,[NAME_INCOME_TYPE]
           ,[NAME_EDUCATION_TYPE]
           ,[NAME_FAMILY_STATUS]
           ,[NAME_HOUSING_TYPE]
           ,[REGION_POPULATION_RELATIVE]
           ,[DAYS_BIRTH]
           ,[DAYS_EMPLOYED]
           ,[DAYS_REGISTRATION]
           ,[DAYS_ID_PUBLISH]
           ,[OWN_CAR_AGE]
           ,[OCCUPATION_TYPE]
           ,[CNT_FAM_MEMBERS]
           ,[OBS_30_CNT_SOCIAL_CIRCLE]
           ,[DEF_30_CNT_SOCIAL_CIRCLE]
           ,[OBS_60_CNT_SOCIAL_CIRCLE]
           ,[DEF_60_CNT_SOCIAL_CIRCLE]
           ,[DAYS_LAST_PHONE_CHANGE])
     VALUES
           (@SK_ID_CURR
           ,@TARGET
           ,@NAME_CONTRACT_TYPE
           ,@CODE_GENDER
           ,@CNT_CHILDREN
           ,@AMT_INCOME_TOTAL
           ,@AMT_CREDIT
           ,@AMT_ANNUITY
           ,@AMT_GOODS_PRICE
           ,@NAME_TYPE_SUITE
           ,@NAME_INCOME_TYPE
           ,@NAME_EDUCATION_TYPE
           ,@NAME_FAMILY_STATUS
           ,@NAME_HOUSING_TYPE
           ,@REGION_POPULATION_RELATIVE
           ,@DAYS_BIRTH
           ,@DAYS_EMPLOYED
           ,@DAYS_REGISTRATION
           ,@DAYS_ID_PUBLISH
           ,@OWN_CAR_AGE
           ,@OCCUPATION_TYPE
           ,@CNT_FAM_MEMBERS
           ,@OBS_30_CNT_SOCIAL_CIRCLE
           ,@DEF_30_CNT_SOCIAL_CIRCLE
           ,@OBS_60_CNT_SOCIAL_CIRCLE
           ,@DEF_60_CNT_SOCIAL_CIRCLE
           ,@DAYS_LAST_PHONE_CHANGE)


	END
GO




