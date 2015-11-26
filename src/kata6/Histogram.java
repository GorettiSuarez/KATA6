package kata6;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Goretti
 */
public class Histogram <T> {
    
    private final HashMap<T,Integer> map = new HashMap<>();

    public Integer get(Object key) {
        return map.get(key);
    }

    public Set<T> keySet() {
        return map.keySet();
    }
    
    public void increment (T key){
        //map.put(key, map.containsKey(key)? map.get(key)+1:1);
        
        if (map.containsKey(key)){
            map.put(key, map.get(key)+1);
        } else {
            map.put(key, 1);
        }
    }
}