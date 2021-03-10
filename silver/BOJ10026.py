from sys import stdin, maxsize
from collections import deque

readline = stdin.readline

def count_blob():
    image = [list(readline().strip()) for _ in range(N)]
    visited = [[False] * N for _ in range(N)]

    normal = 0
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                normal += 1
                find_normal_blob(image, visited, i, j, image[i][j])

    visited = [[False] * N for _ in range(N)]
    odd = 0
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                odd += 1
                find_odd_blob(image, visited, i, j, image[i][j])

    print(normal, odd)

    
def find_odd_blob(image, visited, row, col, flag):
    q = deque()
    q.append([row, col])

    while q:
        r, c = q.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            
            if 0 <= nr < N and 0 <= nc < N and not visited[nr][nc]:
                if flag == "G" or flag == "R":
                    if image[nr][nc] == "G" or image[nr][nc] == "R": 
                        q.append([nr, nc])
                        visited[nr][nc] = True
                else:
                    if image[nr][nc] == flag:
                        q.append([nr, nc])
                        visited[nr][nc] = True

def find_normal_blob(image, visited, row, col, flag):
    q = deque()
    q.append([row, col])

    while q:
        r, c = q.popleft()

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 0 <= nr < N and 0 <= nc < N and not visited[nr][nc] and image[nr][nc] == flag:
                q.append([nr, nc])
                visited[nr][nc] = True        

if __name__ == "__main__":
    N = int(readline().strip())
    dr = [0, 0, 1, -1]
    dc = [1, -1, 0, 0]
    count_blob()