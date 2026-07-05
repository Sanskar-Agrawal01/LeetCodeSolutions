class Solution {
    static class Edge {
        int dest;
        int wt;

        public Edge(int d, int w) {
            this.dest = d;
            this.wt = w;
        }
    }
    int ans = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        ArrayList<Edge> graph[] = new ArrayList[n +1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int e[] : roads) {
            graph[e[0]].add(new Edge(e[1], e[2]));
            graph[e[1]].add(new Edge(e[0], e[2]));
        }
        boolean[] vis = new boolean[n + 1];
        helper(graph, 1, vis);
        return ans;
    }

    public  void helper(ArrayList<Edge> graph[], int src, boolean vis[]) {
        vis[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
             Edge e = graph[src].get(i);
             ans = Math.min(ans, e.wt);
             if (!vis[e.dest]) {
                helper(graph, e.dest, vis);
            }
        }
    }
}