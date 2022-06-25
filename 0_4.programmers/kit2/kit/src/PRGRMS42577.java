import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PRGRMS42577 {
    public static void main(String[] args) {

    }
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i=0;i<phone_book.length-1;i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
