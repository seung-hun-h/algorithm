from sys import stdin
readline = stdin.readline


def main():
    # 주사위의 인덱스가 가리키는 방향
    # 0: 상, 1: 전, 2: 동, 3: 서, 4: 후, 5: 하
    # 남: 후 > 상, 상 > 전, 하 > 후, 전 > 하
    # 북: 상 > 후, 전 > 상, 후 > 하, 하 > 전
    # 동: 상 > 동, 서 > 상, 하 > 서, 동 > 하
    # 서 : 상 > 서, 동 > 상, 하 > 동, 서 > 하
    d = [x, y]
    for c in com:
        # 동
        if c == 1:
            if d[1]+1 >= M: continue
            d[1] += 1
            # 주사위 이동
            up = dice[0]
            dice[0] = dice[3]
            dice[3] = dice[5]
            dice[5] = dice[2]
            dice[2] = up

        # 서
        elif c == 2:
            if d[1]-1 < 0: continue
            
            d[1] -= 1
            # 주사위 이동
            up = dice[0]
            dice[0] = dice[2]
            dice[2] = dice[5]
            dice[5] = dice[3]
            dice[3] = up


        # 북
        elif c == 3:
            if d[0]-1 < 0: continue
            d[0] -= 1
            # 주사위 이동
            up = dice[0]
            dice[0] = dice[1]
            dice[1] = dice[5]
            dice[5] = dice[4]
            dice[4] = up

        # 남
        else:
            if d[0]+1 >= N: continue
            d[0] += 1
            # 주사위 이동
            up = dice[0]
            dice[0] = dice[4]
            dice[4] = dice[5]
            dice[5] = dice[1]
            dice[1] = up
        # 주사위 바닥 값 처리
        if _map[d[0]][d[1]] == 0:
            _map[d[0]][d[1]] = dice[5]
        else:
            dice[5] = _map[d[0]][d[1]]
            _map[d[0]][d[1]] = 0
        # print(c)
        print(dice[0])
        # for m in _map:
        #     print(m)

if __name__ == '__main__':
    N, M, x, y, K = map(int, readline().split())
    _map = [list(map(int, readline().split())) for _ in range(N)]
    dice = [0] * 6
    com = list(map(int, readline().split()))
    main()
