class Solution {
    static class Pair{
        int num;
        int idx;
        public Pair(int n, int id){
            this.num = n;
            this.idx = id;
        }       
    }
    public int[] arrayRankTransform(int[] arr) {
        int res [] = new int[arr.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.num  - b.num);
        for(int i = 0;i<arr.length;i++) pq.add(new Pair(arr[i], i));
        int idx = 0;
        int curr = 0;
        Integer prev = null;
        while(!pq.isEmpty()){
             Pair temp = pq.remove();
             int n1 = temp.num;
             int id = temp.idx;
              curr = n1;
              if(prev == null || curr !=  prev ){
                res[id] = idx+1;
                prev = curr;
                curr = n1;
                idx++;
              }
              else{
                res[id] = idx;
                prev = curr;
                curr = n1;
              }
             
        }
        return res;
    }
}