import java.util.*;
import java.io.*;

public class BOJ1208 {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solve();
    }
    public static void solve(){
        int[] left = split_array(0, N/2);
        int[] right = split_array(N/2, N);

        ArrayList<Integer> leftPermSum = new ArrayList<>();
        ArrayList<Integer> rightPermSum = new ArrayList<>();

        get_perm_sum(left, 0, 0, leftPermSum);
        get_perm_sum(right, 0, 0, rightPermSum);
        
        Map<Integer, Integer> leftCount = countAsMap(leftPermSum);
        Map<Integer, Integer> rightCount = countAsMap(rightPermSum);
    
        long ans = binarySearch(leftCount, rightCount);
        System.out.println(ans);
    }
    public static long binarySearch(Map<Integer, Integer> count1, Map<Integer, Integer> count2){
        long res = 0;
        ArrayList<Integer> key1 = new ArrayList<>(count1.keySet()); 
        ArrayList<Integer> key2 = new ArrayList<>(count2.keySet());
        
        Collections.sort(key1);
        Collections.sort(key2);

        int left = 0, right = key2.size() - 1;
        res += count1.getOrDefault(S, 0) + count2.getOrDefault(S, 0);

        while (left < key1.size() && right >= 0){
            int cur = key1.get(left) + key2.get(right);
        
            if(cur < S){
                left++;
            } else if(cur > S){
                right--;
            } else {
                res += ((long)count1.get(key1.get(left)) * count2.get(key2.get(right)));

                left++;
                right--;
            }
        }

        return res;
    }
    public static Map<Integer, Integer> countAsMap(ArrayList<Integer> sum){
        Map<Integer, Integer> count = new HashMap<>();

        for(int num : sum){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return count;
    }
    public static void get_perm_sum(int[] array, int start, int cur, ArrayList<Integer> res){
        for(int i=start;i<array.length;i++){
            res.add(cur + array[i]);
            get_perm_sum(array, i+1, cur+array[i], res);
        }
    }
    public static int[] split_array(int start, int end){
        int[] res = new int[end-start];
        int idx = 0;
        for(int i=start;i<end;i++){
            res[idx++] = arr[i];
        }
        return res;
    }
}
