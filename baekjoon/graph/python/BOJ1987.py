from sys import stdin
readline = stdin.readline

R, C = map(int, readline().split())
graph = [readline().strip() for _ in range(R)]
dr, dc = [1, -1, 0, 0], [0, 0, 1, -1]

def solve():
    result = 1
    q = set()
    q.add((0, 0, graph[0][0]))

    while q and result < 26:
        row, col, string = q.pop()

        result = max(result, len(string))

        for i in range(4):
            nr, nc = row + dr[i], col + dc[i]

            if (0 <= nr < R and 0 <= nc < C and graph[nr][nc] not in string):
                q.add((nr, nc, string + graph[nr][nc]))

    print(result)            
solve()