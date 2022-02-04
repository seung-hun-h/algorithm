import java.io.*;
import java.util.*;
public class BOJ19942 {
    private static int[][] materials;
    private static int N;
    private static int picked = 0;
    private static int result = Integer.MAX_VALUE;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        materials = new int[N][5];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mp = Integer.parseInt(st.nextToken());
        int mf = Integer.parseInt(st.nextToken());
        int ms = Integer.parseInt(st.nextToken());
        int mv = Integer.parseInt(st.nextToken());

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<5;j++) {
                materials[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, mp, mf, ms, mv, 0, 0);
        if (picked == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
            for (int i=0;i<N;i++) {
                if ((picked & (1 << i)) != 0) {
                    System.out.print(i+1 +" ");
                }
            }
        }

    }

    private static void dfs(int idx, int protein, int fat, int carbo, int vitamin, int price, int visited) {
        if (price >= result) {
            return;
        }
        if (protein <= 0 && fat <= 0 && carbo <= 0 && vitamin <= 0) {
            result = price;
            picked = visited;
            return;
        }

        if (idx == N) {
            return;
        }

        dfs(idx + 1, protein - materials[idx][0], fat - materials[idx][1], carbo - materials[idx][2], vitamin - materials[idx][3], price + materials[idx][4], visited | (1 << idx));
        dfs(idx + 1, protein, fat, carbo, vitamin, price, visited);
    }
}
