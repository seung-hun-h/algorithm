from sys import stdin

readline = stdin.readline

def compress_arr():
    arr = input_arr.copy()
    divide(arr, N, 0, 0)

    
def divide(arr, n, row, col):
    # image를 분할하다 한 셀까지 분할하면 그 셀의 값 출력
    if n == 1:
        print(arr[row][col], end="")
        return
    
    flag = True
    for i in range(row, row+n):
        if not flag:
            break
        for j in range(col, col+n):
            if arr[i][j] != arr[row][col]:
                flag = False
                break
    
    # 나눈 한 구역의 값들이 모두 같을 경우 하나만 출력(Compression)
    if flag:
        print(arr[row][col], end="")
    else:
        n = n // 2
        # 4 등분
        print("(", end="")
        divide(arr, n, row, col) # 좌상단
        divide(arr, n, row, col + n) # 우상단
        divide(arr, n, row + n, col) # 좌하단 
        divide(arr, n, row + n, col + n) # 우하단
        print(")", end="")


if __name__ == "__main__":
    N = int(readline())
    input_arr = [list(map(int, list(readline().strip()))) for _ in range(N)]

    compress_arr()