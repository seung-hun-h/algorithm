import java.io.*;
import java.util.*;

public class BOJ6987 {
    private static int[][] matches;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        matches = new int[15][2];
        int idx = 0;
        for (int i=0;i<5;i++) {
            for (int j=i+1;j<6;j++) {
                matches[idx][0] = i;
                matches[idx++][1] = j;
            }
        }

        for (int i=0;i<4;i++) {
            int[][] scores = new int[6][3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int total = 0;
            for (int k=0;k<6;k++) {
                for (int j=0;j<3;j++) {
                    scores[k][j] = Integer.parseInt(st.nextToken());
                    total += scores[k][j];
                }
            }

            if (total == 30 && dfs(scores, 0)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }

        }
        System.out.println(sb);
    }

    private static boolean dfs(int[][] scores, int round) {
        if (round == 15) {
            return true;
        }

        int team1 = matches[round][0];
        int team2 = matches[round][1];

        if (scores[team1][0] > 0 && scores[team2][2] > 0) {
            scores[team1][0]--;
            scores[team2][2]--;
            if (dfs(scores, round + 1)) {
                return true;
            }
            scores[team1][0]++;
            scores[team2][2]++;
        }

        if (scores[team1][2] > 0 && scores[team2][0] > 0) {
            scores[team1][2]--;
            scores[team2][0]--;
            if (dfs(scores, round + 1)) {
                return true;
            }
            scores[team1][2]++;
            scores[team2][0]++;
        }

        if (scores[team1][1] > 0 && scores[team2][1] > 0) {
            scores[team1][1]--;
            scores[team2][1]--;
            if (dfs(scores, round + 1)) {
                return true;
            }
            scores[team1][1]++;
            scores[team2][1]++;
        }

        return false;
    }

}