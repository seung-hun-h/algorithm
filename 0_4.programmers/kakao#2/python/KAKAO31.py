from collections import defaultdict

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.count = 0

class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def insert(self, word):
        node = self.root
        
        for char in word:
            node.count += 1
            node = node.children[char]
            
    def search(self, word):
        node = self.root
        
        for char in word:
            if char == '?':
                return node.count
            
            if char not in node.children:
                return 0
            
            node = node.children[char]
            
        return node.count
            

def solution(words, queries):
    
    tries = defaultdict(Trie)
    reversed_tries = defaultdict(Trie)
    
    for word in words:
        trie = tries[len(word)]
        reversed_trie = reversed_tries[len(word)]
        
        trie.insert(word)
        reversed_trie.insert(word[::-1])
    
    answer = []
    
    for query in queries:
        if len(query) not in tries and len(query) not in reversed_tries:
            answer.append(0)
            continue
        
        if query[0] != "?":
            trie = tries[len(query)]
        
        else:
            trie = reversed_tries[len(query)]
            query = query[::-1]
            
        answer.append(trie.search(query))
    
    return answer

'''
[카카오 2020 공채] 가사 검색
해결: X
'''