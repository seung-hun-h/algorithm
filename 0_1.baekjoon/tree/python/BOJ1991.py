from sys import stdin
from collections import defaultdict
from copy import deepcopy
readline = stdin.readline
N = int(readline())
def solve():
    tree = defaultdict(list)

    for _ in range(N):
        node, left, right = readline().split()
        tree[node].append(left)
        tree[node].append(right)
    
    iter_preorder(tree, 'A')
    print()
    iter_inorder(tree, 'A')
    print()
    iter_postorder(tree, 'A')

def iter_preorder(tree, node):
    stack = [node]

    while stack:
        node = stack.pop()
        if node == ".": continue
        print(node, end="")
        
        stack.append(tree[node][1])
        stack.append(tree[node][0])

def iter_inorder(tree, node):
    stack = []

    while stack or node:
        while node != '.':
            stack.append(node)
            node = tree[node][0]

        if not stack: break

        node = stack.pop()
        print(node, end='')
        node = tree[node][1]

def iter_postorder(tree, node):
    stack = []

    while stack or node:
        while node != '.':
            if tree[node][1] != '.':
                stack.append(tree[node][1])
            stack.append(node)
            node = tree[node][0]

        node = stack.pop()

        if tree[node][1] != '.' and stack and stack[-1] == tree[node][1]:
            stack.pop()
            stack.append(node)
            node = tree[node][1]
        else:
            print(node, end='')
            node = '.'
            
        if not stack:break

def preorder(tree, node):
    if node == ".": return
    print(node, end="")

    preorder(tree, tree[node][0])
    preorder(tree, tree[node][1])

def inorder(tree, node):
    if node == ".": return

    inorder(tree, tree[node][0])
    print(node, end="")
    inorder(tree, tree[node][1])

def postorder(tree, node):
    if node == ".": return

    postorder(tree, tree[node][0])
    postorder(tree, tree[node][1])
    print(node, end="")
solve()