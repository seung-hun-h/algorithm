import java.io.*;
import java.util.*;
public class BOJ1253 {
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
        Arrays.sort(arr);
        solve();
    }
    public static void solve(){
        int res = 0;
        for(int i=0;i<N;i++){
            int[] arrSplit = splitArray(i);
            if(binarySearch(arr[i], arrSplit)){
                res++;
            }
        }
        System.out.println(res);
    }
    public static boolean binarySearch(int target, int[] arrSplit){
        int left = 0; int right = N-2;

        while(left < right){
            int cur = arrSplit[left] + arrSplit[right];
            if(cur > target){
                right--;
            } else if(cur < target){
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
    public static int[] splitArray(int idx){
        int[] temp = new int[N-1];
        int i = 0;
        for(int j=0;j<N;j++){
            if(j==idx) continue;
            temp[i] = arr[j];
            i++;
        }
        return temp;
    }
}
