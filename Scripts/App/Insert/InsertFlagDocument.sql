USE [ProyectoBasesDatos2]
GO

DROP PROCEDURE SPInsertFlagDocument;
CREATE PROCEDURE SPInsertFlagDocument @SK_ID_CURR varchar
, @DOCUMENT varchar
AS
BEGIN
  INSERT INTO [Acceso].[FlagDocument] ([SK_ID_CURR]
  , [DOCUMENT])
    VALUES (@SK_ID_CURR, @DOCUMENT)

END
GO

