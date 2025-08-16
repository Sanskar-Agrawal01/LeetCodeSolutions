import java.util.*;

class Solution {
    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        long cost;

        Pair(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Pair o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public int minCost(int n, int[][] edges) {
        int[][] nums2 = edges;

        ArrayList<Edge>[] graph1 = new ArrayList[n];
        ArrayList<Edge>[] in = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph1[i] = new ArrayList<>();
            in[i] = new ArrayList<>();
        }
        for (int[] e : nums2) {
            int u = e[0], v = e[1], w = e[2];
            graph1[u].add(new Edge(u, v, w));
            in[v].add(new Edge(u, v, w));
        }

        long ans = runDijkstra(n, graph1, in);
        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }

    private long runDijkstra(int n, ArrayList<Edge>[] graph1, ArrayList<Edge>[] in) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            long d = cur.cost;
            if (d != dist[u])
                continue;

            
            for (Edge e : graph1[u]) {
                int v = e.v;
                long nd = d + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new Pair(v, nd));
                }
            }

            for (Edge e : in[u]) {
                int x = e.u;
                long nd = d + 2L * e.w;
                if (nd < dist[x]) {
                    dist[x] = nd;
                    pq.add(new Pair(x, nd));
                }
            }
        }
        return dist[n - 1];
    }
}
