class Solution {
    class Edge {
        int src;
        int des;
        public Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u)); 
        }
         boolean[] vis=new boolean[n];
        return haspath(graph,source,destination,vis); 
    }
    public static boolean haspath(ArrayList<Edge>[] graph,int src,int des,boolean [] vis){
        if(src == des){
            return true;
        }
        vis[src] = true;
        for(int i = 0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!vis[e.des] && haspath(graph,e.des, des, vis)){
                return true;
            }
        }
        return false;
    }
}
