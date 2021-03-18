from sys import stdin, setrecursionlimit
setrecursionlimit(10 ** 6)
readline = stdin.readline

N, row, col = map(int, readline().split())
N = 2 ** N

def solve(n, start_r, start_c, seq):
    if start_r >= N or start_c >= N or n < 2:
        return
    if n == 2:
        for r in range(start_r, start_r+n):
            for c in range(start_c, start_c+n):
                if r == row and c == col:
                    print(seq)
                    exit(0)
                seq +=1
        return

    dec_n = n // 2

    if start_r <= row < start_r + dec_n and start_c <= col < start_c + dec_n:
        solve(dec_n, start_r, start_c, seq)
    elif start_r <= row < start_r + dec_n and start_c + dec_n <= col < start_c + n:
        solve(dec_n, start_r, start_c+dec_n, seq+(dec_n**2))
    elif start_r+dec_n <= row < start_r + n and start_c <= col < start_c + dec_n:
        solve(dec_n, start_r+dec_n, start_c, seq+((dec_n**2)*2))
    else:
        solve(dec_n, start_r+dec_n, start_c+dec_n, seq+((dec_n**2)*3))

solve(N, 0, 0, 0)