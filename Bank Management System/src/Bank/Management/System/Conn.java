package Bank.Management.System;

import java.sql.*;
import java.lang.*;
public class Conn {
    Connection c;
    Statement s;
   public Conn() {
       try {
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection("jdbc:sqlite:bankmanagementsystem.db");
           s = c.createStatement();

       } catch (Exception e) {
           System.out.println(e);
       }
   }
}
