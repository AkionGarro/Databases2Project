USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertApplication_train;
CREATE PROCEDURE SPInsertApplication_train 
			@SK_ID_CURR INT
           ,@TARGET VARCHAR(50)
           ,@NAME_CONTRACT_TYPE VARCHAR(50)
           ,@CODE_GENDER VARCHAR(50)
           ,@CNT_CHILDREN VARCHAR(50)
           ,@AMT_INCOME_TOTAL VARCHAR(50)
           ,@AMT_CREDIT VARCHAR(50)
           ,@AMT_ANNUITY VARCHAR(50)
           ,@AMT_GOODS_PRICE VARCHAR(50)
           ,@NAME_TYPE_SUITE VARCHAR(50)
           ,@NAME_INCOME_TYPE VARCHAR(50)
           ,@NAME_EDUCATION_TYPE VARCHAR(50)
           ,@NAME_FAMILY_STATUS VARCHAR(50)
           ,@NAME_HOUSING_TYPE VARCHAR(50)
           ,@REGION_POPULATION_RELATIVE VARCHAR(50)
           ,@DAYS_BIRTH VARCHAR(50)
           ,@DAYS_EMPLOYED VARCHAR(50)
           ,@DAYS_REGISTRATION VARCHAR(50)
           ,@DAYS_ID_PUBLISH VARCHAR(50)
           ,@OWN_CAR_AGE VARCHAR(50)
           ,@OCCUPATION_TYPE VARCHAR(50)
           ,@CNT_FAM_MEMBERS VARCHAR(50)
           ,@OBS_30_CNT_SOCIAL_CIRCLE VARCHAR(50)
           ,@DEF_30_CNT_SOCIAL_CIRCLE VARCHAR(50)
           ,@OBS_60_CNT_SOCIAL_CIRCLE VARCHAR(50)
           ,@DEF_60_CNT_SOCIAL_CIRCLE VARCHAR(50)
           ,@DAYS_LAST_PHONE_CHANGE VARCHAR(50)
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




