class Solution {
    static class Edge{
        int u,v;
        Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    Edge e1 = new Edge(i, j);
                    Edge e2 = new Edge(j, i);
                    graph[i].add(e1);
                    graph[j].add(e2);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }

        return n - components; 
    }

    private void dfs(int node, ArrayList<Edge>[] graph, boolean[] visited) {
        visited[node] = true;
        for (Edge e : graph[node]) {
            if (!visited[e.v]) {
                dfs(e.v, graph, visited);
            }
        }
    }
}