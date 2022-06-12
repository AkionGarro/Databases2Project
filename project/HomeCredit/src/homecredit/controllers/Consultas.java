/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package homecredit.controllers;

import com.opencsv.exceptions.CsvValidationException;
import homecredit.dbConnection.Conn;
import java.awt.List;
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author garroakion
 */
public class Consultas {

    public void getAllLoans(Conn connect, JList loansList, String incomeType, String Active, String ContractType, Integer total) throws SQLException {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = connect.obtainConnection().prepareCall(
                    "{call dbo.SPGetAllLoans(?,?,?,?)}",
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            cstmt.setString("inputIncome", incomeType);
            cstmt.setString("inputActive", Active);
            cstmt.setString("inputContract", ContractType);
            cstmt.setInt("inputTotal", total);
            cstmt.execute();
            rs = cstmt.getResultSet();
            //SK_ID_CURR,AMT_INCOME_TOTAL,NAME_FAMILY_STATUS,DAYS_EMPLOYED

            DefaultListModel model = new DefaultListModel();
            loansList.setModel(model);

            while (rs.next()) {
                String value
                        = "ID: " + rs.getInt("SK_ID_CURR") +"\n"
                        + "Contract Type: " + rs.getInt("NAME_CONTRACT_TYPE")+"\n"
                        + "Income: " + rs.getString("AMT_INCOME_TOTAL")+"\n"
                        + "Income Type: " + rs.getString("NAME_INCOME TYPE")+"\n"
                        + "Credit Active: " + rs.getString("CREDIT_ACTIVE")+"\n"
                        + "Months Balance: " + rs.getString("MONTHS_BALANCE")+"\n";
                model.addElement(value);

            }

        } catch (Exception ex) {

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {

                }
            }
        }
        if (cstmt != null) {
            try {
                cstmt.close();
            } catch (SQLException ex) {

            }

        }
    }

}
