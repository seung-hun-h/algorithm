import java.util.*;

public class KAKAO15 {
    class Solution {
        static List<HashSet<Integer>> combinedKey = new ArrayList<>();
        public int solution(String[][] relation) {
            int colLen = relation[0].length;
            List<HashSet<Integer>> candidateKey = new ArrayList<>();
            for (int size=1;size<=colLen;size++) {
                combineKey(0, size, colLen, new ArrayList<>());
            }
            System.out.println(combinedKey);
            for (HashSet<Integer> key : combinedKey) {
                if (isUnique(key, relation) && isMinimal(key, candidateKey)) {
                    candidateKey.add(key);
                }
            }
            return candidateKey.size();
        }

        private boolean isMinimal(HashSet<Integer> key, List<HashSet<Integer>> candidateKey) {
            for (HashSet<Integer> candidate : candidateKey) {
                if (key.containsAll(candidate))
                    return false;
            }
            return true;
        }

        private boolean isUnique(HashSet<Integer> key, String[][] relation) {
            HashSet<String> included = new HashSet<>();

            for (String[] tuple : relation) {
                String temp = "";

                for (int k : key) {
                    temp += tuple[k];
                }

                if (included.contains(temp)){
                    return false;
                }
                included.add(temp);
            }
            return true;
        }

        private void combineKey(int start, int size, int max, List<Integer> key) {
            if (key.size() == size) {
                combinedKey.add(new HashSet<>(key));
            }

            for (int i=start;i<max;i++) {
                key.add(i);
                combineKey(i+1, size, max, key);
                key.remove(key.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String[][] relations = {
            {"100","ryan","music","2"},
            {"200","apeach","math","2"},
            {"300","tube","computer","3"},
            {"400","con","computer","4"},
            {"500","muzi","music","3"},
            {"600","apeach","music","2"}
        };
        int result = new KAKAO15().new Solution().solution(relations);
        System.out.println(result);
    }
}
/***
 * [카카오 2019 공채] 후보키
 * 해결: O
 * 
 */