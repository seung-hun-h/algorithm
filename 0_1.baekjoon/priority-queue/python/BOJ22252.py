from sys import stdin
from collections import defaultdict
import heapq

readline = stdin.readline

info_dict = defaultdict(list)

def solve(): 
    ans = 0

    for _ in range(int(readline())):
        line = readline().split()
        name = line[1]

        if line[0] == '1':

            for value in map(int, line[3:]):
                heapq.heappush(info_dict[name], -value)
        else:
            for _ in range(int(line[2])):
                if empty(info_dict[name]): break

                ans += -heapq.heappop(info_dict[name])

    print(ans)

def empty(list):
    return len(list) == 0

solve()