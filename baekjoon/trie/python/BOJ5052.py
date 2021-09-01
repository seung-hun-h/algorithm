from sys import stdin
from collections import defaultdict
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
            if node.word:
                return False
            
            node = node.children[char]
        
        if node.word:
            return False
        
        node.word = True
        return True


T = int(readline())

def solve():

    for _ in range(T):
        N = int(readline())
        numbers = list(sorted([readline().strip() for _ in range(N)], key=lambda x: len(x)))
        check_consistency(numbers)

def check_consistency(numbers):
    trie = Trie()

    for number in numbers:
        if not trie.insert(number):
            print("NO")
            return
        
    print("YES")

solve()