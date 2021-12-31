import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15651 {
  
  private static int N, M;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int[] arr = new int[M];

    dfs(arr, 0);
    System.out.println(sb.toString());
  }

  private static void dfs(int[] arr, int depth) {
    if (depth == M) {
      for (int num : arr) {
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; i++) {
      arr[depth] = i;
      dfs(arr, depth + 1);
    }

  }
}
