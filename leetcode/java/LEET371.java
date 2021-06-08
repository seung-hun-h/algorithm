public class LEET371 {

    public static int getSum(int a, int b) {
        int MASK = 0xFFFFFFFF;
        
        while(b != 0) {
            int temp = a;
            a = (a ^ b) & MASK;
            b = ((temp & b) << 1) & MASK;
        }
        
        if(a > Integer.MAX_VALUE) {
            a = ~(a ^ MASK);
        }
        return a;
    }
}