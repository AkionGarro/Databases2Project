/*Creacion login para Administrador*/
USE [master]
GO
CREATE LOGIN [creditAdmin] WITH PASSWORD=N'garroakion2908' MUST_CHANGE, DEFAULT_DATABASE=[master], CHECK_EXPIRATION=ON, CHECK_POLICY=ON
GO
ALTER SERVER ROLE [sysadmin] ADD MEMBER [creditAdmin]
GO

/*Creacion user para administrador*/
USE [ProyectoBasesDatos2]
GO
CREATE USER [creditAdmin] FOR LOGIN [creditAdmin]
GO

/*Creacion login para usuario normal*/
USE [master]
GO
CREATE LOGIN [creditUser] WITH PASSWORD=N'garroakion2908' MUST_CHANGE, DEFAULT_DATABASE=[master], CHECK_EXPIRATION=ON, CHECK_POLICY=ON
GO


/*Creacion de user para usuario*/
USE [ProyectoBasesDatos2]
GO
CREATE USER [creditUser] FOR LOGIN [creditUser]
GO
USE [ProyectoBasesDatos2]
GO
ALTER ROLE [db_datareader] ADD MEMBER [creditUser]
GO



/*Creacion de login para creditBackUp*/
USE [master]
GO
CREATE LOGIN [creditBackup] WITH PASSWORD=N'garroakion2908' MUST_CHANGE, DEFAULT_DATABASE=[master], CHECK_EXPIRATION=ON, CHECK_POLICY=ON
GO
use [ProyectoBasesDatos2];
GO


/*Creacion de user para creditBackUp*/

USE [ProyectoBasesDatos2]
GO
CREATE USER [creditBackup] FOR LOGIN [creditBackup]
GO
USE [ProyectoBasesDatos2]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [creditBackup]
GO