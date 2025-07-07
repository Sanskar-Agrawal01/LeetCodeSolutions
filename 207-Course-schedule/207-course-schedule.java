import java.util.*;

class Solution {
    static class pair {
        int first, second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static ArrayList<ArrayList<Integer>> make_graph(int numTasks, Vector<pair> prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numTasks);
        for (int i = 0; i < numTasks; i++) {
            graph.add(new ArrayList<>());
        }
        for (pair pre : prerequisites)
            graph.get(pre.second).add(pre.first);
        return graph;
    }

    static int[] compute_indegree(ArrayList<ArrayList<Integer>> graph) {
        int[] degrees = new int[graph.size()];
        for (ArrayList<Integer> neighbors : graph)
            for (int neigh : neighbors)
                degrees[neigh]++;
        return degrees;
    }

    static boolean canFinish(int numTasks, Vector<pair> prerequisites) {
        ArrayList<ArrayList<Integer>> graph = make_graph(numTasks, prerequisites);
        int[] degrees = compute_indegree(graph);
        for (int i = 0; i < numTasks; i++) {
            int j = 0;
            for (; j < numTasks; j++)
                if (degrees[j] == 0)
                    break;
            if (j == numTasks)
                return false; // cycle detected
            degrees[j] = -1; // mark as visited
            for (int neigh : graph.get(j))
                degrees[neigh]--;
        }
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Vector<pair> list = new Vector<>();
        for (int[] pre : prerequisites) {
            list.add(new pair(pre[0], pre[1]));
        }
        return canFinish(numCourses, list);
    }
}
