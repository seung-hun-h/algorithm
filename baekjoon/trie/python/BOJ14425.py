from collections import defaultdict
from sys import stdin
readline = stdin.readline

class TrieNode:
    def __init__(self):
        self.word = False
        self.children = defaultdict(TrieNode)

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root

        for char in word:
            node = node.children[char]
        
        node.word = True
    
    def search(self, word):
        node = self.root

        for char in word:
            if char not in node.children:
                return False
            
            node = node.children[char]

        return node.word

N, M = map(int, readline().split())

def solution():
    trie = Trie()

    for _ in range(N):
        trie.insert(readline())

    count = 0
    for _ in range(M):
        if trie.search(readline()):
            count += 1
    print(count)    
solution();