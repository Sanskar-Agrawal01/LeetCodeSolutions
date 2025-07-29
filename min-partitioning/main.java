import java.util.*;

public class main {
    static class Pair {
        int jug1, jug2;
        Pair(int a, int b) {
            this.jug1 = a;
            this.jug2 = b;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return this.jug1 == p.jug1 && this.jug2 == p.jug2;
        }

        
    }

    public static void waterJug(int cap1, int cap2, int target) {
        Queue<Pair> q = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();

        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.jug1, y = curr.jug2;

            if (x == target || y == target) {
                System.out.println("Reached target: (" + x + ", " + y + ")");
                return;
            }

            if (visited.contains(curr)) continue;
            visited.add(curr);

           
            q.add(new Pair(cap1, y));         
            q.add(new Pair(x, cap2));        
            q.add(new Pair(0, y));            
            q.add(new Pair(x, 0));            

           
            int pour1 = Math.min(x, cap2 - y);
            q.add(new Pair(x - pour1, y + pour1));

            
            int pour2 = Math.min(y, cap1 - x);
            q.add(new Pair(x + pour2, y - pour2));
        }

        System.out.println("Target not reachable.");
    }

    public static void main(String[] args) {
        int jug1 = 4;
        int jug2 = 3;
        int target = 2;
        waterJug(jug1, jug2, target);
    }
}
