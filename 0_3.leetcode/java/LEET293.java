import java.util.*;
public class LEET293 {
    
    public static void main(String[] args) {
        int[] result = maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
        for (int r : result){
            System.out.print(r + " ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        int index = 0;

        for (int i=0;i<nums.length;i++) {
            while (!q.isEmpty() && q.getLast() < nums[i])
                q.removeLast();
            
            q.add(nums[i]);

            if (i >= k-1) {
                result[index++] = q.getFirst();
                if (nums[i-k+1] == q.getFirst()) {
                    q.removeFirst();
                }
            }
        }
        return result;
    } 

}
