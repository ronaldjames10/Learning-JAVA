import java.util.HashMap;
import java.util.Map;
public class Iteration_techniques {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Alice");
        map.put(2, "Bob");
        map.put(3, "Charlie");
        map.put(4, "Karim");
        map.put(5, "Rahim");
//        Using entry.Set()
        System.out.println("------------------------------------------");
        System.out.println("Using entry.Set() ");
        System.out.println("-------------------------------------------");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());

        }
//         Using keySet()
        System.out.println("------------------------------------------");
        System.out.println("Using keySet() ");
        System.out.println("------------------------------------------");
        for (Integer key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        System.out.println("------------------------------------------");
    }
}

