import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2224 {

    private static final int M = 'z' - 'A' + 1;
    private static final int BASE = 'A';
    private static boolean[][] connected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        connected = new boolean[M][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int u = line.charAt(0) - BASE;
            int v = line.charAt(5) - BASE;

            connected[u][v] = true;
        }

        System.out.println(solve());

        br.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        connect();

        int count = 0;
        for (int p = 0; p < M; p++) {
            for (int q = 0; q < M; q++) {
                if (p != q && connected[p][q]) {
                    char u = (char) (BASE + p);
                    char v = (char) (BASE + q);
                    sb.append(u).append(" => ").append(v).append("\n");
                    count++;

                }
            }
        }

        sb.insert(0, count + "\n");
        return sb.toString();
    }

    private static void connect() {
        for (int q = 0; q < M; q++) {
            for (int p = 0; p < M; p++) {
                for (int r = 0; r < M; r++) {
                    if (p == r) {
                        continue;
                    }
                    if (connected[p][r]) {
                        continue;
                    }
                    connected[p][r] = connected[p][q] && connected[q][r];
                }
            }
        }
    }
}
