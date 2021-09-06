import java.io.*;
import java.util.*;

public class BOJ20164 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        
        String num = br.readLine();

        System.out.println(dfs(num));
    }
}