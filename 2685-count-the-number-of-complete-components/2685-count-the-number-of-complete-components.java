class Solution {
    static class Edge {
        int dest;

        public Edge(int d) {
            this.dest = d;
        }
    }

    static int nodes = 0;
    static int edge = 0;

    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int e[] : edges) {
            graph[e[0]].add(new Edge(e[1]));
            graph[e[1]].add(new Edge(e[0]));
        }
        int cnt = 0;
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                nodes = 0;
                edge = 0;
                dfs(graph, vis, i);
                edge = edge /2;
                if (edge == (nodes * (nodes - 1) / 2)) {
                    cnt++;
                }
            }
        }

        return cnt;

    }

    public void dfs(ArrayList<Edge> graph[], boolean vis[], int curr) {
        vis[curr] = true;
        nodes++;
        for (Edge e : graph[curr]) {
            edge++;
            if (!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }
}