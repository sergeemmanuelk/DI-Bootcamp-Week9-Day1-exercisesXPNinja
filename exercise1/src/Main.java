import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        findKMostFrequentElements(arr, k);
    }

    public static void findKMostFrequentElements(int[] arr, int k) {
        // Create a map to store element-frequency pair
        Map<Integer, Integer> mp = new HashMap<>();

        // Traverse the array and update frequency of each element in map
        for (int i = 0; i < arr.length; i++) {
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }

        // Store the element-frequency pair in a list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mp.entrySet());

        // Sort the list in decreasing order of frequency
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o2.getKey() - o1.getKey();
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });

        // Print the first k elements of the sorted list
        for (int i = 0; i < k; i++) {
            System.out.print(list.get(i).getKey() + " ");
        }
    }
}