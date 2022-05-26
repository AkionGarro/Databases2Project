USE [ProyectoBasesDatos2]
GO

DROP TABLE Acceso.FlagDocument;
CREATE TABLE [FlagDocument](
	[SK_ID_CURR] INT NULL, /*Agregar FK*/
	[DOCUMENT] [varchar](50) NULL,
)

ALTER TABLE Acceso.FlagDocument
   ADD CONSTRAINT FK_FlagDocument_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
;