class Solution {
    public int minSensors(int n, int m, int k) {
        int step = 2 * k + 1;           
        int rows = (int) Math.ceil((double) n / step);  
        int cols = (int) Math.ceil((double) m / step);  
        return rows * cols; 
    }
}