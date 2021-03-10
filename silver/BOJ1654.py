from sys import stdin

readline = stdin.readline

def get_max_length():
    left = 0
    right = 2 ** 31 - 1
    ans = 0    
    while left <= right:
        mid = (left + right) // 2
        n_line = get_num_of_line(mid)

        if n_line < N:
            right = mid - 1
        else:
            left = mid + 1
            ans = mid

    return ans 


def get_num_of_line(mid):
    return sum([line//mid for line in arr])

if __name__ == "__main__":
    K, N = map(int, readline().split())
    arr = [int(readline().strip()) for _ in range(K)]

    print(get_max_length())