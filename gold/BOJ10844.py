from sys import stdin
readline = stdin.readline

MOD = 1000000000
def main():
    N = int(readline().strip())
    d = [[0] * 11 for _ in range(2)]

    for i in range(1, 10):
        d[1][i] = 1

    ans = 9
    for i in range(2, N+1):
        ans = 0
        for j in range(10):
            d[i%2][j] = (d[(i-1)%2][j-1] + d[(i-1)%2][j+1]) % MOD
            ans += d[i%2][j] % MOD
            
    print(ans % MOD)


if __name__=="__main__":
    main()