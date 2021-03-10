from sys import stdin
readline = stdin.readline

def main():
    _max = 0
    for i in range(1, N+1):
        t, p = info[i]
        _max = max(_max, dp[i])

        if i+t >= N+1: continue
        
        dp[i+t] = max(dp[i+t], _max+p)

    print(max(dp))

if __name__ == '__main__':
    N = int(readline())
    dp = [0] * (N+2)
    info = [[]]
    for _ in range(N):
        info.append(list(map(int, readline().split())))
    main()