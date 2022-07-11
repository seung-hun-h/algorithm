public class Roman_To_Integer {
    public int romanToInt(String s) {
        int[] numbers = new int[s.length()];
        for (int i=0;i<s.length();i++) {
            switch (s.charAt(i)) {
                case 'I' -> numbers[i] = 1;
                case 'V' -> numbers[i] = 5;
                case 'X' -> numbers[i] = 10;
                case 'L' -> numbers[i] = 50;
                case 'C' -> numbers[i] = 100;
                case 'D' -> numbers[i] = 500;
                case 'M' -> numbers[i] = 1000;
            }
        }

        int answer = numbers[numbers.length - 1];
        for (int i=0;i<numbers.length - 1;i++) {
            if (numbers[i] < numbers[i + 1]) {
                answer -= numbers[i];
            } else {
                answer += numbers[i];
            }
        }

        return answer;
    }
}
