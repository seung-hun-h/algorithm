import java.io.*;
import java.util.*;

public class BOJ21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sequnce = br.readLine();

        System.out.println(getMaxNum(sequnce));
        System.out.println(getMinNum(sequnce));
    }

    private static String getMinNum(String sequnce) {
        StringBuilder result = new StringBuilder();
        int left = 0;
        for (; left < sequnce.length(); left++) {
            if (sequnce.charAt(left) != 'K')
                break;

            result.append(5);
        }

        int right = left;
        for(; right < sequnce.length(); right++) {
            if (sequnce.charAt(right) == 'K') {
                if (left != right)
                    result.append(convert(sequnce, left, right - 1));
                result.append(5);

                left = right + 1;
            }
        }

        if (sequnce.charAt(right - 1) == 'M') {
            result.append(convert(sequnce, left, right - 1));
        }

        return result.toString();
    }

    
    private static String getMaxNum(String sequnce) {
        StringBuilder result = new StringBuilder();
        int left = 0;
        for (; left < sequnce.length(); left++) {
            if (sequnce.charAt(left) != 'K')
                break;

            result.append(5);
        }

        int right = left;
        for(; right < sequnce.length(); right++) {
            if (sequnce.charAt(right) == 'K') {
                if (left != right) {
                    result.append(convert(sequnce, left, right));
                } else{
                    result.append(5);
                }

                left = right + 1;
            }
        }

        if (sequnce.charAt(right - 1) == 'M') {
            for (int i=left; i < right; i++) {
                result.append(1);
            }
        }

        return result.toString();
    }

    private static String convert(String sequnce, int left, int right) {
        StringBuilder sb = new StringBuilder();

        sb.append(1);

        for (int i=0;i<right - left;i++) {
            sb.append(0);
        }
        

        if (sequnce.charAt(right) == 'K') {
            sb.setCharAt(0, '5');
        }
        
        return sb.toString();
    }
}
