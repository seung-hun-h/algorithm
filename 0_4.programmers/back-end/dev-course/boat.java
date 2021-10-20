public class boat {
    public int solution(int[] d, int m) {
        int current = 1;
        int cnt = 0;
        for (int boat : d) {
            cnt++;
            if (current > boat) {
                current = 1;
                continue;
            }

            m -= current;
            current *= 2;
            if (m <= 0)
                break;
            
        }

        return m <= 0 ? cnt : -1;
    }

    public static void main(String[] args) {
        int result = new boat().solution(new int[]{1, 3, 2, 5, 4}, 6);
        System.out.println(result);
        result = new boat().solution(new int[]{2, 2, 4, 3}, 6);
        System.out.println(result);
        result = new boat().solution(new int[]{2, 2, 4, 3}, 8);
        System.out.println(result);
    }
}
