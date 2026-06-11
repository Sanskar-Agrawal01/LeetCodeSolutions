public class Node {
    int src;
    int dest;

    public Node(int s, int d) {
        this.src = s;
        this.dest = d;
    }
}

class Solution {
    public static int assignEdgeWeights(int[][] edges) {
        int mod = 1000000007;
        int maxNode = 0;
        for (int[] nums : edges) {
            maxNode = Math.max(maxNode, Math.max(nums[0], nums[1]));
        }

        ArrayList<Node>[] graph = new ArrayList[maxNode + 1];
        for (int i = 0; i <= maxNode; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[] vis = new boolean[maxNode + 1];
        for (int nums[] : edges) {
            int u = nums[0];
            int v = nums[1];
            graph[u].add(new Node(u, v));
            graph[v].add(new Node(v, u));
        }
        int depth = dfs(graph, vis, 1);
        if (depth == 0)
            return 0;
        if (depth - 1 == 1)
            return 1;
        depth = depth % mod;
        return (int) modPow(2, depth - 2, mod);

    }

    public static int dfs(List<Node> graph[], boolean vis[], int curr) {
        vis[curr] = true;
        int maxDepth = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Node n = graph[curr].get(i);
            if (!vis[n.dest]) {
                maxDepth = Math.max(maxDepth, dfs(graph, vis, n.dest));
            }
        }
        return maxDepth + 1;
    }

    static long modPow(long a, long b, long mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}
