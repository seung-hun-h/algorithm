from sys import stdin, setrecursionlimit
readline = stdin.readline
setrecursionlimit(10 ** 6)

def solve():
    node = readline().rstrip()
    arr = []
    
    while node:
        arr.append(int(node))
        node = readline().rstrip()

    dfs(arr, 0, len(arr)-1)

def dfs(arr, start , end):
    if start <= end:
        root = arr[start]
        left = right = start+1

        while right <= end:
            if arr[right] > root:
                break
            right += 1
        
        dfs(arr, left, right-1)
        dfs(arr, right, end)

        print(root)

solve()