import java.util.*;
import java.io.*;

public class BOJ1450 {
    static int N, C;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }
    public static void solve(){
        long ans = 0;
        int[] left = split_arr(0, arr.length/2);
        int[] right = split_arr(arr.length/2, arr.length);

        ArrayList<Integer> left_sums = new ArrayList<>();
        ArrayList<Integer> right_sums = new ArrayList<>();

        
        get_perm_sums(left, 0, 0, left_sums);
        get_perm_sums(right, 0, 0, right_sums);
        
        left_sums.add(0);
        right_sums.add(0);
            
        Collections.sort(right_sums);

        for(int val : left_sums){
            int cnt = upper_bound(right_sums, C-val);
            ans += cnt;
        }
        System.out.println(ans);
    }
    public static int upper_bound(ArrayList<Integer> array, int val){
        int left = 0, right = array.size() - 1;

        while(left < right){
            int mid = (left + right) / 2;

            if(array.get(mid) <= val){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        if(array.get(right) <= val){
            right++;
        }
        return right;
    }
    public static void get_perm_sums(int[] array, int start, int cur, ArrayList<Integer> res){
        for(int i=start;i<array.length;i++){
            if(cur + array[i] <= C){
                res.add(cur + array[i]);
                get_perm_sums(array, i+1, cur + array[i], res);
            }
        }
    }
    public static int[] split_arr(int start, int end){
        int[] res = new int[end-start];
        int idx = 0;
        for(int i=start;i<end;i++){
            res[idx++] = arr[i];
        }
        return res;
    }
}
