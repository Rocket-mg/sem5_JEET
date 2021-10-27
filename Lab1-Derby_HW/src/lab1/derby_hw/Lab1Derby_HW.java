package lab1.derby_hw;

/**
 *
 * @author MG
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab1Derby_HW {

        public static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
        public static final String JDBC_URL="jdbc:derby:./db/Rocket-mg_db"; 
        public static final String QUERY="select * from app.sculptures";
        private static java.sql.Connection conn;

        private Lab1Derby_HW() {}
        
        public static boolean Connect() throws ClassNotFoundException, SQLException {
            conn = DriverManager.getConnection(JDBC_URL);
            return conn != null;
        }
        public static boolean Disconnect() throws SQLException {
            if (conn == null) {
            return false;
            } else {
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
            //int colCount = 40;
            for (int i = 1; i <= colCount; i++) {
                wiersz = wiersz.concat(rsmd.getColumnName(i) + " \t| ");
                }
            wiersz = wiersz.concat("\r\n");
            while (rs.next()) {
                System.out.println("");
                for (int i = 1; i <= colCount; i++) {
                wiersz = wiersz.concat(rs.getString(i) + " \t| ");
                }
                wiersz = wiersz.concat("\r\n");
                }
            if (stat != null) { stat.close(); } return wiersz; 
        } 
            
        public static int getDatapom() throws SQLException {
            Statement stat = conn.createStatement();
            String query2 = "SELECT sculpture_id FROM app.sculptures ORDER BY sculpture_id DESC fetch first 1 rows only";
            ResultSet rs = stat.executeQuery(QUERY);
            ResultSetMetaData rsmd = rs.getMetaData();
            String wiersz = new String();
            int x = 0;
            int colCount = rsmd.getColumnCount();
            while (rs.next()) {
                x = x + 1;  
                }
            return x; 
        }
        
        public static String Insert(String queryinsert) throws SQLException {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(queryinsert);
            rs = stat.executeQuery(QUERY);
            ResultSetMetaData rsmd = rs.getMetaData();
            String wiersz = new String();
            int colCount = rsmd.getColumnCount();
            //int colCount = 40;
            for (int i = 1; i <= colCount; i++) {
                wiersz = wiersz.concat(rsmd.getColumnName(i) + " \t| ");
                }
            wiersz = wiersz.concat("\r\n");
            while (rs.next()) {
                System.out.println("");
                for (int i = 1; i <= colCount; i++) {
                wiersz = wiersz.concat(rs.getString(i) + " \t| ");
                }
                wiersz = wiersz.concat("\r\n");
                }
            if (stat != null) { stat.close(); } return wiersz; 
        }
        
        public static void main(String[] args) throws ClassNotFoundException, SQLException {
        java.sql.Connection conn=DriverManager.getConnection(JDBC_URL);
        System.out.println("Połączono");

        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(QUERY);
        ResultSetMetaData rsmd = rs.getMetaData();

        int colCount = rsmd.getColumnCount();

        for(int i=1; i<= colCount; i++)
        System.out.print(rsmd.getColumnName(i)+ " | ");

        while (rs.next()){
        System.out.println("");
        for (int i=1;i<=colCount;i++)
        System.out.print(rs.getString(i)+ " \t| ");

        }
        if (stat!=null) stat.close();
        if (conn!=null) conn.close();
        System.out.println("\nRozłączono");
        }
}
