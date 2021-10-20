import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ20166_2 {
    static class TrieNode {
        boolean word;
        long count;
        Map<Character, TrieNode> children;

        TrieNode() {
            this.word = false;
            this.count = 0;
            this.children = new HashMap<>();
        }
    }

    static class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode node = this.root;

            for (char ch : word.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.word = true;
        }

        public boolean search(String word) {
            TrieNode node = this.root;
            for (char ch : word.toCharArray()) {
                if (node.children.get(ch) == null) {
                    return false;
                }
                node = node.children.get(ch);
            }
            return node.word;
        }
    }
    static Trie trie;
    static int N, M, K;
    static char[][] board;
    static String[] godWords;
    static int[] godWordsCount;
    static Map<String, Integer> count;
    static int[][] D = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        trie = new Trie();

        board = new char[N][M];
        godWords = new String[K];
        godWordsCount = new int[K];
        count = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < K; i++) {
            godWords[i] = br.readLine();
            trie.insert(godWords[i]);
            count.putIfAbsent(godWords[i], 0);
        }

        for (int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                permutate(i, j, "" + board[i][j], 1);
            }
        }

        for (int i = 0; i < K; i++) {
            System.out.println(count.get(godWords[i]));
        }

    }

    public static void permutate(int row, int col, String current, int depth) {
        
        if (depth > 5)
            return;

        if (trie.search(current)) {
            count.computeIfPresent(current.toString(), (k, v) -> v + 1);
        }
        
        for (int i=0;i<8;i++) {
            int nr = (row + D[i][0] + N) % N;
            int nc = (col + D[i][1] + M) % M;
            permutate(nr, nc, current + board[nr][nc], depth+1);
        }
    }
}
