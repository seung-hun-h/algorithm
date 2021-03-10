from sys import stdin
from collections import deque

readline = stdin.readline

def get_min_moves():
    arr = [i for i in range(1, N+1)]
    front = 0
    moves = 0
    # 배열을 직접 순환하는 것이 아니라 front 인덱스를 가지고 순환하듯이 표현한다.
    # front과 target 사이의 정방향에 대한 거리와 역방향에 대한 거리 중 작은 것을 구한다.
    # 거리를 구한 후에는 front 인덱스를 이동하고, 원소를 제거한다.

    for target in list(map(int, readline().split())):
        target_idx = arr.index(target)
        moves += min(abs(front-target_idx), len(arr) - abs(front - target_idx))
        front = target_idx
        del arr[front]

    return moves

if __name__ == "__main__":
    N, M = map(int, readline().split())
    print(get_min_moves())