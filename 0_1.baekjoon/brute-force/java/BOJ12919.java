import java.io.*;
import java.util.*;

public class BOJ12919 {
    static String S, T;
    static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();
        dfs(T);
        System.out.println(result ? 1 : 0);
    }

    public static void dfs(String str) {
        if (str.length() == S.length()) {
            if (str.equals(S))
                result = true;
            return;
        }
        
        int len = str.length();
        
        if (str.charAt(len - 1) == 'A') {
            dfs(str.substring(0, len - 1));
        } 

        if (str.charAt(0) != 'A') {
            dfs(new StringBuilder(str).reverse().substring(0, len - 1));
        }
    }
}