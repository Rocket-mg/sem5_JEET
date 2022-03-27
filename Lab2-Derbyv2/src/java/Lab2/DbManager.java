/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author student
 */
public class DbManager {
    
    /*
    private boolean polaczenie = false;
    private String data;
    private String getDataFromDb() {
        try {
        polaczenie = Lab2.Dane.DbManager.Connect();
        if (polaczenie) {
            data = Lab2.Dane.DbManager.getData();
            polaczenie = Lab2.Dane.DbManager.Disconnect();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Wypisywanie.class.getName()).log(Level.SEVERE, null, ex);
    }return data;
    }
    */
    public static final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    public static final String JDBC_URL = "jdbc:derby://localhost:1527/ludzie";
    public static final String QUERY = "select * from APP.PRACOWNICY";
    private static java.sql.Connection conn;
    private DbManager() {    }
    public static boolean Connect() throws ClassNotFoundException, SQLException {

        conn = DriverManager.getConnection(JDBC_URL);
        if (conn == null) 
        {
            return false;
        }
        else {
            return true;
        }
    }
    public static boolean Disconnect() throws SQLException {
        if (conn == null) {
            return false;
        }
        else { 
            conn.close();
            return true;
        }    
    }
    public static String getData() throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(QUERY);
        ResultSetMetaData rsmd = rs.getMetaData();
        String wiersz = new String();
        
        int colCount = rsmd.getColumnCount();
        wiersz = wiersz.concat("<table><tr>");
        
        for (int i = 1; i <= colCount; i++) {
            wiersz = wiersz.concat(" <td><b> " + rsmd.getColumnName(i) + "</b></td> ");
        }
        wiersz = wiersz.concat("</tr>");
        
        while (rs.next()) {
            wiersz = wiersz.concat("<tr>");
            //System.out.println("");
            for (int i = 1; i <= colCount; i++) {
                wiersz = wiersz.concat(" <td> " + rs.getString(i) + " </td> ");
            }
            wiersz = wiersz.concat("</tr>");
        }
        wiersz = wiersz.concat("</table>");
        if (stat != null) {
            stat.close();
        }
        return wiersz;
    }
}
