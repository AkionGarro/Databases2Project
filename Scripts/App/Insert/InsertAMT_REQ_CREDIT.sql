USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertAMT_REQ_CREDIT;
CREATE PROCEDURE SPInsertAMT_REQ_CREDIT 
			@SK_ID_CURR INT
           ,@BUREAU_HOUR VARCHAR(50)
           ,@BUREAU_DAY VARCHAR(50)
           ,@BUREAU_WEEK VARCHAR(50)
           ,@BUREAU_MON VARCHAR(50)
           ,@BUREAU_QRT VARCHAR(50)
           ,@BUREAU_YEAR VARCHAR(50)
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



