/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mypanels;

import java.sql.*;

/**
 *
 * @author Lasanga
 */
public class SQLite {
    private static Connection conn =null;
    private static boolean hasData = false;
    
    public static Connection ConnectSqlite(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:comsecurity.db");
            initialise();
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    
    }

    private static void initialise() throws SQLException {
        if (!hasData){
            hasData=true;
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='Login'");
            if(!rs.next()){
                Statement state2 = conn.createStatement();
                state2.execute("CREATE TABLE Login (first_name varchar(60), last_name varchar(60), username varchar(60), password varchar(60), keystroke varchar(100))");
                
            }
            
        }
    }
    
}
