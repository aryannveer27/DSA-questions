
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        ArrayList<Integer>[] adj = new ArrayList[n];
        ArrayList<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] last = new int[26];
        int[] prev = new int[n];
        int[] newParent = parent.clone();

        Arrays.fill(last, -1);

        int[] stack = new int[2 * n];
        int top = 0;

        stack[top++] = 0;

        while (top > 0) {
            int x = stack[--top];

            if (x < 0) {
                x = -x - 1;
                last[s.charAt(x) - 'a'] = prev[x];
                continue;
            }

            int c = s.charAt(x) - 'a';

            prev[x] = last[c];

            if (last[c] != -1) {
                newParent[x] = last[c];
            }

            last[c] = x;

            stack[top++] = -(x + 1);

            for (int child : adj[x]) {
                stack[top++] = child;
            }
        }

        for (int i = 1; i < n; i++) {
            tree[newParent[i]].add(i);
        }

        int[] order = new int[n];
        top = 0;
        int count = 0;

        stack[top++] = 0;

        while (top > 0) {
            int x = stack[--top];
            order[count++] = x;

            for (int child : tree[x]) {
                stack[top++] = child;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i > 0; i--) {
            int x = order[i];
            ans[newParent[x]] += ans[x];
        }

        return ans;
    }
}
