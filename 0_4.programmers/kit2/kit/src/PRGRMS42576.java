import java.util.HashMap;
import java.util.Map;

public class PRGRMS42576 {
    public static void main(String[] args) {
        new PRGRMS42576().solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
    }
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> participantCount = new HashMap<>();

        increase(participant, participantCount);
        decrease(completion, participantCount);

        String answer = "";
        for (String name : participant) {
            if (participantCount.get(name) != 0) {
                answer = name;
                break;
            }
        }

        return answer;
    }

    private void decrease(String[] completion, Map<String, Integer> participantCount) {
        for (String name : completion) {
            participantCount.compute(name, (key, value) -> value - 1);
        }
    }

    private void increase(String[] participant, Map<String, Integer> participantCount) {
        for (String name : participant) {
            participantCount.put(name, participantCount.getOrDefault(name, 0) + 1);
        }
    }
}
