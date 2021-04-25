import random

arr = [0, 2, 3, 4, 5, 6, 7, 7, 7, 9]

def binary_search(target):
    left, right = 0, len(arr) - 1

    while left < right:
        mid = (left + right) // 2
        print(left, right)
        if arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    print(left, right)
binary_search(3)