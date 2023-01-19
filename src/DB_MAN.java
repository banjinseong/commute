
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class DB_MAN {
    String strDriver = "com.mysql.cj.jdbc.Driver";
    String strURL = "jdbc:mysql://localhost:3306/USER?useUnicode=true&serverTimezone=UTC";
    //String strURL = "jdbc:oracle:thin:localhost1521:";
    String strUser = "root";
    String strPWD = "rootpw";
    
    Connection DB_con;
    Statement DB_stmt;
    ResultSet DB_rs;
    
    public void dbOpen() throws IOException {
    try{
     Class.forName(strDriver);
     
     DB_con = DriverManager.getConnection(strURL, strUser, strPWD);
     DB_stmt = DB_con.createStatement();
    }catch(Exception e){
        System.out.println("SQLExceptionopen : " + e.getMessage());
    }
}
    public void dbClose() throws IOException {
        try{
            DB_stmt.close();
            DB_con.close();
        }catch(SQLException e){
            System.out.println("SQLException :sss " + e.getMessage());
        }
    }
}
