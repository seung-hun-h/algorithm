import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
    
        System.out.println(pow(A, B, C));
    }

    public static long pow(int x, int component, int mod) {
        if (component == 0)
            return 1;

        long temp = pow(x, component / 2, mod);

        if (component % 2 == 1) 
            return (temp * temp % mod) * x % mod;

        return temp * temp % mod;
    }
}