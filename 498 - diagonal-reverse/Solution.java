class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
       int n = mat.length;
        int m = mat[0].length;
        int arr[] = new int[n * m];
        int i = 0;
        int j = 0;
        int idx = 0;

        while (idx < n * m) {   
            while (i >= 0 && j < m && idx < n * m) {
                arr[idx++] = mat[i][j];
                i--;
                j++;
            }
            if (j >= m) {  
                j = m - 1;
                i += 2;
            } else {
                i++;
            }

            while (j >= 0 && i < n && idx < n * m) {
                arr[idx++] = mat[i][j];
                i++;
                j--;
            }
            if (i >= n) {  
                i = n - 1;
                j += 2;
            } else {
                j++;
            }
        }
        return arr;
    }
}