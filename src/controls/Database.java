package controls;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WK
 */
public class Database {

    private static Connection con;

    static {
        try {
            con = getCon();
        } catch (Exception ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getCon() throws Exception {
        Statement st;
        Properties prop = new Properties();
        prop.load(new FileInputStream("config.properties"));
        String host = prop.getProperty("localhost");
        String database_name = prop.getProperty("customer_details");
        String database_user = prop.getProperty("root");
        String database_password = prop.getProperty("");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details","root","");

        st = con.createStatement();
//        System.err.println("Success :");
        return con;
    }

//Exception has caught
    public static boolean putData(String sql) {
        boolean added = false;
        try {
            PreparedStatement state = con.prepareStatement(sql);
            state.executeUpdate();
            added = true;
        } catch (Exception e) {
            String msg = e.getMessage();
            e.printStackTrace();
            System.err.println(msg);
            if (msg.startsWith("Cannot delete or update a parent row: a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(null, "Cannot delete or update data. Sub entries exists under this record", "Cannot Proceed", JOptionPane.WARNING_MESSAGE);
            } else {
                System.err.println(e.getMessage());
            }

        }
        return added;
    }

    //getData method will return a resultset
    //Exception has thrown
    public static ResultSet getData(String sql) throws Exception {
        Statement state = con.createStatement();
        ResultSet rset = state.executeQuery(sql);
        return rset;
    }

    public static boolean isExist(String sql) throws Exception {
        boolean Exist = false;
        Statement state = con.createStatement();
        ResultSet rset = state.executeQuery(sql);
        if (rset.next()) {
            Exist = true;
        }
        return Exist;
    }
}
