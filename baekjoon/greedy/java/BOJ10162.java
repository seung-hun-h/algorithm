import java.io.*;

public class BOJ10162 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int A = 300;
        int B = 60;
        int C = 10;
        int[] count = new int[3];

        if (T % C != 0) {
            System.out.println(-1);
            return;
        }

        while (T > 0) {
            if (T >= A) {
                T -= A;
                count[0]++;
            } else if (T >= B) {
                T -= B;
                count[1]++;
            } else {
                T -= C;
                count[2]++;
            }
        }

        System.out.println(String.format("%d %d %d", count[0], count[1], count[2]));

    }
}
