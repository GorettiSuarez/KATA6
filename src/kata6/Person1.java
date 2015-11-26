package kata6;


/**
 *
 * @author Goretti
 */
public class Person1 {
    //Se ponen los campos que se vayan a usar de la base de datos, en este ejemplo
    //se usan los 6
    
    private final Integer id;
    private final String name;
    private final String genero;
    private final String FechaNacimiento;
    private final Float peso;
    private final String mail;
    
    public Person1(Integer id, String name, String genero, String FechaNacimiento, Float peso, String mail) {
        this.id = id;
        this.name = name;
        this.genero = genero;
        this.FechaNacimiento = FechaNacimiento;
        this.peso = peso;
        this.mail = mail;
    }
    
    //Solo creamos estos 3 getters porque solo usaremos esos
    public String getGenero() {
        return genero;
    }

    public Float getPeso() {
        return peso;
    }

    public String getMail() {
        return mail;
    }

}
