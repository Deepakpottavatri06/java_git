import java.util.HashMap;
import java.util.Iterator;

public class Hmap {
    public static void main(String[] args) {
        HashMap <String,Integer> map =  new HashMap<>();
        map.put("A",100);
        map.put("B", 101);
        map.put("C",102);

        System.err.println(map.get("A"));

        //Iteration with keys
        for (String string : map.keySet()) {
            System.err.println(string);
        }

        //System.err.println(map.size());
        //iteration with values:

        for(Integer i: map.values()){
            System.err.println(i);
        }
        for (HashMap.Entry<String,Integer> iEntry : map.entrySet()) {
            System.err.println(iEntry.getKey()+ " : " + iEntry.getValue());
        }

        
    }
}
