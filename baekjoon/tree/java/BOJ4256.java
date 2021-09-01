import java.util.*;
import java.io.*;
public class BOJ4256 {
    static int pIndex = 0;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int[] preorder = new int[N];
            int[] inorder = new int[N];

            String[] line = br.readLine().trim().split(" ");
            for(int j=0;j<N;j++){
                preorder[j] = Integer.parseInt(line[j]);
            }
            line = br.readLine().trim().split(" ");
            for(int j=0;j<N;j++){
                inorder[j] = Integer.parseInt(line[j]);
            }
            pIndex = 0;
            sb = new StringBuilder();
            postorderTravel(preorder, inorder, 0, N-1);
            System.out.println(sb.toString());
        }
    }
    public static void postorderTravel(int[] preorder, int[] inorder, int start, int end){
        if(start <= end){
            int node = preorder[pIndex++];
            for(int i=start;i<=end;i++){
                if(inorder[i] == node){
                    postorderTravel(preorder, inorder, start, i-1);
                    postorderTravel(preorder, inorder, i+1, end);
                    sb.append(node).append(" ");
                    break;
                }
            }
        }
    }
}
