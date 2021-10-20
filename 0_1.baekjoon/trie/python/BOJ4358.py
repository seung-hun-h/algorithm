from collections import defaultdict
from sys import stdin

readline = stdin.readline

class TrieNode:
    def __init__(self):
        self.count = 0
        self.children = defaultdict(TrieNode)

class Trie:
    def __init__(self):
        self.root = TrieNode()
        self.total = 0

    def insert(self, word):
        node = self.root

        for char in word:
            node = node.children[char]

        node.count += 1
        self.total += 1

    def search(self, word):
        node = self.root

        for char in word:
            node = node.children[char]

        return node.count

def solution():
    trie = Trie()
    words = set()
    line = readline().strip()
    while line != None and line != "":
        words.add(line)
        trie.insert(line)
        line = readline().strip()

    for word in sorted(words):
        print("%s %.4f" % (word, trie.search(word) * 100 / trie.total))

solution()