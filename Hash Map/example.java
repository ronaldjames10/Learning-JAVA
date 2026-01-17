import java.util.HashMap;

public class example {
    public static void main(String[] args) {

        // 1️ HashMap তৈরি
        HashMap<Integer, String> map = new HashMap<>();

        // 1. map.put(1, "Alice");
        map.put(1,"Alice");
        map.put(2, "Bob");
        map.put( 22,"Karim");
        map.put( 30,"Rahim");
        // 2. map.get(1);  → "Alice"
        System.out.println("get(1): " + map.get(1));

        // 3. map.containsKey(1); → true
        System.out.println("containsKey(1): " + map.containsKey(1));

        // 4. map.size(); → 1
        System.out.println("size(): " + map.size());

        // 5. map.isEmpty(); → false
        System.out.println("isEmpty(): " + map.isEmpty());

        // 6. map.keySet(); → [1]
        System.out.println("keySet(): " + map.keySet());

        // 7. map.values(); → ["Alice"]
        System.out.println("values(): " + map.values());

        // 8. map.entrySet(); → [1=Alice]
        System.out.println("entrySet(): " + map.entrySet());
    }
}
