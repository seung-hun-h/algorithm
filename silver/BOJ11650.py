from sys import stdin
from collections import deque

readline = stdin.readline

def main():
    quick_sort(points, 0, len(points)-1)
    for point in points:
        print(*point)

def quick_sort(points, start, end):
    if start < end:
        mid = partition(points, start, end)
        quick_sort(points, start, mid-1)
        quick_sort(points, mid+1, end)

def partition(points, start, end):
    x, y = points[end]
    idx = start
    for i in range(start, end+1):
        if points[i][0] < x or (points[i][0] == x and points[i][1] < y):
            temp = points[i]
            points[i] = points[idx]
            points[idx] = temp
            idx += 1

    temp = points[end]
    points[end] = points[idx]
    points[idx] = [x, y]
    return idx

if __name__ == "__main__":
    N = int(readline().strip())
    points = [[*map(int, readline().split())] for _ in range(N)]
    main()