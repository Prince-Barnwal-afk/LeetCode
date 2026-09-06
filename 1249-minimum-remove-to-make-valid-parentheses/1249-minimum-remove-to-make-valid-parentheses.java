class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openCount = 0;
        
        // Pass 1: Remove invalid closing parentheses ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
                sb.append(c);
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                    sb.append(c);
                }
                // If openCount == 0, skip this unmatched ')'
            } else {
                sb.append(c); // Append non-parenthesis characters
            }
        }
        
        // Pass 2: Remove unmatched opening parentheses '(' from the right
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && openCount > 0) {
                openCount--; // Skip this unmatched '('
            } else {
                result.append(c);
            }
        }
        
        return result.reverse().toString();
    }
}

// using stack both have same timecomplexity and spavbe complexity

// import java.util.ArrayDeque;
// import java.util.Deque;

// class Solution {
//     public String minRemoveToMakeValid(String s) {
//         Deque<Integer> stack = new ArrayDeque<>();
//         boolean[] invalidIndices = new boolean[s.length()];
        
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (c == '(') {
//                 // Store the index of '(' to match later
//                 stack.push(i);
//             } else if (c == ')') {
//                 if (!stack.isEmpty()) {
//                     // Valid pair found, pop matching '(' index
//                     stack.pop();
//                 } else {
//                     // No matching '(', mark this ')' as invalid
//                     invalidIndices[i] = true;
//                 }
//             }
//         }
        
//         // Remaining indices in stack are unmatched '('
//         while (!stack.isEmpty()) {
//             invalidIndices[stack.pop()] = true;
//         }
        
//         // Rebuild string omitting invalid characters
//         StringBuilder result = new StringBuilder();
//         for (int i = 0; i < s.length(); i++) {
//             if (!invalidIndices[i]) {
//                 result.append(s.charAt(i));
//             }
//         }
        
//         return result.toString();
//     }
// }