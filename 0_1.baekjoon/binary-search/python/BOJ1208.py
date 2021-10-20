from sys import stdin
from collections import defaultdict
readline = stdin.readline

N, S = map(int, readline().split())
arr = list(map(int, readline().split()))


def solve():
    left, right = split_array()

    left_perm_sum = []
    right_perm_sum = []    
    
    get_perm_sum(left, 0, 0, left_perm_sum)
    get_perm_sum(right, 0, 0, right_perm_sum)
    
  
    left_count = count_as_dict(left_perm_sum)
    right_count = count_as_dict(right_perm_sum)

    ans = binary_search(left_count, right_count)

    print(ans)

def count_as_dict(array):
    count = defaultdict(int)
    for num in array:
        count[num] = count[num] + 1
    return count

def binary_search(count1, count2):
    res = 0
    key1, key2 = list(sorted(list(count1.keys()))), list(sorted(list(count2.keys()))) 
    left, right = 0, len(key2) - 1
    res = count1[S] + count2[S]

    while left < len(key1) and right >= 0:
        cur = key1[left] + key2[right]

        if cur < S:
            left +=1
        elif cur > S:
            right -= 1
        else:
            res += (count1[key1[left]] * count2[key2[right]])
            left += 1
            right -= 1

    return res

def split_array():
    mid = len(arr) // 2
    left, right = arr[:mid], arr[mid:]

    return left, right

def get_perm_sum(array, start, _sum, res):
    for i in range(start, len(array)):
        res.append(_sum+array[i])
        get_perm_sum(array, i+1, _sum+array[i], res)

solve()