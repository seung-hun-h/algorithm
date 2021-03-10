from sys import stdin
readline = stdin.readline


def dfs(num):
    if len(num) == M:
        print(" ".join(list(map(str, num))))
        return
    for i in range(N):
        if not visited[i]:
            visited[i] = True
            dfs(num + [arr[i]])
            visited[i] = False
            
if __name__ == "__main__":
    N, M = map(int, readline().split())
    arr = [i+1 for i in range(N)]
    visited = [False] * N

    for i in range(N):
        visited[i] = True
        dfs([arr[i]])
        visited[i] = False