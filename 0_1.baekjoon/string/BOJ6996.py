from sys import stdin
from collections import Counter
readline = stdin.readline

N = int(readline())

def solve():
    for _ in range(N):
        word1, word2 = readline().split()

        if is_anagram(word1, word2):
            print(f'{word1} & {word2} are anagrams.')
        else:
            print(f'{word1} & {word2} are NOT anagrams.')
    

def is_anagram(word1, word2):
    count1, count2 = Counter(word1), Counter(word2)
    if len(count1) != len(count2):
        return False
    for k1, k2 in zip(sorted(count1), sorted(count2)):
        if k1 != k2 or count1[k1] != count2[k2]:
            return False
    return True

solve()