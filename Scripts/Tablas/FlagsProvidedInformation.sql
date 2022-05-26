USE [ProyectoBasesDatos2]
GO

DROP TABLE [Acceso].[FlagsProvidedInformation];
CREATE TABLE [Acceso].[FlagsProvidedInformation](
	[SK_ID_CURR] INT NULL, /*Agregar FK*/
	[FLAG_OWN_CAR] [varchar](50) NULL,
	[FLAG_OWN_REALTY] [varchar](50) NULL,
	[FLAG_MOBIL] [varchar](50) NULL,
	[FLAG_EMP_PHONE] [varchar](50) NULL,
	[FLAG_WORK_PHONE] [varchar](50) NULL,
	[FLAG_CONT_MOBILE] [varchar](50) NULL,
	[FLAG_PHONE] [varchar](50) NULL,
	[FLAG_EMAIL] [varchar](50) NULL,

) 

TRUNCATE TABLE Acceso.FlagsProvidedInformation;
DELETE FROM Acceso.FlagsProvidedInformation;


ALTER TABLE Acceso.FlagsProvidedInformation
DROP CONSTRAINT FK_FlagsProvidedInformation_ApplicationT;


ALTER TABLE Acceso.FlagsProvidedInformation
   ADD CONSTRAINT FK_FlagsProvidedInformation_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
;

