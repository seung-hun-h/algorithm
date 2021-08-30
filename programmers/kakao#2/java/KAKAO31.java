import java.util.*;
class KAKAO31 {
    class TrieNode {
        int count;
        Map<Character, TrieNode> children;
        
        TrieNode() {
            this.count = 0;
            this.children = new HashMap<>();
        }
    }
    
    class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        void insert(String word) {
            TrieNode node = root;
            
            for (char ch : word.toCharArray()) {
                node.count++;
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            
        }
        
        int search(String word) {
            TrieNode node = root;
            
            for (char ch : word.toCharArray()) {
                if (ch == '?')
                    return node.count;
                
                if (node.children.get(ch) == null)
                    return 0;
                
                node = node.children.get(ch);
            }
            
            return node.count;
        }
    }
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> tries = new HashMap<>();
        Map<Integer, Trie> reversedTries = new HashMap<>();
        
        for (String word : words) {
            tries.putIfAbsent(word.length(), new Trie());
            reversedTries.putIfAbsent(word.length(), new Trie());
            
            Trie trie = tries.get(word.length());
            Trie reversedTrie = reversedTries.get(word.length());
            
            trie.insert(word);
            reversedTrie.insert(new StringBuilder(word).reverse().toString());
        }
        
        
        int[] answer = new int[queries.length];
        int idx = 0;
        for (String query : queries) {
            Trie trie = null;
            
            if (query.charAt(0) == '?') {
                trie = reversedTries.get(query.length());
                query = new StringBuilder(query).reverse().toString();
            } else {
                trie = tries.get(query.length());
            }
            
            
            if (trie == null) {
                answer[idx++] = 0;
            } else {
                answer[idx++] = trie.search(query);
            }
        }
        
        return answer;
    }
}
/**
 * [카카오 2020 공채] 가사 검색
 * 해결: X
 */