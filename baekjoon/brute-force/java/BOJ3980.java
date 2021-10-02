import java.util.*;
import java.io.*;

public class BOJ3980 {
    static int[][] capacity;
    static int result;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int C = Integer.parseInt(br.readLine());

        for (int c=0;c<C;c++) {
            capacity = new int[11][11];
            result = 0;

            for (int i=0;i<11;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j=0;j<11;j++) {
                    capacity[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0, 0);
            System.out.println(result);
        }
        
    }

    public static void dfs(int person, int point, int visited) {
        if (visited == (1 << 11) - 1) {
            result = Math.max(result, point);
            return;
        }

        for (int i = 0; i < 11; i++) {
            
            if ((visited & (1 << i)) != 0) continue;
            if (capacity[person][i] == 0) continue;
            dfs(person + 1, point + capacity[person][i], visited | (1 << i));
        }
    }
}
