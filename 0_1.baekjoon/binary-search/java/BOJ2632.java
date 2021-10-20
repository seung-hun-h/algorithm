import java.util.*;
import java.io.*;
public class BOJ2632 {
    static int T, N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(br.readLine());
        }

        int[] stackSumA = getStackSum(A);
        int[] stackSumB = getStackSum(B);

        Map<Integer, Integer> ACount = getCountAsMap(stackSumA);
        Map<Integer, Integer> BCount = getCountAsMap(stackSumB);
        binarySearch(ACount, BCount);
    }
    public static int[] getStackSum(int[] arr){
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        int end = arr.length - 1; 
        while(true){
            int i = start;
            int sum = 0;
            while(i != end){
                sum += arr[i];
                if(sum > T) break;
                res.add(sum);

                i = (i + arr.length + 1) % arr.length;
            }

            start = (start + arr.length + 1) % arr.length;
            end = (start + arr.length - 1) % arr.length;
            if(start == 0) break;
        }
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        if(sum <= T){
            res.add(sum);
        }
        int[] returnValue = new int[res.size()];
        for(int i=0;i<res.size();i++){
            returnValue[i] = res.get(i);
        }
        
        return returnValue;
    }
    public static void binarySearch(Map<Integer, Integer> ACount, Map<Integer, Integer> BCount){
        ArrayList<Integer> arr1 = new ArrayList<>(ACount.keySet());
        ArrayList<Integer> arr2 = new ArrayList<>(BCount.keySet());

        Collections.sort(arr1);
        Collections.sort(arr2);

        int left = 0, right = arr2.size() - 1;
        int res = ACount.getOrDefault(T, 0) + BCount.getOrDefault(T, 0);

        while(left < arr1.size() && right >= 0){
            int cur = arr1.get(left) + arr2.get(right);

            if(cur > T){
                right--;
            } else if(cur < T){
                left++;
            } else {
                res += (ACount.get(arr1.get(left)) * BCount.get(arr2.get(right)));
                left++;
                right--;
            }
        }
        System.out.println(res);
    }
    public static Map<Integer, Integer> getCountAsMap(int[] arr){
        Map<Integer, Integer> count = new HashMap<>();

        for(int num : arr){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}
