import java.io.*;
import java.util.*;
public class BOJ7795 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                B[j] = Integer.parseInt(st.nextToken());
            }
            
            System.out.println(countPair(A, B));
        }
    }
    public static int countPair(int[] A, int[] B){
        int cnt = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int b : B){
            int res = 0;
            int left = 0;
            int right = A.length-1;

            while (left <= right){
                int mid = (left + right) / 2;
                if(A[mid] > b){
                    res = A.length - mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            cnt += res;
        }
        return cnt;
    }
}
