/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homecredit.migrator;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import homecredit.dbConnection.Conn;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author garroakion
 */
public class Migrator {

    final String dataset = "C:\\Users\\garroakion\\Desktop\\ProyectosCompu\\DataSetProjectBases";
    final String application_train = dataset + "\\application_train.csv";
    final String bureau = dataset + "\\bureau.csv";
    final String bureau_balance = dataset + "\\bureau_balance.csv";
    final String credit_card_balance = dataset + "\\credit_card_balance.csv";
    final String installments_payments = dataset + "\\installments_payments.csv";
    final String POS_CASH_balance = dataset + "\\POS_CASH_balance.csv";
    final String previous_application = dataset + "\\previous_application.csv";

    /**
     * *
     * Migration of the Aplication Train CSV File.
     *
     * * @param connect The Connection object of the Database
     */
    public void migrationAplicationTrain(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(application_train))) {
            String[] nextLine;
            reader.skip(1);
            while ((nextLine = reader.readNext()) != null) {

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertApplication_train(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                    cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[0]));
                    cstmt.setString("TARGET", nextLine[1].toString());
                    cstmt.setString("NAME_CONTRACT_TYPE", nextLine[2].toString());
                    cstmt.setString("CODE_GENDER", nextLine[3].toString());
                    cstmt.setString("CNT_CHILDREN", nextLine[6].toString());
                    cstmt.setString("AMT_INCOME_TOTAL", nextLine[7].toString());
                    cstmt.setString("AMT_CREDIT", nextLine[8].toString());
                    cstmt.setString("AMT_ANNUITY", nextLine[9].toString());
                    cstmt.setString("AMT_GOODS_PRICE", nextLine[10].toString());
                    cstmt.setString("NAME_TYPE_SUITE", nextLine[11].toString());
                    cstmt.setString("NAME_INCOME_TYPE", nextLine[12].toString());
                    cstmt.setString("NAME_EDUCATION_TYPE", nextLine[13].toString());
                    cstmt.setString("NAME_FAMILY_STATUS", nextLine[14].toString());
                    cstmt.setString("NAME_HOUSING_TYPE", nextLine[15].toString());
                    cstmt.setString("REGION_POPULATION_RELATIVE", nextLine[16].toString());
                    cstmt.setString("DAYS_BIRTH", nextLine[17].toString());
                    cstmt.setString("DAYS_EMPLOYED", nextLine[18].toString());
                    cstmt.setString("DAYS_REGISTRATION", nextLine[19].toString());
                    cstmt.setString("DAYS_ID_PUBLISH", nextLine[20].toString());
                    cstmt.setString("OWN_CAR_AGE", nextLine[21].toString());
                    cstmt.setString("OCCUPATION_TYPE", nextLine[28].toString());
                    cstmt.setString("CNT_FAM_MEMBERS", nextLine[29].toString());
                    cstmt.setString("OBS_30_CNT_SOCIAL_CIRCLE", nextLine[91].toString());
                    cstmt.setString("DEF_30_CNT_SOCIAL_CIRCLE", nextLine[92].toString());
                    cstmt.setString("OBS_60_CNT_SOCIAL_CIRCLE", nextLine[93].toString());
                    cstmt.setString("DEF_60_CNT_SOCIAL_CIRCLE", nextLine[94].toString());
                    cstmt.setString("DAYS_LAST_PHONE_CHANGE", nextLine[95].toString());
                    cstmt.execute();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    /**
     * *
     * Migration of the ClientApartments datao of the CSV File.
     *
     * * @param connect The Connection object of the Database
     */
    public void migrationClientApartments(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(application_train))) {
            String[] nextLine;
            reader.skip(1);
            while ((nextLine = reader.readNext()) != null) {

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertClientApartmentsDetails(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                    if (!nextLine[44].toString().equals("") && !nextLine[45].toString().equals("")) {
                        cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[0]));
                        cstmt.setString("APARTMENTS_AVG", nextLine[44].toString());
                        cstmt.setString("BASEMENTAREA_AVG", nextLine[45].toString());
                        cstmt.setString("YEARS_BEGINEXPLUATATION_AVG", nextLine[46].toString());
                        cstmt.setString("YEARS_BUILD_AVG", nextLine[47].toString());
                        cstmt.setString("COMMONAREA_AVG", nextLine[48].toString());
                        cstmt.setString("ELEVATORS_AVG", nextLine[49].toString());
                        cstmt.setString("ENTRANCES_AVG", nextLine[50].toString());
                        cstmt.setString("FLOORSMAX_AVG", nextLine[51].toString());
                        cstmt.setString("FLOORSMIN_AVG", nextLine[52].toString());
                        cstmt.setString("LANDAREA_AVG", nextLine[53].toString());
                        cstmt.setString("LIVINGAPARTMENTS_AVG", nextLine[54].toString());
                        cstmt.setString("LIVINGAREA_AVG", nextLine[55].toString());
                        cstmt.setString("NONLIVINGAPARTMENTS_AVG", nextLine[56].toString());
                        cstmt.setString("NONLIVINGAREA_AVG", nextLine[57].toString());
                        cstmt.setString("APARTMENTS_MODE", nextLine[58].toString());
                        cstmt.setString("BASEMENTAREA_MODE", nextLine[59].toString());
                        cstmt.setString("YEARS_BEGINEXPLUATATION_MODE", nextLine[60].toString());
                        cstmt.setString("YEARS_BUILD_MODE", nextLine[61].toString());
                        cstmt.setString("COMMONAREA_MODE", nextLine[62].toString());
                        cstmt.setString("ELEVATORS_MODE", nextLine[63].toString());
                        cstmt.setString("ENTRANCES_MODE", nextLine[64].toString());
                        cstmt.setString("FLOORSMAX_MODE", nextLine[65].toString());
                        cstmt.setString("FLOORSMIN_MODE", nextLine[66].toString());
                        cstmt.setString("LANDAREA_MODE", nextLine[67].toString());
                        cstmt.setString("LIVINGAPARTMENTS_MODE", nextLine[68].toString());
                        cstmt.setString("LIVINGAREA_MODE", nextLine[69].toString());
                        cstmt.setString("NONLIVINGAPARTMENTS_MODE", nextLine[70].toString());
                        cstmt.setString("NONLIVINGAREA_MODE", nextLine[71].toString());
                        cstmt.setString("APARTMENTS_MEDI", nextLine[72].toString());
                        cstmt.setString("BASEMENTAREA_MEDI", nextLine[73].toString());
                        cstmt.setString("YEARS_BEGINEXPLUATATION_MEDI", nextLine[74].toString());
                        cstmt.setString("YEARS_BUILD_MEDI", nextLine[75].toString());
                        cstmt.setString("COMMONAREA_MEDI", nextLine[76].toString());
                        cstmt.setString("ELEVATORS_MEDI", nextLine[77].toString());
                        cstmt.setString("ENTRANCES_MEDI", nextLine[78].toString());
                        cstmt.setString("FLOORSMAX_MEDI", nextLine[79].toString());
                        cstmt.setString("FLOORSMIN_MEDI", nextLine[80].toString());
                        cstmt.setString("LANDAREA_MEDI", nextLine[81].toString());
                        cstmt.setString("LIVINGAPARTMENTS_MEDI", nextLine[82].toString());
                        cstmt.setString("LIVINGAREA_MEDI", nextLine[83].toString());
                        cstmt.setString("NONLIVINGAPARTMENTS_MEDI", nextLine[84].toString());
                        cstmt.setString("NONLIVINGAREA_MEDI", nextLine[85].toString());
                        cstmt.setString("FONDKAPREMONT_MODE", nextLine[86].toString());
                        cstmt.setString("HOUSETYPE_MODE", nextLine[87].toString());
                        cstmt.setString("TOTALAREA_MODE", nextLine[88].toString());
                        cstmt.setString("WALLSMATERIAL_MODE", nextLine[89].toString());
                        cstmt.setString("EMERGENCYSTATE_MODE", nextLine[90].toString());
                        cstmt.execute();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
            System.out.println("Terminado Clients Apartments");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    /**
     * *
     * Migration of the Address Client Information of the CSV File.
     *
     * * @param connect The Connection object of the Database
     */
    public void migrationAddressClientInformation(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(application_train))) {
            String[] nextLine;
            reader.skip(1);
            while ((nextLine = reader.readNext()) != null) {
                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertAddressClientInformation(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                    cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[0]));
                    cstmt.setString("REGION_RATING_CLIENT", nextLine[30].toString());
                    cstmt.setString("REGION_RATING_CLIENT_W_CITY", nextLine[31].toString());
                    cstmt.setString("WEEKDAY_APPR_PROCESS_START", nextLine[32].toString());
                    cstmt.setString("HOUR_APPR_PROCESS_START", nextLine[33].toString());
                    cstmt.setString("REG_REGION_NOT_LIVE_REGION", nextLine[34].toString());
                    cstmt.setString("REG_REGION_NOT_WORK_REGION", nextLine[35].toString());
                    cstmt.setString("LIVE_REGION_NOT_WORK_REGION", nextLine[36].toString());
                    cstmt.setString("REG_CITY_NOT_LIVE_CITY", nextLine[37].toString());
                    cstmt.setString("REG_CITY_NOT_WORK_CITY", nextLine[38].toString());
                    cstmt.setString("LIVE_CITY_NOT_WORK_CITY", nextLine[39].toString());
                    cstmt.setString("ORGANIZATION_TYPE", nextLine[40].toString());
                    cstmt.setString("EXT_SOURCE_1", nextLine[41].toString());
                    cstmt.setString("EXT_SOURCE_2", nextLine[42].toString());
                    cstmt.setString("EXT_SOURCE_3", nextLine[43].toString());
                    cstmt.execute();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
            System.out.println("Terminado AddressClientInformation");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    /**
     * *
     * Migration of the FlagDocument of the CSV File.
     *
     * * @param connect The Connection object of the Database
     */
    public void migrationFlagDocument(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(application_train))) {
            String[] nextLine;
            reader.skip(1);
            while ((nextLine = reader.readNext()) != null) {
                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertFlagDocument(?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                    for (int i = 96; i <= 115; i++) {
                        if (nextLine[i].equals("1")) {
                            cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[0]));
                            cstmt.setString("DOCUMENT", nextLine[i].toString());
                            cstmt.execute();
                        }
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }

            }
            System.out.println("Terminado FlagsDocument");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    /**
     * *
     * Migration of the Flags Provided Info of the CSV File.
     *
     * * @param connect The Connection object of the Database
     */
    public void migrationFlagsProvidedInfo(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(application_train))) {
            String[] nextLine;
            reader.skip(1);
            while ((nextLine = reader.readNext()) != null) {
                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertFlagsProvidedInfo(?,?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                    cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[0]));
                    cstmt.setString("FLAG_OWN_CAR", nextLine[4].toString());
                    cstmt.setString("FLAG_OWN_REALTY", nextLine[5].toString());
                    cstmt.setString("FLAG_MOBIL", nextLine[22].toString());
                    cstmt.setString("FLAG_EMP_PHONE", nextLine[23].toString());
                    cstmt.setString("FLAG_WORK_PHONE", nextLine[24].toString());
                    cstmt.setString("FLAG_CONT_MOBILE", nextLine[25].toString());
                    cstmt.setString("FLAG_PHONE", nextLine[26].toString());
                    cstmt.setString("FLAG_EMAIL", nextLine[27].toString());
                    cstmt.execute();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }

            }
            System.out.println("Terminado Flags Provided");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public void migrationAMTREQCredit(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(application_train))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(1);
            while ((nextLine = reader.readNext()) != null) {
                //Use the tokens as required

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertAMT_REQ_CREDIT(?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                    cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[0]));
                    cstmt.setString("BUREAU_HOUR", nextLine[116].toString());
                    cstmt.setString("BUREAU_DAY", nextLine[117].toString());
                    cstmt.setString("BUREAU_WEEK", nextLine[118].toString());
                    cstmt.setString("BUREAU_MON", nextLine[119].toString());
                    cstmt.setString("BUREAU_QRT", nextLine[120].toString());
                    cstmt.setString("BUREAU_YEAR", nextLine[121].toString());

                    cstmt.execute();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }

            }
            System.out.println("Terminado REQ Credit");
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    /*---------------------------------------------------Bureau-------------------------------------------------*/
    public void migrationBureau(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(bureau))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(1);
            int cont = 0;
            while ((nextLine = reader.readNext()) != null) {
                //Use the tokens as required
                cont++;

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertBureau(?,?,?,?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                    cstmt.setInt("SK_ID_BUREAU", Integer.parseInt(nextLine[1]));
                    cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[0]));
                    cstmt.setString("CREDIT_ACTIVE", nextLine[2].toString());
                    cstmt.setString("CREDIT_CURRENCY", nextLine[3].toString());
                    cstmt.setString("DAYS_CREDIT", nextLine[4].toString());
                    cstmt.setString("CREDIT_DAY_OVERDUE", nextLine[5].toString());
                    cstmt.setString("DAYS_CREDIT_ENDDATE", nextLine[6].toString());
                    cstmt.setString("DAYS_ENDDATE_FACT", nextLine[7].toString());
                    cstmt.setString("CNT_CREDIT_PROLONG", nextLine[9].toString());
                    cstmt.setString("CREDIT_TYPE", nextLine[14].toString());
                    cstmt.setString("DAYS_CREDIT_UPDATE", nextLine[15].toString());
                    cstmt.execute();

                } catch (Exception ex) {
                    //JOptionPane.showMessageDialog(null, ex.toString());
                }

            }
            System.out.println(cont);
        } catch (IOException | CsvValidationException e) {
            //e.printStackTrace();
        }
    }

    public void migrationBureauBalance(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(bureau_balance))) {
            String[] nextLine;

            reader.skip(1);

            while ((nextLine = reader.readNext()) != null) {

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertBureauBalance(?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("SK_ID_BUREAU", Integer.parseInt(nextLine[0]));
                    cstmt.setString("MONTHS_BALANCE", nextLine[1].toString());
                    cstmt.setString("STATUS", nextLine[2].toString());

                    cstmt.execute();

                } catch (Exception ex) {

                }

            }

        } catch (IOException | CsvValidationException e) {
            //e.printStackTrace();
        }
    }

    public void migrationAMTCreditDetails(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(bureau))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(1);
            while ((nextLine = reader.readNext()) != null) {
                //Use the tokens as required

                System.out.println(Arrays.toString(nextLine));
                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertAMT_CREDIT(?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("SK_ID_BUREAU", Integer.parseInt(nextLine[1]));
                    cstmt.setString("MAX_OVERDUE", nextLine[8].toString());
                    cstmt.setString("SUM", nextLine[10].toString());
                    cstmt.setString("SUM_DEBT", nextLine[11].toString());
                    cstmt.setString("SUM_LIMIT", nextLine[12].toString());
                    cstmt.setString("SUM_OVERDUE", nextLine[13].toString());
                    cstmt.setString("ANNUITY", nextLine[16].toString());

                    cstmt.execute();

                } catch (Exception ex) {
                    //JOptionPane.showMessageDialog(null, ex.toString());
                }

            }

        } catch (IOException | CsvValidationException e) {
            //e.printStackTrace();
        }
    }

    /*--------------------------------------------Previous App Connections-------------------------------------------------------*/
    public void migrationPreviousApplication(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(previous_application))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(1);

            while ((nextLine = reader.readNext()) != null) {

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertarPreviousApplication(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);

                    cstmt.setInt("SK_ID_PREV", Integer.parseInt(nextLine[0]));
                    cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[1]));
                    cstmt.setString("NAME_CONTRACT_TYPE", nextLine[2].toString());
                    cstmt.setString("WEEKDAY_APPR_PROCESS_START", nextLine[8].toString());
                    cstmt.setString("HOUR_APPR_PROCESS_START", nextLine[9].toString());
                    cstmt.setString("FLAG_LAST_APPL_PER_CONTRACT", nextLine[10].toString());
                    cstmt.setString("NFLAG_LAST_APPL_IN_DAY", nextLine[11].toString());
                    cstmt.setString("RATE_DOWN_PAYMENT", nextLine[12].toString());
                    cstmt.setString("RATE_INTEREST_PRIMARY", nextLine[13].toString());
                    cstmt.setString("RATE_INTEREST_PRIVILEGED", nextLine[14].toString());
                    cstmt.setString("NAME_CASH_LOAN_PURPOSE", nextLine[15].toString());
                    cstmt.setString("NAME_CONTRACT_STATUS", nextLine[16].toString());
                    cstmt.setString("DAYS_DECISION", nextLine[17].toString());
                    cstmt.setString("NAME_PAYMENT_TYPE", nextLine[18].toString());
                    cstmt.setString("CODE_REJECT_REASON", nextLine[19].toString());
                    cstmt.setString("NAME_TYPE_SUITE", nextLine[20].toString());
                    cstmt.setString("NAME_CLIENT_TYPE", nextLine[21].toString());
                    cstmt.setString("NAME_GOODS_CATEGORY", nextLine[22].toString());
                    cstmt.setString("NAME_PORTFOLIO", nextLine[23].toString());
                    cstmt.setString("NAME_PRODUCT_TYPE", nextLine[24].toString());
                    cstmt.setString("CHANNEL_TYPE", nextLine[25].toString());
                    cstmt.setString("SELLERPLACE_AREA", nextLine[26].toString());
                    cstmt.setString("NAME_SELLER_INDUSTRY", nextLine[27].toString());
                    cstmt.setString("CNT_PAYMENT", nextLine[28].toString());
                    cstmt.setString("NAME_YIELD_GROUP", nextLine[29].toString());
                    cstmt.setString("PRODUCT_COMBINATION", nextLine[30].toString());
                    cstmt.setString("DAYS_FIRST_DRAWING", nextLine[31].toString());
                    cstmt.setString("DAYS_FIRST_DUE", nextLine[32].toString());
                    cstmt.setString("DAYS_LAST_DUE_1ST_VERSION", nextLine[33].toString());
                    cstmt.setString("DAYS_LAST_DUE", nextLine[34].toString());
                    cstmt.setString("DAYS_TERMINATION", nextLine[35].toString());
                    cstmt.setString("NFLAG_INSURED_ON_APPROVAL", nextLine[36].toString());

                    cstmt.execute();

                } catch (Exception ex) {
                    //JOptionPane.showMessageDialog(null, ex.toString());

                }

            }

        } catch (IOException | CsvValidationException e) {
            //e.printStackTrace();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------------------------*/
    public void migrationPosCashBalance(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(previous_application))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(1);

            while ((nextLine = reader.readNext()) != null) {
                //Use the tokens as required

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertPosCashBalance(?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("SK_ID_PREV", Integer.parseInt(nextLine[0]));
                    cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[1]));
                    cstmt.setString("MONTHS_BALANCE", nextLine[2].toString());
                    cstmt.setString("CNT_INSTALMENT", nextLine[3].toString());
                    cstmt.setString("CNT_INSTALMENT_FUTURE", nextLine[4].toString());
                    cstmt.setString("NAME_CONTRACT_STATUS", nextLine[5].toString());
                    cstmt.setString("SK_DPD", nextLine[6].toString());
                    cstmt.setString("SK_DPD_DEF", nextLine[7].toString());

                    cstmt.execute();

                } catch (Exception ex) {
                    //JOptionPane.showMessageDialog(null, ex.toString());
                }

            }

        } catch (IOException | CsvValidationException e) {
            //e.printStackTrace();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------------------------*/
    public void migrationInstallmentsPayments(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(this.installments_payments))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(1);

            while ((nextLine = reader.readNext()) != null) {
                //Use the tokens as required

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertInstallmentsPayments(?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("SK_ID_PREV", Integer.parseInt(nextLine[0]));
                    cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[1]));
                    cstmt.setString("NUM_INSTALMENT_VERSION", nextLine[2].toString());
                    cstmt.setString("NUM_INSTALMENT_NUMBER", nextLine[3].toString());
                    cstmt.setString("DAYS_INSTALMENT", nextLine[4].toString());
                    cstmt.setString("DAYS_ENTRY_PAYMENT", nextLine[5].toString());
                    cstmt.setString("AMT_INSTALMENT", nextLine[6].toString());
                    cstmt.setString("AMT_PAYMENT", nextLine[7].toString());

                    cstmt.execute();

                } catch (Exception ex) {
                    //JOptionPane.showMessageDialog(null, ex.toString());
                }

            }

        } catch (IOException | CsvValidationException e) {
            // e.printStackTrace();
        }
    }


    /*---------------------------------------------------------------------------------------------------------------------------------*/
    public void migrationAMT_PREVIOUS_DETAILS(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(this.previous_application))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(1);

            while ((nextLine = reader.readNext()) != null) {
                //Use the tokens as required

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertAMT_PREVIOUS_DETAILS(?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("SK_ID_PREV", Integer.parseInt(nextLine[0]));
                    cstmt.setString("AMT_ANNUITY", nextLine[3].toString());
                    cstmt.setString("AMT_APPLICATION", nextLine[4].toString());
                    cstmt.setString("AMT_CREDIT", nextLine[5].toString());
                    cstmt.setString("AMT_DOWN_PAYMENT", nextLine[6].toString());
                    cstmt.setString("AMT_GOODS_PRICE", nextLine[7].toString());

                    cstmt.execute();

                } catch (Exception ex) {
                    // JOptionPane.showMessageDialog(null, ex.toString());
                }

            }

        } catch (IOException | CsvValidationException e) {
            //e.printStackTrace();
        }
    }

    /*---------------------------------------------------------------------------------------------------------------------------------*/
    public void migrationCreditCardBalance(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(this.credit_card_balance))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(1);
            int cont = 1;
            while ((nextLine = reader.readNext()) != null) {
                //Use the tokens as required

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertCreditCardBalance(?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("ID_CCB", cont);
                    cstmt.setInt("SK_ID_PREV", Integer.parseInt(nextLine[0]));
                    cstmt.setInt("SK_ID_CURR", Integer.parseInt(nextLine[1]));
                    cstmt.setString("MONTHS_BALANCE", nextLine[2].toString());
                    cstmt.setString("NAME_CONTRACT_STATUS", nextLine[20].toString());
                    cstmt.setString("SK_DPD", nextLine[21].toString());
                    cstmt.setString("SK_DPD_DEF", nextLine[22].toString());

                    cstmt.execute();
                    cont++;

                } catch (Exception ex) {
                    // JOptionPane.showMessageDialog(null, ex.toString());
                }

            }

        } catch (IOException | CsvValidationException e) {
            // e.printStackTrace();
        }
    }

    public void migrationAMT_BALANCE_DETAILS(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(this.credit_card_balance))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(1);
            int contador = 1;
            while ((nextLine = reader.readNext()) != null) {
                //Use the tokens as required

                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertAMT_BALANCE_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("ID_CCB", contador);
                    cstmt.setString("BALANCE", nextLine[3].toString());
                    cstmt.setString("CREDIT_LIMIT_ACTUAL", nextLine[4].toString());
                    cstmt.setString("DRAWINGS_ATM_CURRENT", nextLine[5].toString());
                    cstmt.setString("DRAWINGS_CURRENT", nextLine[6].toString());
                    cstmt.setString("DRAWINGS_OTHER_CURRENT", nextLine[7].toString());
                    cstmt.setString("DRAWINGS_POS_CURRENT", nextLine[8].toString());
                    cstmt.setString("INST_MIN_REGULARITY", nextLine[9].toString());
                    cstmt.setString("PAYMENT_CURRENT", nextLine[10].toString());
                    cstmt.setString("PAYMENT_TOTAL_CURRENT", nextLine[11].toString());
                    cstmt.setString("RECEIVABLE_PRINCIPAL", nextLine[12].toString());
                    cstmt.setString("RECIVABLE", nextLine[13].toString());
                    cstmt.setString("TOTAL_RECEIVABLE", nextLine[14].toString());

                    cstmt.execute();
                    contador++;

                } catch (Exception ex) {
                    //JOptionPane.showMessageDialog(null, ex.toString());
                }

            }

        } catch (IOException | CsvValidationException e) {
            //e.printStackTrace();
        }
    }

    public void migrationCNTBalanceDetails(Conn connect) {

        CallableStatement cstmt = null;
        try (
                 CSVReader reader = new CSVReader(new FileReader(this.credit_card_balance))) {
            String[] nextLine;
            //Read one line at a time
            reader.skip(2354994);
            int conta = 2354994;
            while ((nextLine = reader.readNext()) != null) {
                //Use the tokens as required

                System.out.println(conta);
                try {
                    cstmt = connect.obtainConnection().prepareCall(
                            "{call dbo.SPInsertCNTBalanceDetails(?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("ID_CCB", conta);
                    cstmt.setString("DRAWINGS_ATM_CURRENT", nextLine[15].toString());
                    cstmt.setString("DRAWINGS_CURRENT", nextLine[16].toString());
                    cstmt.setString("DRAWINGS_OTHER_CURRENT", nextLine[17].toString());
                    cstmt.setString("DRAWINGS_POS_CURRENT", nextLine[18].toString());
                    cstmt.setString("INSTALMENT_MATURE_CUM", nextLine[19].toString());

                    cstmt.execute();
                    conta++;

                } catch (Exception ex) {
                    //JOptionPane.showMessageDialog(null, ex.toString());
                }

            }

        } catch (IOException | CsvValidationException e) {
            //e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Conn conex = new Conn();
        Migrator m1 = new Migrator();

        //m1.migrationAplicationTrain(conex);
        //m1.migrationClientApartments(conex);
        //m1.migrationAddressClientInformation(conex);
        //m1.migrationFlagDocument(conex);
        //m1.migrationFlagsProvidedInfo(conex);
        //m1.migrationAMTREQCredit(conex);
        //m1.migrationBureau(conex);
        //m1.migrationBureauBalance(conex);
        //m1.migrationAMTCreditDetails(conex);
        //m1.migrationPreviousApplication(conex);
        //m1.migrationPosCashBalance(conex);
        //m1.migrationInstallmentsPayments(conex);
        //m1.migrationAMT_PREVIOUS_DETAILS(conex);
        //m1.migrationCreditCardBalance(conex); 
        //m1.migrationAMT_BALANCE_DETAILS(conex);
        //m1.migrationCNTBalanceDetails(conex);
        /*-------------------------------------Faltan------------------------*/
    }

}
