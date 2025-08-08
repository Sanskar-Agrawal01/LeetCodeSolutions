class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n]; 
        List<Integer> safecurrs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, vis)) {
                safecurrs.add(i);
            }
        }
        return safecurrs;
    }
    
    private boolean dfs(int curr, int[][] graph, int[] vis) {
        if (vis[curr] != 0) {
            return vis[curr] == 2; 
        }
        vis[curr] = 1; 
        
        for (int j = 0; j < graph[curr].length; j++) {
            int nei = graph[curr][j];
            if (!dfs(nei, graph, vis)) {
                return false;
            }
        }
        
        vis[curr] = 2; 
        return true;
    }
}