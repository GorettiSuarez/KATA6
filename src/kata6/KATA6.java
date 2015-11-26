
package kata6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KATA6 {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        
        String nameFile = "C:\\Users\\Goretti\\Documents\\NetBeansProjects\\KATA6\\DATA\\emailsfilev1.txt";
        ArrayList<Person> mailArray = MailListReader.read(nameFile);
        
        HistogramBuilder <Person> builder = new HistogramBuilder<>(mailArray);
        
        //Se realizaran dos histogramas: 1 de tipo string y otro de character
        
        Histogram<String> domains = builder.build(new Attribute<Person, String>() {

            @Override
            //Aqui si hace falta cambiar el tipo generico a String para definirlo.
            //Aqui se está implementando la interface.
            public String get(Person item) {
                return item.getMail().split("@")[1];
            }
        });
        
        Histogram<Character> letters = builder.build(new Attribute<Person, Character>() {

            @Override
            //Aqui si hace falta cambiar el tipo generico a String para definirlo.
            //Aqui se está implementando la interface.
            public Character get(Person item) {
                return item.getMail().charAt(0);
            }
        });
        
        new HistogramDisplay(domains, "DOMINIOS").execute();
        new HistogramDisplay(letters, "CARACTER").execute();
    }
}
