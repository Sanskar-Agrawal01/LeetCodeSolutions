class Solution {
    class Edge {
        int src;
        int dest;

        public Edge(int s ,int d){
            this.src =s;
            this.dest=d;
        }
    }

    public static boolean isbipartite(ArrayList<Edge> [] graph){
            int col[] = new int[graph.length];
            for(int i =0;i<col.length;i++){
                col[i] = -1;
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i = 0;i<graph.length;i++){
                if(col[i] == -1){
                    q.add(i);
                    col[i] = 0;
           while(!q.isEmpty()){
            int curr = q.remove();
            for(int  j =0;j<graph[curr].size();j++){
                Edge e  = graph[curr].get(j);

                if(col[e.dest]  == -1){
                    int nextCol = col[curr] == 0? 1: 0;
                    col[e.dest] = nextCol;
                    q.add(e.dest);
                }
                else if(col[e.dest] == col[curr]){
                    return false;
                }
            }
           }
                }
            }
            return true;
    }

        public boolean isBipartite(int[][] graph) {
            ArrayList<Edge>[] graph2 = new ArrayList[graph.length];
            for (int i = 0; i < graph2.length; i++) {
                graph2[i] = new ArrayList<>();
            }

           for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int neighbor = graph[i][j];
                graph2[i].add(new Edge(i, neighbor));
            }
        }

            return  isbipartite(graph2);
        }

        
}