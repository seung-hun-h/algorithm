from typing import *
import collections

class TrieNode:
    def __init__(self) -> None:
        self.children = collections.defaultdict(TrieNode)
        self.word_id = -1
        self.palindrome_word_ids = []

class Trie:
    def __init__(self) -> None:
        self.root = TrieNode()

    @staticmethod
    def is_palindrome(word: str) -> bool:
        return word == word[::-1]
    
    def insert(self, index: int, word: str) -> None:
        node = self.root

        for i, char in enumerate(reversed(word)):
            if self.is_palindrome(word[0:len(word)-i]):
                # node 앞 까지는 팰린드롬이다.
                node.palindrome_word_ids.append(index)
            
            node = node.children[char]
        # 단어 구분을 위해 마지막 노드에 인덱스 저장
        node.word_id = index

    def search(self, index: int, word: str) -> List[List[int]]:
        result = []
        node = self.root

        # 판별 3
        while word:
            if node.word_id >= 0:
                if self.is_palindrome(word):
                    result.append([index, node.word_id])
            node = node.children[word[0]]
            word = word[1:]
        
        # 판별 1
        if node.word_id >= 0 and node.word_id != index:
            result.append([index, node.word_id])
        
        # 판별 2
        for palindrome_id in node.palindrome_word_ids:
            result.append([index, palindrome_id])

        return result

class Solution:
    def palindromePairs(self, words: List[str]) -> List[List[int]]:
        trie = Trie()
        result = []

        for i, word in enumerate(words):
            trie.insert(i, word)
        
        for i, word in enumerate(words):
            result.extend(trie.search(i, word))

        return result