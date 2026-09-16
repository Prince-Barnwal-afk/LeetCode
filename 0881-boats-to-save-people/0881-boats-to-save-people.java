import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;                  // Pointer to the lightest person
        int right = people.length - 1; // Pointer to the heaviest person
        int boats = 0;

        while (left <= right) {
           
            if (people[left] + people[right] <= limit) {
                left++; 
            }
            right--;
            boats++;
        }

        return boats;
    }
}