import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LEET973 {

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        System.out.println(kClosest(points, k));
    }
    public static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[0]-a2[0]);

        for(int[] point : points) {
            int dist = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
            pq.add(new int[]{dist, point[0], point[1]});
        }

        int[][] result = new int[k][];
        for(int i=0;i<k;i++) {
            int[] temp = pq.remove();
            result[i] = new int[]{temp[1], temp[2]};
            
        }
        return result;
    }
}
