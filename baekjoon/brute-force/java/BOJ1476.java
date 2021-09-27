import java.io.*;
import java.util.*;

public class BOJ1476 {
    static final int E_MAX = 16;
    static final int S_MAX = 29;
    static final int M_MAX = 20;
    static int E, S, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, m = 1, y = 1;
        while (true) {
            
            if (e == E && s == S && m == M) {
                break;
            }
            
            e = (e + 1) % E_MAX;
            s = (s + 1) % S_MAX;
            m = (m + 1) % M_MAX;

            e = (e == 0 ? 1 : e);
            s = (s == 0 ? 1 : s);
            m = (m == 0 ? 1 : m);
            ++y;
        }

        System.out.println(y);
    }

}
