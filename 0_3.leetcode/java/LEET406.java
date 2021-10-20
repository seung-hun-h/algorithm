import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEET406 {
    public static void main(String[] args) {
        int[][] result = reconstructQueue(new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : o2[0] - o1[0]);
        
        List<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }

        return result.toArray(new int[people.length][2]);
    }
}
