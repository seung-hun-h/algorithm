from sys import stdin
readline = stdin.readline

N, C = map(int, readline().split())
M = int(readline())
works = sorted([list(map(int, readline().split())) for _ in range(M)], key = lambda x : x[1])

def solve():
    result = [0] * (N+1)
    total = 0

    for i in range(M):
        _from, to, box = works[i]
        # From ~ To까지 짐을 싣고 가야한다.
        # From ~ To 구간에서 가장 많이 실려 있는 짐의 양을 구한다.
        _max = max(result[_from:to])

        # C - _max > box인 경우 , 현재 실을 box 보다 실을 수 있는 여유 공간이 크기 때문에 box만큼 싣는다.
        # C - _max < box인 경우 ,여유 공간보다 box가 많기 때문에 여유 공간만큼만 싣는다.
        possible = min(C-_max, box)
        
        total += possible
        for j in range(_from, to):
            result[j] += possible

    print(total)
solve()
"""
N, C = map(int, readline().split())
M = int(readline())
works = collections.defaultdict(list)
for _ in range(M):
    _from, to, boxes = map(int, readline().split())
    works[_from].append([to, boxes])

def solve():
    result = collections.defaultdict(int)
    current = 0
    for _from in sorted(works):
        current -= result[_from]
        if current >= C: continue
        for to, boxes in sorted(works[_from], key = lambda x : x[0]):
            if current + boxes >= C:
                resid = C - current
                current += resid
                result[to] += resid
                break

            current += boxes
            result[to] += boxes

    print(sum(result.values()))
solve()

만약 1번 마을에서 실을 짐이 
한참 멀리 떨어진 마을에 배달할 짐이라면,
중간에 짧은 거리에 배달하는 짐을 실을 수 없다.
따라서 도착 마을을 기준으로 정렬한다.
"""
"""
해결: X
시간: 45분
"""