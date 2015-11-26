package kata6;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Goretti
 */
public class MailListReaderDDBB {
    
    public static ArrayList<String> read () throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:KATADB");
        Statement stmt = c.createStatement();

        ArrayList<String> mailList = new ArrayList<>();
        ResultSet rs = stmt.executeQuery("SELECT MAIL FROM MAILS");
        
        while(rs.next()){
            mailList.add(rs.getString("MAIL"));
        }
        
        rs.close();
        stmt.close();
        c.close();
        return mailList;
    }
}
