import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
public class Iteration_using_Iterator {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Alice");
        map.put(2, "Bob");
        map.put(3, "Charlie");
        map.put(22, "Karim");
        map.put(30, "Rahim");

        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

