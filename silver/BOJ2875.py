from sys import stdin

readline = stdin.readline

def main():
    teams = min(N//2, M)

    total = N + M

    rem = total - 3 * teams - K 
    if rem >= 0:
        print(teams)
    else:
        rem = abs(rem)
        quo = rem // 3
        remain = rem % 3

        if remain == 0:
            print(teams - quo)
        else:
            print(teams - quo - 1)
       


if __name__ == "__main__":
    N, M, K = map(int, readline().split())
    main()