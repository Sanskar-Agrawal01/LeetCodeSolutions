class Edge {
    int dest;
    int wt;

    Edge(int dest, int wt) {
        this.dest = dest;
        this.wt = wt;
    }
}
class Pair {
    int node;
    long cost;

    Pair(int node, long cost) {
        this.node = node;
        this.cost = cost;
    }
}
class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int maxWt = 0;
        for (int[] e : edges) {
            graph[e[0]].add(new Edge(e[1], e[2]));
            maxWt = Math.max(maxWt, e[2]);
        }
        int low = 0, high = maxWt;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, graph, online, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    private boolean check(int minEdge, ArrayList<Edge>[] graph, boolean[] online, long k) {
        int n = online.length;
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.cost > dist[curr.node]) {
                continue;
            }
            if (curr.node == n - 1) {
                return curr.cost <= k;
            }
            for (Edge e : graph[curr.node]) {
                if (e.wt < minEdge) {
                    continue;
                }
                if (e.dest != n - 1 && !online[e.dest]) {
                    continue;
                }
                long newCost = curr.cost + e.wt;
                if (newCost <= k && newCost < dist[e.dest]) {
                    dist[e.dest] = newCost;
                    pq.offer(new Pair(e.dest, newCost));
                }
            }
        }

        return false;
    }
}