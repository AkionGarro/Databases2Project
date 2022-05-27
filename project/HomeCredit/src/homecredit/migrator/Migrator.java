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

        /*SPInsertApplication_train(
            @SK_ID_CURR [0]
           ,@TARGET [1]
           ,@NAME_CONTRACT_TYPE [2]
           ,@CODE_GENDER [3]
           ,@CNT_CHILDREN [6]
           ,@AMT_INCOME_TOTAL [7]
           ,@AMT_CREDIT     [8]
           ,@AMT_ANNUITY    [9]
           ,@AMT_GOODS_PRICE  [10]
           ,@NAME_TYPE_SUITE  [11]
           ,@NAME_INCOME_TYPE  [12]
           ,@NAME_EDUCATION_TYPE  [13]
           ,@NAME_FAMILY_STATUS  [14]
           ,@NAME_HOUSING_TYPE  [15]
           ,@REGION_POPULATION_RELATIVE  [16]
           ,@DAYS_BIRTH  [17]
           ,@DAYS_EMPLOYED  [18]
           ,@DAYS_REGISTRATION   [19]
           ,@DAYS_ID_PUBLISH  [20]
           ,@OWN_CAR_AGE  [21]
           ,@OCCUPATION_TYPE  [28]
           ,@CNT_FAM_MEMBERS  [29]
           ,@OBS_30_CNT_SOCIAL_CIRCLE  [91]
           ,@DEF_30_CNT_SOCIAL_CIRCLE  [92]
           ,@OBS_60_CNT_SOCIAL_CIRCLE  [93]
           ,@DEF_60_CNT_SOCIAL_CIRCLE  [94]
           ,@DAYS_LAST_PHONE_CHANGE)   [95]
        
         */
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

        /*SPInsertClientApartmentsDetails(
            @SK_ID_CURR                         [0]
           ,@APARTMENTS_AVG                     [44]
           ,@BASEMENTAREA_AVG                   [45]
           ,@YEARS_BEGINEXPLUATATION_AVG        [46]
           ,@YEARS_BUILD_AVG                    [47]
           ,@COMMONAREA_AVG                     [48]
           ,@ELEVATORS_AVG                      [49]
           ,@ENTRANCES_AVG                      [50]
           ,@FLOORSMAX_AVG                      [51]
           ,@FLOORSMIN_AVG                      [52]
           ,@LANDAREA_AVG                       [53]
           ,@LIVINGAPARTMENTS_AVG               [54]
           ,@LIVINGAREA_AVG                     [55]
           ,@NONLIVINGAPARTMENTS_AVG            [56]
           ,@NONLIVINGAREA_AVG                  [57]
           ,@APARTMENTS_MODE                    [58]
           ,@BASEMENTAREA_MODE                  [59]
           ,@YEARS_BEGINEXPLUATATION_MODE       [60]
           ,@YEARS_BUILD_MODE                   [61]
           ,@COMMONAREA_MODE                    [62]    
           ,@ELEVATORS_MODE                     [63]
           ,@ENTRANCES_MODE                     [64]
           ,@FLOORSMAX_MODE                     [65]
           ,@FLOORSMIN_MODE                     [66]
           ,@LANDAREA_MODE                      [67]
           ,@LIVINGAPARTMENTS_MODE              [68] 
           ,@LIVINGAREA_MODE                    [69]   
           ,@NONLIVINGAPARTMENTS_MODE           [70]
           ,@NONLIVINGAREA_MODE                 [71]
           ,@APARTMENTS_MEDI                    [72]
           ,@BASEMENTAREA_MEDI                  [73]
           ,@YEARS_BEGINEXPLUATATION_MEDI       [74]
           ,@YEARS_BUILD_MEDI                   [75]
           ,@COMMONAREA_MEDI                    [76]
           ,@ELEVATORS_MEDI                     [77]
           ,@ENTRANCES_MEDI                     [78]
           ,@FLOORSMAX_MEDI                     [79]
           ,@FLOORSMIN_MEDI                     [80]
           ,@LANDAREA_MEDI                      [81]
           ,@LIVINGAPARTMENTS_MEDI              [82]
           ,@LIVINGAREA_MEDI                    [83]
           ,@NONLIVINGAPARTMENTS_MEDI           [84]
           ,@NONLIVINGAREA_MEDI                 [85]
           ,@FONDKAPREMONT_MODE                 [86]
           ,@HOUSETYPE_MODE                     [87]
           ,@TOTALAREA_MODE                     [88]
           ,@WALLSMATERIAL_MODE                 [89]
           ,@EMERGENCYSTATE_MODE)               [90]
        
         */
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

        /*
    SPInsertAddressClientInformation(
           ,@SK_ID_CURR
           ,@REGION_RATING_CLIENT
           ,@REGION_RATING_CLIENT_W_CITY
           ,@WEEKDAY_APPR_PROCESS_START
           ,@HOUR_APPR_PROCESS_START
           ,@REG_REGION_NOT_LIVE_REGION
           ,@REG_REGION_NOT_WORK_REGION
           ,@LIVE_REGION_NOT_WORK_REGION
           ,@REG_CITY_NOT_LIVE_CITY
           ,@REG_CITY_NOT_WORK_CITY
           ,@LIVE_CITY_NOT_WORK_CITY
           ,@ORGANIZATION_TYPE
           ,@EXT_SOURCE_1
           ,@EXT_SOURCE_2
           ,@EXT_SOURCE_3)
         */
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

        /*
        SPInsertFlagDocument(@SK_ID_CURR, @DOCUMENT)
        96: "FLAG_DOCUMENT_2"
        97: "FLAG_DOCUMENT_3"
        98: "FLAG_DOCUMENT_4"
        99: "FLAG_DOCUMENT_5"
        100: "FLAG_DOCUMENT_6"
        101: "FLAG_DOCUMENT_7"
        102: "FLAG_DOCUMENT_8"
        103: "FLAG_DOCUMENT_9"
        104: "FLAG_DOCUMENT_10"
        105: "FLAG_DOCUMENT_11"
        106: "FLAG_DOCUMENT_12"
        107: "FLAG_DOCUMENT_13"
        108: "FLAG_DOCUMENT_14"
        109: "FLAG_DOCUMENT_15"
        110: "FLAG_DOCUMENT_16"
        111: "FLAG_DOCUMENT_17"
        112: "FLAG_DOCUMENT_18"
        113: "FLAG_DOCUMENT_19"
        114: "FLAG_DOCUMENT_20"
        115: "FLAG_DOCUMENT_21"
         */
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

        /*
        SPInsertFlagsProvidedInfo( 
        @SK_ID_CURR, 
        @FLAG_OWN_CAR, [4]
        @FLAG_OWN_REALTY,  [5]
	@FLAG_MOBIL,  [22]
        @FLAG_EMP_PHONE,  [23]
        @FLAG_WORK_PHONE,    [24]
	@FLAG_CONT_MOBILE,    [25]
        @FLAG_PHONE,     [26]
        @FLAG_EMAIL)   [27]
            
         */
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

        /*
        SPInsertFlagsProvidedInfo(
            
            SPInsertAMT_REQ_CREDIT(
            @SK_ID_CURR
           ,@BUREAU_HOUR
           ,@BUREAU_DAY
           ,@BUREAU_WEEK
           ,@BUREAU_MON
           ,@BUREAU_QRT
           ,@BUREAU_YEAR)
            
         */
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

        /*
            SPInsertBureau 
            @SK_ID_BUREAU VARCHAR(50)
           ,@SK_ID_CURR VARCHAR(50)
           ,@CREDIT_ACTIVE VARCHAR(50)
           ,@CREDIT_CURRENCY VARCHAR(50)
           ,@DAYS_CREDIT VARCHAR(50)
           ,@CREDIT_DAY_OVERDUE VARCHAR(50)
           ,@DAYS_CREDIT_ENDDATE VARCHAR(50)
           ,@DAYS_ENDDATE_FACT VARCHAR(50)
           ,@CNT_CREDIT_PROLONG VARCHAR(50)
           ,@CREDIT_TYPE VARCHAR(50)
           ,@DAYS_CREDIT_UPDATE VARCHAR(50)
            
         */
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

        /*
            SPInsertBureauBalance(
            @SK_ID_BUREAU
           ,@MONTHS_BALANCE
           ,@STATUS)

            
         */
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

        /*
            SPInsertAMT_CREDIT(
            @SK_ID_BUREAU
           ,@MAX_OVERDUE
           ,@SUM
           ,@SUM_DEBT
           ,@SUM_LIMIT
           ,@SUM_OVERDUE
           ,@ANNUITY)
            
         */
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
        /*
    SPInsertarPreviousApplication(
        @SK_ID_PREV, 
        @SK_ID_CURR, 
        @NAME_CONTRACT_TYPE, 
	@WEEKDAY_APPR_PROCESS_START, 
        @HOUR_APPR_PROCESS_START, 
	@FLAG_LAST_APPL_PER_CONTRACT, 
        @NFLAG_LAST_APPL_IN_DAY,
	@RATE_DOWN_PAYMENT, 
        @RATE_INTEREST_PRIMARY, 
        @RATE_INTEREST_PRIVILEGED,
	@NAME_CASH_LOAN_PURPOSE, 
        @NAME_CONTRACT_STATUS, 
        @DAYS_DECISION, 
	@NAME_PAYMENT_TYPE, 
        @CODE_REJECT_REASON, 
        @NAME_TYPE_SUITE,
	@NAME_CLIENT_TYPE, 
        @NAME_GOODS_CATEGORY, 
        @NAME_PORTFOLIO, 
	@NAME_PRODUCT_TYPE, 
        @CHANNEL_TYPE, 
        @SELLERPLACE_AREA, 
	@NAME_SELLER_INDUSTRY, 
        @CNT_PAYMENT, 
        @NAME_YIELD_GROUP, 
	@PRODUCT_COMBINATION, 
        @DAYS_FIRST_DRAWING, 
        @DAYS_FIRST_DUE, 
	@DAYS_LAST_DUE_1ST_VERSION, 
        @DAYS_LAST_DUE, 
        @DAYS_TERMINATION, 
	@NFLAG_INSURED_ON_APPROVAL)
        
         */
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

        /*
    SPInsertPosCashBalance(
            @SK_ID_PREV
           ,@SK_ID_CURR
           ,@MONTHS_BALANCE
           ,@CNT_INSTALMENT
           ,@CNT_INSTALMENT_FUTURE
           ,@NAME_CONTRACT_STATUS
           ,@SK_DPD
           ,@SK_DPD_DEF)
            
         */
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

        /*
                SPInsertInstallmentsPayments(
                 @SK_ID_PREV, 
                 @SK_ID_CURR, 
                 @NUM_INSTALMENT_VERSION, 
                 @NUM_INSTALMENT_NUMBER, 
                 @DAYS_INSTALMENT, 
                 @DAYS_ENTRY_PAYMENT, 
                 @AMT_INSTALMENT, 
                 @AMT_PAYMENT)   
            
         */
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

        /*
            SPInsertAMT_PREVIOUS_DETAILS(
            @SK_ID_PREV
           ,@AMT_ANNUITY
           ,@AMT_APPLICATION
           ,@AMT_CREDIT
           ,@AMT_DOWN_PAYMENT
           ,@AMT_GOODS_PRICE)
            
         */
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

        /*
            SPInsertCreditCardBalance(
                    @ID_CCB, 
                    @SK_ID_PREV, 
                    @SK_ID_CURR, 
                    @MONTHS_BALANCE,
                    @NAME_CONTRACT_STATUS, 
                    @SK_DPD, 
                    @SK_DPD_DEF)
            
         */
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

        /*
            SPInsertAMT_BALANCE_DETAILS(
            @ID_CCB
            , @BALANCE
            , @CREDIT_LIMIT_ACTUAL
            , @DRAWINGS_ATM_CURRENT
            , @DRAWINGS_CURRENT
            , @DRAWINGS_OTHER_CURRENT
            , @DRAWINGS_POS_CURRENT
            , @INST_MIN_REGULARITY
            , @PAYMENT_CURRENT
            , @PAYMENT_TOTAL_CURRENT
            , @RECEIVABLE_PRINCIPAL
            , @RECIVABLE
            , @TOTAL_RECEIVABLE

    )
            
         */
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
                            "{call dbo.SPInsertAMT_BALANCE_DETAILS(?,?,?,?,?,?,?,?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("ID_CCB", cont);
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
                    cont++;

                } catch (Exception ex) {
                    // JOptionPane.showMessageDialog(null, ex.toString());
                }

            }

        } catch (IOException | CsvValidationException e) {
            // e.printStackTrace();
        }
    }

    public void migrationCNTBalanceDetails(Conn connect) {

        /*
            SPInsertCNTBalanceDetails(
            @ID_CCB
            @DRAWINGS_ATM_CURRENT , 
            @DRAWINGS_CURRENT ,
            @DRAWINGS_OTHER_CURRENT ,
            @DRAWINGS_POS_CURRENT ,
            @INSTALMENT_MATURE_CUM

    )

    )
            
         */
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
                            "{call dbo.SPInsertCNTBalanceDetails(?,?,?,?,?,?)}",
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_READ_ONLY);
                    cstmt.setInt("ID_CCB", cont);
                    cstmt.setString("BALANCE", nextLine[15].toString());
                    cstmt.setString("CREDIT_LIMIT_ACTUAL", nextLine[16].toString());
                    cstmt.setString("DRAWINGS_ATM_CURRENT", nextLine[17].toString());
                    cstmt.setString("DRAWINGS_CURRENT", nextLine[18].toString());
                    cstmt.setString("DRAWINGS_OTHER_CURRENT", nextLine[19].toString());

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
        /*-------------------------------------Faltan------------------------*/
        m1.migrationCreditCardBalance(conex); 
        m1.migrationAMT_BALANCE_DETAILS(conex);
        m1.migrationCNTBalanceDetails(conex);
    }

}
