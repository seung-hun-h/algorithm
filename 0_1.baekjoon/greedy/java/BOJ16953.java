import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(getMinimumOperations(A, B));
    }

    private static int getMinimumOperations(int start, int end) {
        int number = end;

        for (int i=0;i<end;i++) {
            if (number == start)
                return i + 1;
                
            if (number % 10 == 1) {
                number /= 10;
            } else if (number % 2 == 0){
                number /= 2;
            } else {
                return -1;
            }
        }

        return -1;
    }
}
