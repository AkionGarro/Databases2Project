USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertAMT_REQ_CREDIT;
CREATE PROCEDURE SPInsertAMT_REQ_CREDIT 
			@SK_ID_CURR VARCHAR
           ,@BUREAU_HOUR VARCHAR
           ,@BUREAU_DAY VARCHAR
           ,@BUREAU_WEEK VARCHAR
           ,@BUREAU_MON VARCHAR
           ,@BUREAU_QRT VARCHAR
           ,@BUREAU_YEAR VARCHAR
AS
	BEGIN
	INSERT INTO [Acceso].[AMT_REQ_CREDIT]
           ([SK_ID_CURR]
           ,[BUREAU_HOUR]
           ,[BUREAU_DAY]
           ,[BUREAU_WEEK]
           ,[BUREAU_MON]
           ,[BUREAU_QRT]
           ,[BUREAU_YEAR])
     VALUES
           (@SK_ID_CURR
           ,@BUREAU_HOUR
           ,@BUREAU_DAY
           ,@BUREAU_WEEK
           ,@BUREAU_MON
           ,@BUREAU_QRT
           ,@BUREAU_YEAR)



	END
GO



