from sys import stdin, setrecursionlimit
from collections import deque
setrecursionlimit(10 ** 6)
readline = stdin.readline

def main():
    arr = [int(readline().strip()) for _ in range(N)]

    # quick_sort(arr, 0, len(arr)-1)
    sorted_arr = counting_sort(arr)
    for num in sorted_arr:
        print(num)

def quick_sort(arr, start, end):
    if start < end:
        mid = partition(arr, start, end)
        quick_sort(arr, start, mid-1)
        quick_sort(arr, mid+1, end)

def partition(arr, start, end):
    x = arr[end]
    idx = start
    for i in range(start, end+1):
        if arr[i] < x:
            temp = arr[i]
            arr[i] = arr[idx]
            arr[idx] = temp
            idx+=1

    temp = arr[idx]
    arr[idx] = x
    arr[end] = temp
    return idx

def counting_sort(arr):
    count_arr = [0] * 1001
    sorted_arr = [0] * (N+1)
    # 카운팅
    for num in arr:
        count_arr[num] += 1

    # 누적합
    for i in range(1, 1001):
        count_arr[i] += count_arr[i-1]
    
    for num in arr:
        idx = count_arr[num]
        
        sorted_arr[idx] = num
        count_arr[num] -= 1
        
    return sorted_arr[1:]

if __name__ == "__main__":
    N = int(readline().strip())
    main()