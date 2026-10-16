import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1000000007;
    private long[] tree;
    private long[] lazy;
    private long[] sumSq;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new long[4 * n];
        lazy = new long[4 * n];
        sumSq = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long ans = 0;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastSeen.getOrDefault(nums[i], -1);
            long added = query(1, 0, n - 1, prev + 1, i);
            currentSum = (currentSum + 2 * added + (i - prev)) % MOD;
            update(1, 0, n - 1, prev + 1, i);
            ans = (ans + currentSum) % MOD;
            lastSeen.put(nums[i], i);
        }

        return (int) ans;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void apply(int node, int l, int r, long val) {
        long len = r - l + 1;
        sumSq[node] = (sumSq[node] + 2 * val * tree[node] + val * val * len) % MOD;
        tree[node] = (tree[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) / 2;
        if (ql <= mid) {
            update(2 * node, l, mid, ql, qr);
        }
        if (qr > mid) {
            update(2 * node + 1, mid + 1, r, ql, qr);
        }
        tree[node] = (tree[2 * node] + tree[2 * node + 1]) % MOD;
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
    }

    private long query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        pushDown(node, l, r);
        int mid = (l + r) / 2;
        long res = 0;
        if (ql <= mid) {
            res = (res + query(2 * node, l, mid, ql, qr)) % MOD;
        }
        if (qr > mid) {
            res = (res + query(2 * node + 1, mid + 1, r, ql, qr)) % MOD;
        }
        return res;
    }
}