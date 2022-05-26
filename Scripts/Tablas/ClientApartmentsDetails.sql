USE [ProyectoBasesDatos2]
GO


DROP TABLE [Acceso].[ClientApartmentsDetails];
CREATE TABLE [Acceso].[ClientApartmentsDetails](
	[SK_ID_CURR] INT NULL, /*Agregar FK*/
	[APARTMENTS_AVG] [varchar](50) NULL,
	[BASEMENTAREA_AVG] [varchar](50) NULL,
	[YEARS_BEGINEXPLUATATION_AVG] [varchar](50) NULL,
	[YEARS_BUILD_AVG] [varchar](50) NULL,
	[COMMONAREA_AVG] [varchar](50) NULL,
	[ELEVATORS_AVG] [varchar](50) NULL,
	[ENTRANCES_AVG] [varchar](50) NULL,
	[FLOORSMAX_AVG] [varchar](50) NULL,
	[FLOORSMIN_AVG] [varchar](50) NULL,
	[LANDAREA_AVG] [varchar](50) NULL,
	[LIVINGAPARTMENTS_AVG] [varchar](50) NULL,
	[LIVINGAREA_AVG] [varchar](50) NULL,
	[NONLIVINGAPARTMENTS_AVG] [varchar](50) NULL,
	[NONLIVINGAREA_AVG] [varchar](50) NULL,
	[APARTMENTS_MODE] [varchar](50) NULL,
	[BASEMENTAREA_MODE] [varchar](50) NULL,
	[YEARS_BEGINEXPLUATATION_MODE] [varchar](50) NULL,
	[YEARS_BUILD_MODE] [varchar](50) NULL,
	[COMMONAREA_MODE] [varchar](50) NULL,
	[ELEVATORS_MODE] [varchar](50) NULL,
	[ENTRANCES_MODE] [varchar](50) NULL,
	[FLOORSMAX_MODE] [varchar](50) NULL,
	[FLOORSMIN_MODE] [varchar](50) NULL,
	[LANDAREA_MODE] [varchar](50) NULL,
	[LIVINGAPARTMENTS_MODE] [varchar](50) NULL,
	[LIVINGAREA_MODE] [varchar](50) NULL,
	[NONLIVINGAPARTMENTS_MODE] [varchar](50) NULL,
	[NONLIVINGAREA_MODE] [varchar](50) NULL,
	[APARTMENTS_MEDI] [varchar](50) NULL,
	[BASEMENTAREA_MEDI] [varchar](50) NULL,
	[YEARS_BEGINEXPLUATATION_MEDI] [varchar](50) NULL,
	[YEARS_BUILD_MEDI] [varchar](50) NULL,
	[COMMONAREA_MEDI] [varchar](50) NULL,
	[ELEVATORS_MEDI] [varchar](50) NULL,
	[ENTRANCES_MEDI] [varchar](50) NULL,
	[FLOORSMAX_MEDI] [varchar](50) NULL,
	[FLOORSMIN_MEDI] [varchar](50) NULL,
	[LANDAREA_MEDI] [varchar](50) NULL,
	[LIVINGAPARTMENTS_MEDI] [varchar](50) NULL,
	[LIVINGAREA_MEDI] [varchar](50) NULL,
	[NONLIVINGAPARTMENTS_MEDI] [varchar](50) NULL,
	[NONLIVINGAREA_MEDI] [varchar](50) NULL,
	[FONDKAPREMONT_MODE] [varchar](50) NULL,
	[HOUSETYPE_MODE] [varchar](50) NULL,
	[TOTALAREA_MODE] [varchar](50) NULL,
	[WALLSMATERIAL_MODE] [varchar](50) NULL,
	[EMERGENCYSTATE_MODE] [varchar](50) NULL,
) 


TRUNCATE TABLE Acceso.ClientApartmentsDetails;
DELETE FROM Acceso.ClientApartmentsDetails;


ALTER TABLE Acceso.ClientApartmentsDetails
DROP CONSTRAINT FK_ClientApartments_ApplicationT;

ALTER TABLE Acceso.ClientApartmentsDetails
   ADD CONSTRAINT FK_ClientApartments_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
;
