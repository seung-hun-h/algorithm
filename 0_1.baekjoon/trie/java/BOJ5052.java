import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class BOJ5052 {
    static class TrieNode {
        boolean word;
        Map<Character, TrieNode> children;
        TrieNode() {
            word = false;
            children = new HashMap<>();
        }
    }

    static class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        boolean insert(String word) {
            TrieNode node = root;
            
            for (char ch : word.toCharArray()) {
                if (node.word)
                    return false;

                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }

            if (node.word)
                return false;

            node.word = true;
            
            return true;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            
            String[] numbers = new String[N];
            for (int j=0;j<N;j++) {
                numbers[j] = br.readLine();
            }

            Arrays.sort(numbers, (s1, s2) -> s1.length() - s2.length());
            
            checkConsistency(numbers);
            
        }
    }
    private static void checkConsistency(String[] numbers) {
        Trie trie = new Trie();

        for (String number : numbers) {
            if(!trie.insert(number)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}