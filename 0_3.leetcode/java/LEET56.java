import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        for(int[] interval : intervals) {
            if(!merged.isEmpty() && interval[0] <= merged.get(merged.size()-1)[1]) {
                merged.get(merged.size()-1)[1] 
                        = Math.max(interval[1], merged.get(merged.size()-1)[1]);
            } else {
                merged.add(interval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
