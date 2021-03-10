from sys import stdin
readline = stdin.readline


def dfs(num):
    if len(num) == M:
        print(" ".join(list(map(str, num))))
        return
    for i in range(N):
        dfs(num + [arr[i]])
            
if __name__ == "__main__":
    N, M = map(int, readline().split())
    arr = [i+1 for i in range(N)]

    for i in range(N):
        dfs([arr[i]])