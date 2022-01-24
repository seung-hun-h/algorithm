import java.io.*;
import java.util.*;

public class BOJ17037 {
    private static int N;
    private static double W;
    private static int[] degree;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Double.parseDouble(st.nextToken());
        degree = new int[N + 1];

        for (int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            degree[u]++;
            degree[v]++;
        }

        int leaf = 0;
        for (int i=2;i<=N;i++) {
            if (degree[i] == 1) {
                leaf++;
            }
        }

        System.out.println(W / leaf);

    }

}
