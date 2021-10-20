import java.util.Arrays;

public class LEET179 {
    
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{8308,8308,830}));    
    }
    public static String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for(int i=0;i<asStrs.length;i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStrs, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        if(asStrs[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();

        for (String str : asStrs) {
            sb.append(str);
        }

        return sb.toString();
    }
}
