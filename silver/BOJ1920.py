from sys import stdin

readline = stdin.readline

def exist(target):
    left = 0
    right = N - 1

    while left < right:
        mid = (left + right) // 2
        
        if arr[mid] == target:
            return True

        if arr[mid] > target:
            right = mid - 1
        else:
            left = mid + 1

    return arr[left] == target


if __name__ == "__main__":
    N = int(readline().strip())
    arr = list(map(int, readline().split()))
    M = int(readline().strip())
    targets = list(map(int, readline().split()))
    
    arr.sort()
    
    for target in targets:
        if exist(target):
            print(1)
        else:
            print(0)