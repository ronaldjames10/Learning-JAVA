import java.util.HashMap;
import java.util.Map;
public class iteration2 {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Alice");
        map.put(2, "Bob");
        map.put(3, "Charlie");
        map.put(4, "Karim");
        map.put(5, "Rahim");
//        Using values
        System.out.println("------------------------------------------");
        System.out.println("Using values ");
        System.out.println("-------------------------------------------");
        for (String value : map.values()) {
            System.out.println(value);
        }
    }
}
