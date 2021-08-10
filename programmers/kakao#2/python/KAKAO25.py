from sys import setrecursionlimit
setrecursionlimit(10 ** 9)
class Node:
    def __init__(self, value, x, y, left = None, right = None):
        self.value = value
        self.left = left
        self.right = right
        self.x = x
        self.y = y
    
    def __str__(self):
        return f'value = {self.value}, x = {self.x}, y = {self.y}'

index = 0
def solution(nodeinfo):
    global index
    nodes = [Node(index, info[0], info[1]) for index, info in enumerate(nodeinfo, 1)]    
    nodes.sort(key=lambda n: [-n.y, n.x])
    
    root = nodes[0]
    for i in range(1, len(nodes)):
        addNode(root, nodes[i])
    
    answer = [[0 for _ in range(len(nodes))] for _ in range(2)]
    preorder(answer[0], root)
    index = 0
    postorder(answer[1], root)
    return answer

def preorder(seq, node):
    global index
    if node is not None:
        seq[index] = node.value
        index += 1
        preorder(seq, node.left)
        preorder(seq, node.right)


def postorder(seq, node):
    global index
    if node is not None:
        postorder(seq, node.left)
        postorder(seq, node.right)
        seq[index] = node.value
        index += 1

def addNode(parent, child):
    if parent.x > child.x:
        if parent.left is None:
            parent.left = child
            return
        addNode(parent.left, child)
        return
    else:
        if parent.right is None:
            parent.right = child
            return
        addNode(parent.right, child)
        return

'''
[카카오 2019 공채] 길 찾기 게임
해결: X
'''