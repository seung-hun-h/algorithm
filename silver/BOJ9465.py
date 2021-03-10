from sys import stdin

readline = stdin.readline

def get_max_score():
    N = int(readline())
    stickers = [list(map(int, readline().split())) for _ in range(2)]
    # 상단 스티커를 땐 경우
    # 하단 스티커를 땐 경우
    # 아무것도 때지 않은 경우
    up, down, none = 0, 0, 0

    for i in range(N):
        # 위 스티커를 땐 경우 > 이전 아래 스티커를 땐 경우, 아무것도 때지 않은 경우 중 큰 것
        # 아래 스티커를 땐 경우 > 이전 위 스티커를 땐 경우, 아무것도 때지 않은 경우 중 큰 것        
        # 아무것도 때지 않은 경우 > 이전의 위, 아래를 땐 경우 중 큰 것
        up, down, none = max(down, none) + stickers[0][i], max(up, none) + stickers[1][i], max(up, down)

    return max(none, up, down)


if __name__ == "__main__":
    T = int(readline())
    for _ in range(T):
        print(get_max_score())