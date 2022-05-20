USE [ProyectoBasesDatos2]
GO

CREATE TABLE [FlagDocument](
	[SK_ID_CURR] [varchar](50) NULL, /*Agregar FK*/
	[DOCUMENT] [varchar](50) NULL,
)

ALTER TABLE Acceso.FlagDocument
   ADD CONSTRAINT FK_FlagDocument_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
      ON DELETE no action
      ON UPDATE no action
;