/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel.db;

import java.sql.*;

/**
 *
 * @author harshit
 */
public class dbconnect {

    public String query;

    public dbconnect(String query) {
        this.query = query;
    }

    public ResultSet exquery() {
        System.out.println("In dbconnect");
        ResultSet res = null;


        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.out.println("Exception in driver");
            e.printStackTrace();
        }
        try {
            String url = "jdbc:postgresql://localhost/postgres";

            String dbusername = "postgres";
            String dbpasswd = "password";
            Connection conn = DriverManager.getConnection(url, dbusername, dbpasswd);
            Statement st = conn.createStatement();
            res = st.executeQuery(query);
            
        } catch (SQLException e) {
            System.out.println("SQL Exception thrown (exquery)");
        }

        //catch(ClassNotFoundException e)
        //{
        //  System.out.println("Class not found exception thrown (exquery)");
        //}
        return res;
        
    }

    public void insquery() {
        try {
            System.out.println("Inside insquery");
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String dbusername = "postgres";
            String dbpasswd = "password";
            Connection conn = DriverManager.getConnection(url, dbusername, dbpasswd);
            System.out.println("Connection created in insquery");
            Statement st = conn.createStatement();
            System.out.println("Statement created in insquery");
            int res = st.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("SQL Exception thrown");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception thrown (insquery)");
        }

    }
}
