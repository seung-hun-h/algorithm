from sys import stdin
readline = stdin.readline


def dfs(digits, cnt):
    global ans
    if digits == n:
        if cnt == 0:
            ans += 1
        return
    
    for i in range(10):
        if must[i]:
            must[i] = False
            dfs(digits+1, cnt-1)
            must[i] = True
        else:
            dfs(digits+1, cnt)

if __name__ == "__main__":
    n, m = map(int, readline().split())
    must = [False] * 10

    for num in list(map(int, readline().split())):
        must[num] = True
    ans = 0
    dfs(0, m)
    print(ans)