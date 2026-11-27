
class StockSpanner {
    private Deque<int[]> st;
    private int idx;

    public StockSpanner() {
        st = new ArrayDeque<>();
        idx = 0;
    }

    public int next(int price) {
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        int pgeIdx = st.isEmpty() ? -1 : st.peek()[1];
        int span = idx - pgeIdx;
        st.push(new int[]{price, idx});
        idx++;
        return span;
    }
}