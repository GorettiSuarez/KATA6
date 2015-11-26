
package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KATA6 {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        
        String nameFile = "C:\\Users\\Goretti\\Documents\\NetBeansProjects\\KATA6\\DATA\\emailsfilev1.txt";
        ArrayList<String> mailArray = MailListReader.read(nameFile);

        //ArrayList<String> mailArray = MailListReaderDDBB.read();
        //System.out.println(mailArray.size());
        
        Histogram<String> histogram = MailHistogramBuilder.buil(mailArray);
        
        
        new HistogramDisplay(histogram).execute();
    }
}
