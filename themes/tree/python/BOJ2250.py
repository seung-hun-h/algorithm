from sys import stdin
import collections
readline = stdin.readline

N = int(readline())
tree = collections.defaultdict(list)
cols = collections.defaultdict(list) # 열 번호 저장
children = set() # 루트 노드를 구하기 위해 자식 노드를 저장한다.

for _ in range(N):
    u, v, w = map(int, readline().split())
    tree[u] = [v, w]
    children.add(v)
    children.add(w)

def solve():
    root = find_root()
    
    find_col_level(root, 1)

    result = [0, 0] # 0: level, 1: width
    for level in sorted(cols):
        width = max(cols[level]) - min(cols[level]) + 1
        if result[1] < width:
            result = [level, width]

    print(*result)

# 중위 순회
col = 1
def find_col_level(node, level):
    global col
    if node == -1:
        return
    
    find_col_level(tree[node][0], level+1)
    cols[level].append(col)
    col += 1
    find_col_level(tree[node][1], level+1)

def find_root():
    root = 1
    for i in range(1, N+1):
        if i not in children:
            root = i
            break
    return root

solve()

"""
해결: X
시간: 50분
"""