from sys import stdin
readline = stdin.readline

seq = list(map(int, readline().split()))

graph = [[i*2 for i in range(20)]]
graph.append([13, 16, 19])
graph.append([22, 24])
graph.append([28, 27, 26])
graph.append([25, 30, 35, 40])
ans = 0

piece = [[0, 0], [0, 0], [0, 0], [0, 0]]

def solve(idx, point):
    global ans
    if idx == len(seq):
        ans = max(ans, point)
        return
    
    moves = seq[idx]
    for i in range(4):
        current, _dir = piece[i]
        _next = current + moves
        origin_dir = _dir

        # 도착 칸에 위치한 말은 넘어간다.
        if current == -1: continue

        # 0번 방향의 5, 10, 15에서 출발하는 경우 지름길로
        if (current == 5 or current == 10 or current == 15) and _dir == 0:
            _dir = current // 5
            _next = moves - 1 
        
        # 1 - 3 루트의 크기를 넘으면 4루트로 넘어간다.
        if 0<_dir<=3 and _next >= len(graph[_dir]):
            _next -= len(graph[_dir])
            _dir = 4
        # 0 루트의 크기를 넘으면 4루트로 넘어간다.
        if _dir == 0 and _next >= len(graph[_dir]):
            temp = len(graph[_dir])
            _dir = 4
            _next = _next - temp + len(graph[_dir]) - 1

        # 도착지에 다다를 수 있는 경우는 4루트 경우 뿐
        # 4루트 크기를 넘어서면 도착지로 다다른 것으로 처리
        if _dir == 4 and _next >= len(graph[_dir]):
            piece[i] = [-1, _dir]
            solve(idx+1, point)
            piece[i] = [current, origin_dir]
            
        else:
            # 만약 도착지에 다른 말이 존재 한다면 
            # 다음 말을 선택
            # return이 아닌 continue!!!!!!!
            flag = True
            for j in range(4):
                    if _next == piece[j][0] and _dir == piece[j][1]:
                        flag = False
                        break
            if not flag: continue

            piece[i] = [_next, _dir]
            solve(idx+1, point + graph[_dir][_next])
            piece[i] = [current, origin_dir]
            

solve(0, 0)
print(ans)