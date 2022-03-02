import java.io.*;
import java.util.*;

class BOJ21277 {
    static int N1, N2, M1, M2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N1 = Integer.parseInt(st.nextToken());
        M1 = Integer.parseInt(st.nextToken());

        int[][] p1 = new int[N1][M1];

        for (int i=0;i<N1;i++) {
            String[] line = br.readLine().strip().split("");
            for (int j=0;j<M1;j++) {
                p1[i][j] = Integer.parseInt(line[j]);
            }
        }

        st = new StringTokenizer(br.readLine());

        N2 = Integer.parseInt(st.nextToken());
        M2 = Integer.parseInt(st.nextToken());

        
        int[][] p2 = new int[N2][M2];

        for (int i=0;i<N2;i++) {
            String[] line = br.readLine().strip().split("");
            for (int j=0;j<M2;j++) {
                p2[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(Math.min(solve(p1, p2), solve(p2, p1)));
    }

    private static int solve(int[][] p1, int[][] p2) {
        int result = Integer.MAX_VALUE;
        int n1 = p1.length, m1 = p1[0].length;
        int n2 = p2.length, m2 = p2[0].length;

        for (int l=0;l<4;l++) {
            for (int k=0;k<4;k++) {
                for (int rowOffset=0;rowOffset<=n1;rowOffset++) {
                    for(int colOffset=0;colOffset<=m1;colOffset++) {
                        
                        int current = check(rowOffset, colOffset, p1, p2);
    
                        result = Math.min(result, current);
                    }
                }
                p2 = rotate(p2);
                int temp = n2;
                n2 = m2;
                m2 = temp;
            }    
            p1 = rotate(p1);
            int temp = n1;
            n1 = m1;
            n1 = temp;
        }
        return result;
    }

    private static int check(int rowOffset, int colOffset, int[][] p1, int[][] p2) {
        int n1 = p1.length, m1 = p1[0].length;
        int n2 = p2.length, m2 = p2[0].length;

        for (int i=0;i<n2;i++) {
            for (int j=0;j<m2;j++) {
                int row = i + rowOffset;
                int col = j + colOffset;

                if (row >= n1 || col >= m1) continue;

                if (p1[row][col] == 1 && p2[i][j] == 1)
                    return Integer.MAX_VALUE;
            }
        }

        int colLen = Math.max(colOffset + m2, m1);
        int rowLen = Math.max(rowOffset + n2, n1);

        return colLen * rowLen;
    }

    public static int[][] rotate(int[][] puzzle) {
        int n = puzzle.length;
        int m = puzzle[0].length;

        int[][] temp = new int[m][n];

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                temp[j][n-1-i] = puzzle[i][j];
            }
        }

        return temp;
    }
}