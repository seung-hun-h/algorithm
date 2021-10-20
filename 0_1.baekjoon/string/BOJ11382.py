from sys import stdin 
from collections import Counter 
readline = stdin.readline

N = int(readline().strip())

def solve():
    for _ in range(N):
        l1, l2 = readline().split()
        count1, count2 = Counter(l1), Counter(l2)

        flag = True
        for k1, k2 in zip(sorted(count1), sorted(count2)):
            if k1 != k2 or count1[k1] != count2[k2]:
                print("Impossible")
                flag = False
                break
        if flag:
            print("Possible")
solve()