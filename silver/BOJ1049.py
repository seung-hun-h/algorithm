from sys import stdin

readline = stdin.readline


def get_min_price():
    cur = min(min_each, min_pack)

    for i in range(2, N+1):
        # 기타줄을 살 수 있는 경우의 수
        # 패키지로만 구매
        # 패키지와 낱개 적절히 섞어 구매
        # i - 1개의 최소 구매가 + 1개 구매가
        only_pack = min_pack * ((i // 6) + 1)
        scramble = min_pack * (i // 6) + min_each * (i % 6)
        cur = min(only_pack, scramble, cur + min_each)

    return cur

if __name__ == "__main__":
    N, M = map(int, readline().split())
    min_each = 1001
    min_pack = 1001

    for _ in range(M):
        pack, each = map(int, readline().split())

        min_each = min(min_each, each)
        min_pack = min(min_pack, pack)
    
    print(get_min_price())