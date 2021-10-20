from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 6)
readline = stdin.readline

sequence = readline().strip()

def solve():
    substring = set()
    for i in range(len(sequence)):
        for j in range(i+1, len(sequence)+1):
            substring.add(sequence[i:j])
    print(len(substring))
    
solve() 