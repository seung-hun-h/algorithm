public class String_to_Integer {
    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MIN_VALUE;
    public int myAtoi(String s) {
        /**
         1. ignore leading white space
         2. determine negative or positve
         3. read until non-digit
         4. check limit
         */
        String ignoredLeadingWhiteSpace = ignoreLeadingWhiteSpace(s);
        boolean isNegative = isNegative(ignoredLeadingWhiteSpace);
        String number = parseNumber(ignoredLeadingWhiteSpace);
        number = trimZero(number);

        if (number.isEmpty()) {
            return 0;
        }

        if (isOverLimit(number, isNegative)) {
            return isNegative ? MIN : MAX;
        }

        return Integer.parseInt(number) * (isNegative ? -1 : 1);
    }

    private String ignoreLeadingWhiteSpace(String input) {
        int i=0;
        for (;i<input.length();i++) {
            if (!Character.isWhitespace(input.charAt(i))) {
                break;
            }
        }

        return input.substring(i);
    }

    private boolean isNegative(String input) {
        if (input.isEmpty()) {
            return false;
        }
        return input.charAt(0) == '-';
    }

    private String parseNumber(String input) {
        if (input.isEmpty()) {
            return "";
        }

        int start = 0;
        if (input.charAt(0) == '-' || input.charAt(0) == '+') {
            start++;
        }

        int i=start;
        for (;i<input.length();i++) {
            if (!Character.isDigit(input.charAt(i))) break;
        }

        return input.substring(start, i);
    }

    private boolean isOverLimit(String number, boolean isNegative) {
        String absolute = isNegative ? String.valueOf(MIN).substring(1) : String.valueOf(MAX);
        if (number.length() < absolute.length()) {
            return false;
        } else if (number.length() > absolute.length()) {
            return true;
        }
        return number.compareTo(absolute) >= 0;
    }

    private String trimZero(String number) {
        int end = 0;
        for (;end < number.length();end++) {
            if (!Character.isDigit(number.charAt(end))) {
                return "";
            }

            if (number.charAt(end) != '0') break;
        }

        return number.substring(end);
    }
}
