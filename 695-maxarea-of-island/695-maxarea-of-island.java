class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        // Check every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start DFS if it's land and not visited
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        // Check boundaries and conditions
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return 0;
        if (grid[row][col] == 0 || visited[row][col])
            return 0;

        visited[row][col] = true;

        // Explore all 4 directions
        int area = 1;
        area += dfs(grid, visited, row - 1, col); // up
        area += dfs(grid, visited, row + 1, col); // down
        area += dfs(grid, visited, row, col - 1); // left
        area += dfs(grid, visited, row, col + 1); // right

        return area;
    }
}
