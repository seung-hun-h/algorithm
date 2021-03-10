from sys import stdin
readline = stdin.readline

def main():
    for i in range(1, len(N)+1):
        cur = N[len(N)-i:]
        root1 = cur[0]
        root2 = cur[:2]
        
        # 음수가 포함 되어 있을 경우 불가능
        if not root1.isdigit(): 
            print(0)
            return

        # root1이 0일 경우 불가능
        if int(root1) == 0: 
            dp[i] = 0
            continue

        dp[i] = dp[i-1] % 1000000

        if int(root2) <= 26:
            dp[i] += dp[i-2] % 1000000

    print(dp[len(N)] % 1000000)


if __name__ == "__main__":
    N = readline().strip()

    if N == "0":
        print(0)
    # N이 1자리 수이면 변환 가능한 경우의 수는 1
    elif len(N) == 1:
        print(1)
    else:
        dp = [0] * (len(N)+1)
        dp[0] = 1
        
        main()
