from sys import stdin

readline = stdin.readline

def count_paper():
    arr = input_arr.copy()
    count = [0] * 3
    divide(arr, count, N, 0, 0)

    for c in count:
        print(c)

    
def divide(arr, count, n, row, col):
    if n == 1:
        count[arr[row][col]+1] += 1
        return
    
    flag = True
    for i in range(row, row+n):
        if not flag:
            break
        for j in range(col, col+n):
            if arr[i][j] != arr[row][col]:
                flag = False
                break
    
    if flag:
        count[arr[row][col] + 1] += 1
    else:
        n = n // 3
        # 9 등분
        for i in range(9):
            divide(arr, count, n, row + n * dr[i], col + n * dc[i])


if __name__ == "__main__":
    N = int(readline())
    input_arr = [list(map(int, list(readline().split()))) for _ in range(N)]
    dr = [0, 0, 0, 1, 1, 1, 2, 2, 2]
    dc = [0, 1, 2, 0, 1, 2, 0, 1, 2]
    count_paper()