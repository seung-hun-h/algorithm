import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
class BOJ15650 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    
        dfs(0, new ArrayList<>());
    }

    public static void dfs(int current, List<Integer> result) {
        if (result.size() == M) {
            result.forEach(num -> System.out.print(num + " "));
            System.out.println();
            return;
        }

        for (int i = current + 1; i <= N; i++) {
            result.add(i);
            dfs(i, result);
            result.remove(Integer.valueOf(i));
        }
    }
}