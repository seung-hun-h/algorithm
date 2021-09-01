import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ20166 {
    static class TrieNode {
        long count;
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
        
        public void insert(String word) {
            TrieNode node = this.root;

            for (char ch : word.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.count++;
        }

        public long search(String word) {
            TrieNode node = this.root;

            for (char ch : word.toCharArray()) {
                if (node.children.get(ch) == null) {
                    return 0;
                }
                node = node.children.get(ch);
            }

            return node.count;
        }
    }

    static Trie trie;
    static int N, M, K;
    static char[][] board;
    static String[] godWords;
    static int[] godWordsCount;
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
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j]);
                trie.insert(sb.toString());
                permutate(i, j, sb, 1);
                sb.setLength(0);
            }
        }

        for (int i = 0; i < K; i++) {
            godWords[i] = br.readLine();
            System.out.println(trie.search(godWords[i]));
        }
    }

    public static void permutate(int row, int col, StringBuilder current, int depth) {
        if (depth == 5)
            return;

        for (int i=0;i<8;i++) {
            int nr = (row + D[i][0] + N) % N;
            int nc = (col + D[i][1] + M) % M;
            
            current.append(board[nr][nc]);
            trie.insert(current.toString());
            permutate(nr, nc, current, depth + 1);
            current.setLength(current.length() - 1);
        }
    }
}
