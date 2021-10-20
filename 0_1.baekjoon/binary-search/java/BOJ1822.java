import java.util.*;
import java.io.*;
public class BOJ1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> A  = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            B.add(Integer.parseInt(st.nextToken()));
        }
        
        A.removeAll(B);
        ArrayList<Integer> AList = new ArrayList<>(A);
        Collections.sort(AList);
        System.out.println(A.size());
        for(int i=0;i<AList.size();i++){
            System.out.print(AList.get(i)+" ");
        }
    }
}
