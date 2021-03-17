from sys import stdin
readline = stdin.readline

cols = dict()
for key, value in zip(['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'], range(1, 9)):
    cols[key] = value

moves = {"R": (1, 0), "L": (-1, 0), "B": (0, -1), "T": (0, 1), 
        "RT": (1, 1), "LT":(-1, 1), "RB":(1, -1), "LB": (-1, -1)}

king, stone, N = map(list, readline().split())
N = int(''.join(N))
king[0], king[1] = cols[king[0]], int(king[1])
stone[0], stone[1] = cols[stone[0]], int(stone[1])

def solve():
    for _ in range(N):
        command = readline().strip()
        k_c, k_r = king
        nk_c, nk_r = k_c + moves[command][0], k_r + moves[command][1]

        # 킹이 밖으로 나갈 경우 건너 뜀
        if nk_r < 1 or nk_r > 8 or nk_c < 1 or nk_c > 8:
            continue
            
        if nk_c == stone[0] and nk_r == stone[1]:
            ns_c, ns_r = stone[0] + moves[command][0], stone[1] + moves[command][1]
            # 돌이 밖으로 나갈 경우 건너 뜀
            if ns_r < 1 or ns_r > 8 or ns_c < 1 or ns_c > 8:
                continue
            # 킹의 이동이 돌을 밀어 내고 
            # 밀어낸 돌이 밖으로 나가지 않을 경우
            # 돌의 위치를 업데이트한다.
            stone[0] = ns_c
            stone[1] = ns_r
        
        # 킹의 이동이 밖으로 나가지 않고
        # 그 이동으로 인해 돌이 밖으로 나가지 않은 경우
        # 킹의 위치를 업데이트 한다.
        king[0] = nk_c
        king[1] = nk_r
    
    str_king = ''
    str_stone = ''
    for key, value in cols.items():
        if king[0] == value:
            str_king = key
        if stone[0] == value:
            str_stone = key
    
    str_king += str(king[1])
    str_stone += str(stone[1])
    print(str_king)
    print(str_stone)

solve()