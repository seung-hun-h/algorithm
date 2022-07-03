public class Reverse_Integer {
    private static final String MAX = String.valueOf(Integer.MAX_VALUE);
    private static final String MIN = String.valueOf(Integer.MIN_VALUE);

    public int reverse(int x) {
        if (x > 0) {
            return reverseHelp(String.valueOf(x), MAX);
        } else if (x < 0) {
            return -reverseHelp(String.valueOf(x).substring(1), MIN.substring(1));
        }
        return 0;
    }

    private int reverseHelp(String x, String max) {
        StringBuilder sb = new StringBuilder();
        String number = sb.append(x).reverse().toString();

        if (number.length() == max.length() && isBiggerThan(number, max)) {
            return 0;
        }
        return Integer.parseInt(number);
    }

    private boolean isBiggerThan(String target, String stand) {
        return target.compareTo(stand) > 0;
    }

}
