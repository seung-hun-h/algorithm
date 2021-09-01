from sys import stdin
import collections
readline = stdin.readline

N = int(readline())
countries = collections.defaultdict(int)

def solve():
    _sum = 0
    for _ in range(N):
        country, people = map(int, readline().split())
        countries[country] = people
        _sum += people

    _sum /= 2
    temp, res = 0, 1
    for key in sorted(countries):
        temp += countries[key]
        res = key
        if temp >= _sum:
            break

    print(res)
solve()

"""
해결: O
시간: 6분
"""