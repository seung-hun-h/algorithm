from sys import stdin
readline = stdin.readline

N = int(readline())
arr = list(map(int, readline().split()))
sorted_arr = list(sorted(list(set(arr))))

def solve():
    dict_idx = dict()
    for i in range(len(sorted_arr)):
        dict_idx[sorted_arr[i]] = i

    print(' '.join(map(str, [dict_idx[num] for num in arr])))
    
solve()
