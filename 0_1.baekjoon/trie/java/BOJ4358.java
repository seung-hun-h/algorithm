import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class BOJ4358 {
    static class TrieNode {
        int count;
        Map<Character, TrieNode> children;
        TrieNode() {
            this.count = 0;
            this.children = new HashMap<>();
        }

    }

    static class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        public void insert(TrieNode node, char[] word, int idx) {
            if (idx == word.length) {
                node.count++;
                return;
            }

            node.children.putIfAbsent(word[idx], new TrieNode());
            insert(node.children.get(word[idx]), word, idx + 1);
        }

        public int search(String word) {
            TrieNode node = root;
            
            for (char ch : word.toCharArray()) {
                node = node.children.get(ch);
            }

            return node.count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        Set<String> words = new TreeSet<>();

        String line = "";
        Trie trie = new Trie();
        int total = 0;

        while((line = br.readLine()) != null && !"".equals(line)) {
            words.add(line);
            trie.insert(trie.root, line.toCharArray(), 0);
            total++;
        }

        Iterator<String> iter = words.iterator();
        
        while (iter.hasNext()) {
            String word = iter.next();
            System.out.println(String.format("%s %.4f", word, (trie.search(word) / (double)total) * 100));
        }
    }   
}
