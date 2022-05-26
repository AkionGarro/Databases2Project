USE [ProyectoBasesDatos2]
GO


DROP TABLE [Acceso].[AddressClientInformation];
CREATE TABLE [Acceso].[AddressClientInformation](
	[SK_ID_CURR] INT NULL, /*Agregar FK*/
	[REGION_RATING_CLIENT] [varchar](50) NULL,
	[REGION_RATING_CLIENT_W_CITY] [varchar](50) NULL,
	[WEEKDAY_APPR_PROCESS_START] [varchar](50) NULL,
	[HOUR_APPR_PROCESS_START] [varchar](50) NULL,
	[REG_REGION_NOT_LIVE_REGION] [varchar](50) NULL,
	[REG_REGION_NOT_WORK_REGION] [varchar](50) NULL,
	[LIVE_REGION_NOT_WORK_REGION] [varchar](50) NULL,
	[REG_CITY_NOT_LIVE_CITY] [varchar](50) NULL,
	[REG_CITY_NOT_WORK_CITY] [varchar](50) NULL,
	[LIVE_CITY_NOT_WORK_CITY] [varchar](50) NULL,
	[ORGANIZATION_TYPE] [varchar](50) NULL,
	[EXT_SOURCE_1] [varchar](50) NULL,
	[EXT_SOURCE_2] [varchar](50) NULL,
	[EXT_SOURCE_3] [varchar](50) NULL,
	
) 

TRUNCATE TABLE Acceso.AddressClientInformation;
DELETE FROM Acceso.AddressClientInformation;

ALTER TABLE Acceso.AddressClientInformation
DROP CONSTRAINT FK_AddressClientI_ApplicationT;

ALTER TABLE Acceso.AddressClientInformation
   ADD CONSTRAINT FK_AddressClientI_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
;
