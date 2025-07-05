class Solution {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int time;
        int cost;

        public Pair(int n, int time, int cost) {
            this.n = n;
            this.time = time;
            this.cost = cost;
        }

        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    
    public static ArrayList<Edge>[] buildGraph(int n, int[][] edges) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }

        return graph;
    }

    
    public static int dijkstraMinCost(ArrayList<Edge>[] graph, int[] passingFees, int maxTime) {
        int n = graph.length;
        int[] minTime = new int[n];
        for (int i = 0; i < n; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, passingFees[0]));
        minTime[0] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (curr.n == n - 1) {
                return curr.cost;
            }

            for (int i = 0; i < graph[curr.n].size(); i++) {
                Edge e = graph[curr.n].get(i);
                int nextTime = curr.time + e.wt;
                int nextCost = curr.cost + passingFees[e.dest];

                if (nextTime <= maxTime && nextTime < minTime[e.dest]) {
                    minTime[e.dest] = nextTime;
                    pq.add(new Pair(e.dest, nextTime, nextCost));
                }
            }
        }

        return -1;
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        ArrayList<Edge>[] graph = buildGraph(n, edges);
        return dijkstraMinCost(graph, passingFees, maxTime);
    }
}
