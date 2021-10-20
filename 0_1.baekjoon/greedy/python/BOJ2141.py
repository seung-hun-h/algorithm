from sys import stdin
readline = stdin.readline

N = int(readline())
town = []


def solve():
    _sum = 0
    for _ in range(N):
        seq, people = map(int, readline().split())
        town.append([seq, people])
        _sum += people

    town.sort(key = lambda x: x[0])
    
    # 각 사람들의 거리 합이 최소가 되기 위해서
    # 중간 지점을 찾아야한다.
    _sum /= 2
    temp = index = 0
    while temp < _sum:
        temp += town[index][1]
        index += 1

    print(town[index-1][0])
    
solve()

"""
해결: x
시간: 35분
"""
