from sys import stdin
readline = stdin.readline

T = int(readline())
arr = [0] * 101
arr[1] = arr[2] = arr[3] = 1
arr[4] = arr[5] = 2 



def solve():
    for _ in range(T):
        N = int(readline())

        find_triangle_length(N)

def find_triangle_length(n):
    temp = [arr[i] for i in range(101)]
    if n <= 5:
        print(temp[n])
        return

    for i in range(6, n+1):
        temp[i] = temp[i-1] + temp[i-5]

    print(temp[n])

solve()