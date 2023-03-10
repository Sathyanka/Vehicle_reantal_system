/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
import java.sql.*;
public class SQLCON {
    public static Connection connect()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details","root","");
            return conn;
        }
        catch(Exception e)
        {
            return null;
        }
        
    }
    
}

    

