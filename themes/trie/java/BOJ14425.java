import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class BOJ14425 {
    static int N, M;
    
    static class TrieNode {
        boolean word;
        Map<Character, TrieNode> children;
        
        TrieNode () {
            this.word = false;
            this.children = new HashMap<>();
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.word = true;
        }

        public boolean search(String word) {
            TrieNode node = root;

            for (char ch : word.toCharArray()) {
                if (node.children.get(ch) == null)
                    return false;

                node = node.children.get(ch);
            }
            
            return node.word;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
        
        Trie trie = new Trie();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            trie.insert(word);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            count += (trie.search(word) ? 1 : 0);
        }
        System.out.println(count);
    }
}