
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
        
        //Creamos una lista y un builder nuevo que lea de la base de datos, para no borrar nada
        ArrayList<Person1> person = PersonLoader.read();
        HistogramBuilder<Person1> builder1 = new HistogramBuilder<>(person);
        
        //En este caso la A es tipo String porque son los emails
        Histogram<String> domains1 = builder1.build(new Attribute<Person1, String>() {

            @Override
            public String get(Person1 item) {
                return item.getMail().split("@")[1];
            }
        });
        
        //En este caso la A es tipo Float porque son los pesos
        Histogram<Float> pesos = builder1.build(new Attribute<Person1, Float>() {

            @Override
            public Float get(Person1 item) {
                return item.getPeso();
            }
        });
        
        
        //En este caso la A es tipo Character porque son los generos y nos quedmaos con 
        //la primera letra. Eso es suficiente
        Histogram<Character> generos = builder1.build(new Attribute<Person1, Character>() {

            @Override
            public Character get(Person1 item) {
                return item.getGenero().charAt(0);
            }
        });
        
        
        
        new HistogramDisplay(domains, "DOMINIOS").execute();
        new HistogramDisplay(letters, "CARACTER").execute();
        new HistogramDisplay(domains1, "DOMINIOS").execute();
        new HistogramDisplay(pesos, "PESOS").execute();
        new HistogramDisplay(generos, "GENEROS").execute();
    }
}
