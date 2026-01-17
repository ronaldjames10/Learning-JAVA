import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 4, 2, 3, 1};

        Map<Integer, Integer> map = new HashMap<>();

        // Frequency Counter
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Print frequencies
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Number " + entry.getKey() +
                    " occurs " + entry.getValue() + " times");
        }
    }
}
