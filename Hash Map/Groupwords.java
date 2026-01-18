//import java.util.*;
//
//public class Groupwords {
//    public static void main(String[] args) {
//
//        // Input
//        String[] words = {"apple", "ant", "bat", "ball"};
//
//        Map<Character, List<String>> groups = new HashMap<>();
//
//        for (String word : words) {
//            char key = word.charAt(0);
//
//            groups
//                    .computeIfAbsent(key, k -> new ArrayList<>())
//                    .add(word);
//        }
//
//        // Output
//        groups.forEach((k, v) ->
//                System.out.println(k + " -> " + v)
//        );
//    }
//}
import java.util.*;

public class Groupwords {

    public static void main(String[] args) {

        // Input array
        String[] words = {"apple", "ant", "bat", "ball"};

        // Map to store grouped words
        Map<Character, List<String>> groups = new HashMap<>();

        // Loop through each word
        for (String word : words) {

            // Get first character of the word
            char key = word.charAt(0);

            // If key is not present, create a new list
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }

            // Add word to the list for that key
            groups.get(key).add(word);
        }

        // Print the result
        for (Map.Entry<Character, List<String>> entry : groups.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
