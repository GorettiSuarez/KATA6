package kata6;

import java.util.ArrayList;

/**
 * Clase generica con método generico que añade elementos al histograma
 * @author Goretti
 */
public class HistogramBuilder <T> {
    private final ArrayList<T> lista;

    public HistogramBuilder(ArrayList<T> lista) {
        this.lista = lista;
    }
    
    public <A> Histogram <A> build (Attribute <T,A> attribute){
        //T es el dato, y A el tiempo de dato. Por ejemplo : email,string / id,int
        Histogram<A> histo = new Histogram<>();
        for (T lista1 : lista){
            A value = attribute.get(lista1);
            histo.increment(value);
            
        }
        return histo;
    }
}
