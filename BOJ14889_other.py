from sys import stdin
from itertools import combinations

readline = stdin.readline


if __name__ == "__main__":
    N = int(readline())
    _map = [list(map(int, readline().split())) for _ in range(N)]

    # 각 인원당 가능한 팀 스탯의 합
    n_stat = [sum(i) + sum(j) for i ,j in zip(_map, zip(*_map))]
    # n_stat에는 인원 조합이 두번씩 들어감
    all_stat = sum(n_stat) // 2
    _min = 100 * N ** 2 + 1

    # 팀을 절반으로 나눔
    # 각 인원이 구성할 수 있는 모든 팀의 경우를
    # combinations로 뽑는다.
    # stat의 합을 all_stat에서 빼면 두 번 뺴지는 셀이 존재
    # 두 번 빠지는 셀끼리 팀을 이루고, 그 외 인원들이 팀을 이룸
    print(min([abs(all_stat - sum(stat)) for stat in combinations(n_stat, N//2)])) 