class Solution {
    public double angleClock(int hour, int minutes) {
        double diff = minutes/2.0;
        double hrDegree = (hour%12)*30 + diff;
        double minDegree = minutes*6;
        return Math.min(360 - Math.abs(hrDegree - minDegree), Math.abs(hrDegree - minDegree)); 
    }
}