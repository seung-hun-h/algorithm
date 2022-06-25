import java.util.*;

public class PRGRMS42578 {
    public static void main(String[] args) {

    }
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> clotheMap = new HashMap<>();
        for (String[] clothe : clothes) {
            clotheMap.putIfAbsent(clothe[1], new ArrayList<>());
            clotheMap.get(clothe[1]).add(clothe[0]);
        }
        for (String clotheKey : clotheMap.keySet()) {
            answer *= (clotheMap.get(clotheKey).size() + 1);
        }
        return --answer;
    }
}
