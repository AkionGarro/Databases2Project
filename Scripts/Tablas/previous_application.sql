USE [ProyectoBasesDatos2]
GO


CREATE TABLE [previous_application](
	[SK_ID_PREV] [varchar](50) NOT NULL, /*Agregar la PK*/
	CONSTRAINT PK_previous_application_SK_ID_PREV PRIMARY KEY CLUSTERED (SK_ID_PREV),

	[SK_ID_CURR] [varchar](50) NULL, /*Agregar la FK*/
	[NAME_CONTRACT_TYPE] [varchar](50) NULL,
	[WEEKDAY_APPR_PROCESS_START] [varchar](50) NULL,
	[HOUR_APPR_PROCESS_START] [varchar](50) NULL,
	[FLAG_LAST_APPL_PER_CONTRACT] [varchar](50) NULL,
	[NFLAG_LAST_APPL_IN_DAY] [varchar](50) NULL,
	[RATE_DOWN_PAYMENT] [varchar](50) NULL,
	[RATE_INTEREST_PRIMARY] [varchar](50) NULL,
	[RATE_INTEREST_PRIVILEGED] [varchar](50) NULL,
	[NAME_CASH_LOAN_PURPOSE] [varchar](50) NULL,
	[NAME_CONTRACT_STATUS] [varchar](50) NULL,
	[DAYS_DECISION] [varchar](50) NULL,
	[NAME_PAYMENT_TYPE] [varchar](50) NULL,
	[CODE_REJECT_REASON] [varchar](50) NULL,
	[NAME_TYPE_SUITE] [varchar](50) NULL,
	[NAME_CLIENT_TYPE] [varchar](50) NULL,
	[NAME_GOODS_CATEGORY] [varchar](50) NULL,
	[NAME_PORTFOLIO] [varchar](50) NULL,
	[NAME_PRODUCT_TYPE] [varchar](50) NULL,
	[CHANNEL_TYPE] [varchar](50) NULL,
	[SELLERPLACE_AREA] [varchar](50) NULL,
	[NAME_SELLER_INDUSTRY] [varchar](50) NULL,
	[CNT_PAYMENT] [varchar](50) NULL,
	[NAME_YIELD_GROUP] [varchar](50) NULL,
	[PRODUCT_COMBINATION] [varchar](50) NULL,
	[DAYS_FIRST_DRAWING] [varchar](50) NULL,
	[DAYS_FIRST_DUE] [varchar](50) NULL,
	[DAYS_LAST_DUE_1ST_VERSION] [varchar](50) NULL,
	[DAYS_LAST_DUE] [varchar](50) NULL,
	[DAYS_TERMINATION] [varchar](50) NULL,
	[NFLAG_INSURED_ON_APPROVAL] [varchar](50) NULL
) 

ALTER TABLE Saldos.previous_application
   ADD CONSTRAINT FK_previousA_ApplicationT FOREIGN KEY (SK_ID_CURR)
      REFERENCES Acceso.application_train(SK_ID_CURR)
      ON DELETE CASCADE
      ON UPDATE CASCADE
;