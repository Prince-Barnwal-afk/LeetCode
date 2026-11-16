class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int end = Math.min(i + k, s.length());
                int temp = sum(s, i, end);
                sb.append(temp);
            }
            s = sb.toString();
        }
        return s;
    }

    public static int sum(String s, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += s.charAt(i) - '0';
        }
        return sum;
    }
}