from sys import stdin
from collections import defaultdict
readline = stdin.readline

class TrieNode:
    def __init__(self):
        self.count = 0
        self.children = defaultdict(TrieNode)

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root

        for char in word:
            node = node.children[char]

        node.count += 1
    
    def search(self, word):
        node = self.root

        for char in word:
            if char not in node.children:
                return 0
            
            node = node.children[char]

        return node.count


N, M, K = map(int, readline().split())
board = [list(readline()) for _ in range(N)]
god_words = [readline().strip() for _ in range(K)]
D = ((-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1), (0, -1), (-1, -1))
trie = Trie()

def solve():
    for r in range(N):
        for c in range(M):
            trie.insert(board[r][c])
            permutate(r, c, board[r][c], 1)
    
    for i in range(K):
        print(trie.search(god_words[i]))

def permutate(row, col, current, depth):
    if depth == 5:
        return

    for i in range(8):
        nr, nc = (row + D[i][0] + N) % N, (col + D[i][1] + M) % M
        trie.insert(current + board[nr][nc])
        permutate(nr, nc, current + board[nr][nc], depth + 1)

    
solve()

