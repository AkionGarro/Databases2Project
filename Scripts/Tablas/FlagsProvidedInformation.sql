USE [ProyectoBasesDatos2]
GO

CREATE TABLE [FlagsProvidedInformation](
	[SK_ID_CURR] [varchar](50) NULL, /*Agregar FK*/
	[FLAG_OWN_CAR] [varchar](50) NULL,
	[FLAG_OWN_REALTY] [varchar](50) NULL,
	[FLAG_MOBIL] [varchar](50) NULL,
	[FLAG_EMP_PHONE] [varchar](50) NULL,
	[FLAG_WORK_PHONE] [varchar](50) NULL,
	[FLAG_CONT_MOBILE] [varchar](50) NULL,
	[FLAG_PHONE] [varchar](50) NULL,
	[FLAG_EMAIL] [varchar](50) NULL,

) 


ALTER TABLE Acceso.FlagsProvidedInformation
   ADD CONSTRAINT FK_FlagsProvidedInformation_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
      ON DELETE no action
      ON UPDATE no action
;

