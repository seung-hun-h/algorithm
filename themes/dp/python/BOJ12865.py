from sys import stdin
readline = stdin.readline

N, K = map(int, readline().split())
cargo = [list(map(int, readline().split())) for _ in range(N)]

def solve():
    pack = []
    for i in range(N+1):
        pack.append([])
        for c in range(K+1):
            if i == 0 or c == 0:
                pack[i].append(0)
            elif cargo[i-1][0] <= c:
                pack[i].append(max(
                    cargo[i-1][1] + pack[i-1][c - cargo[i-1][0]],
                    pack[i-1][c])
                )
            else:
                pack[i].append(pack[i-1][c])

    print(pack[-1][-1])
solve()

"""
해결: X
시간: 25분
너무 빨리 해답을 봤다. 이미 풀었던 문제인데 몰라서 마음이 급했다.
천천히하자
"""