from sys import stdin
from collections import Counter
readline = stdin.readline

def solve():
    count1 = Counter(readline().strip())
    count2 = Counter(readline().strip())

    ans = 0
    for key in count1:
        ans += abs(count1[key] - count2[key])

    for key in count2:
        if key not in count1:
            ans += count2[key]

    print(ans)

solve()