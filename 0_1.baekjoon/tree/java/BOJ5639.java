import java.util.*;
import java.io.*;
public class BOJ5639 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();

        String node = br.readLine();
        while(!node.equals("")){
            arr.add(Integer.parseInt(node));
            node = br.readLine();
        }
        dfs(arr, 0, arr.size()-1);
    }
    public static void dfs(ArrayList<Integer> arr, int start, int end){
        if(start<=end){
            int root = arr.get(start);
            int left = start+1, right = start+1;
            while(right <= end){
                if(arr.get(right) > root)
                    break;
                right++;
            }

            dfs(arr, left, right-1);
            dfs(arr, right, end);
            System.out.println(root);
        }
    }
}
