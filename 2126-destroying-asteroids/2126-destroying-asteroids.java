class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int mod = 1000000007;
        Arrays.sort(asteroids);
        for(int i = 0;i<asteroids.length;i++){
            if(mass < asteroids[i]) return false;
            mass = mass % mod;
            asteroids[i] %= mod;
            mass+=asteroids[i];

        }
        return true;
    }
}