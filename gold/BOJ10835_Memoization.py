from sys import stdin, setrecursionlimit
readline = stdin.readline

N = int(readline())
d = [[0]*(N+1) for _ in range(N+1)]
left = [0] + [*map(int, readline().split())]
right = [0] + [*map(int, readline().split())]

def main():
    for row in range(1, N+1):
        for col in range(1, N+1):
            if left[row] > right[col]:
                d[row][col] = max(d[row][col-1] + right[col], d[row-1][col], d[row-1][col-1])
            else:
                d[row][col] = max(d[row-1][col], d[row-1][col-1])
    
    print(d[N][N])

if __name__ == "__main__":
    main()