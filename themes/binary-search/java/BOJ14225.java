import java.util.*;
import java.io.*;

public class BOJ14225 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }
    public static void solve(){
        Set<Integer> permSum = new HashSet<>();
        getPermSum(0, 0, permSum);
        ArrayList<Integer> permSumList = new ArrayList<>(permSum);
        Collections.sort(permSumList);
        int res = 1;
        for(int num : permSumList){
            if (res != num){
                System.out.println(res);
                return;
            } else {
                res++;
            }
        }
        System.out.println(permSumList.get(permSumList.size() - 1) + 1);
    }

    public static void getPermSum(int start, int cur, Set<Integer> res){
        for(int i=start;i<arr.length;i++){
            res.add(cur + arr[i]);
            getPermSum(i+1, cur + arr[i], res);
        }
    }
}
