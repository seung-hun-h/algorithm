def solution(maps, p, r):
    answer = 0
    N, M = len(maps), len(maps[0])

    for y in range(N):
        for x in range(M):
            # 1분면
            cnt1 = 0
            cnt2 = 0
            y1, x1 = y-1, x-1
            for y_offset in range(r//2):
                for x_offset in range(r//2):
                    if y_offset + x_offset >= r//2: continue
                    if not(0<=y1-y_offset<N and 0<=x1-x_offset<M): continue
                    if y_offset + x_offset >= (r//2)-1:
                        if maps[y1-y_offset][x1-x_offset] <= p // 2:
                            cnt1 += 1
                    else:
                        if maps[y1-y_offset][x1-x_offset] <= p:
                            cnt2 += 1
            # 2분면
            y2, x2 = y-1, x
            for y_offset in range(r//2):
                for x_offset in range(r//2):
                    if y_offset + x_offset >= r//2: continue
                    if not(0<=y2-y_offset<N and 0<=x2+x_offset<M): continue
                    if y_offset + x_offset >= (r//2)-1:
                        if maps[y2-y_offset][x2+x_offset] <= p // 2:
                            cnt1 += 1
                    else:
                        if maps[y2-y_offset][x2+x_offset] <= p:
                            cnt2 += 1
            # 3분면
            y3, x3 = y, x-1
            for y_offset in range(r//2):
                for x_offset in range(r//2):
                    if y_offset + x_offset >= r//2: continue
                    if not(0<=y3+y_offset<N and 0<=x3-x_offset<M): continue
                    if y_offset + x_offset >= (r//2)-1:
                        if maps[y3+y_offset][x3-x_offset] <= p // 2:
                            cnt1 += 1
                    else:
                        if maps[y3+y_offset][x3-x_offset] <= p:
                            
                            cnt2 += 1
            # 4분면
            for y_offset in range(r//2):
                for x_offset in range(r//2):
                    if y_offset + x_offset >= r//2: continue
                    if not(0<=y+y_offset<N and 0<=x+x_offset<M): continue
                    if y_offset + x_offset >= (r//2)-1:
                        if maps[y+y_offset][x+x_offset] <= p // 2:
                            cnt1 += 1
                    else:
                        if maps[y+y_offset][x+x_offset] <= p:
                            cnt2 += 1
            
            answer = max(answer, cnt1+cnt2)
    return answer

m = [[1, 28, 41, 22, 25, 79, 4], [39, 20, 10, 17, 19, 18, 8], [21, 4, 13, 12, 9, 29, 19], [58, 1, 20, 5, 8, 16, 9], [5, 6, 15, 2, 39, 8, 29],[39, 7, 17, 5, 4, 49, 5], [74, 46, 8, 11, 25, 2, 11]]
p, r = 19, 6

solution(m, p, r)