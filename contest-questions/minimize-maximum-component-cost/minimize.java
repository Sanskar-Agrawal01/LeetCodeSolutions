class Solution {
    class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    int[] par;
    int[] rank;

    public void initDSU(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (par[x] == x) return x;
        return par[x] = find(par[x]);
    }

    public boolean union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA == parB) return false;

        if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parB] = parA;
            rank[parA]++;
        }
        return true;
    }

    public int getMinMaxCost(int n, ArrayList<Edge> edges, int k) {
        Collections.sort(edges);

        initDSU(n);
        int maxwt = 0;
        int comp = n;

        for (Edge e : edges) {
            if (comp <= k) break;

            if (union(e.src, e.dest)) {
                maxwt = Math.max(maxwt, e.wt);
                comp--;
            }
        }

        return maxwt;
    }

    public int minCost(int n, int[][] inputEdges, int k) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < inputEdges.length; i++) {
            int u = inputEdges[i][0];
            int v = inputEdges[i][1];
            int wt = inputEdges[i][2];
            edges.add(new Edge(u, v, wt));
        }

        return getMinMaxCost(n, edges, k);
    }
}
