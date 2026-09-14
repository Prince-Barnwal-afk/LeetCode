class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        int commonWidth = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        int commonHeight = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);
        
        return commonWidth > 0 && commonHeight > 0;
    }
}