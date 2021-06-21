def solution(places):
    return [is_ok(place) for place in places]
def is_ok(place):
    for p in place:
        print(p)
    print()
    for i in range(25):
            r, c = i // 5, i % 5
            if place[r][c] == "P":
                for j in range(i+1, 25):
                    y, x = j // 5, j % 5
                    if place[y][x] == "P":
                        print(r,c ,y, x)
                        # 1 맨하탄 거리 1은 무조건 안됨
                        if abs(r-y) + abs(c-x) == 1:
                            return 0
                        # 2 맨하탄 거리는 파티션 확인
                        elif abs(r-y) + abs(c-x) == 2:
                            # 2-1 같은 행에 있는 경우
                            if r == y and place[r][c+1] != "X":
                                return 0
                            # 2-2 같은 열에 있는 경우
                            if c == x and place[r+1][c] != "X":
                                return 0
                            # 엇갈린 경우
                            if r != y and c != x:
                                if not (place[r+1][c] == "X" and place[y-1][x] == "X"):
                                    return 0
    return 1

res = solution([["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]])
print(res)
    