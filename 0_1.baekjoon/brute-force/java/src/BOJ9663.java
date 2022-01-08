import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9663 {
    private static int N;
    private static int[] column;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        column = new int[N];

        System.out.println(solve());
    }

    private static int solve() {

        dfs(0);

        return answer;
    }

    private static void dfs(int depth) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i=0;i<N;i++) {
            if (check(depth, i)) {
                column[depth] = i;
                dfs(depth + 1);
                column[depth] = 0;
            }
        }
    }

    private static boolean check(int row, int col) {
        for (int i=0;i<row;i++) {
            if (col == column[i])
                return false;

            if ((row - i) == Math.abs(col - column[i])) {
                return false;
            }

        }
        return true;
    }
}
