import java.util.*;

public class Solution {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Map to store: key = groupSize, value = list of person IDs
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            // Get the current list for this group size, or initialize it
            map.putIfAbsent(size, new ArrayList<>());
            List<Integer> currentGroup = map.get(size);
            
            // Add person to their group size list
            currentGroup.add(i);

            // Once the group reaches its required size, add to result and reset
            if (currentGroup.size() == size) {
                result.add(new ArrayList<>(currentGroup));
                currentGroup.clear(); // Empty the list for the next group of this size
            }
        }

        return result;
    }


}