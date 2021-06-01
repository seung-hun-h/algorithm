class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

"""
in_s: start index of inorder
in_e: end index of inorder
p_idx: current index of postorder
"""

def build_tree(inorder, postorder, in_s, in_e):
    global p_idx
    if in_s > in_e:
        return

    node = Node(postorder[p_idx])
    p_idx -= 1

    index = search(inorder, in_s, in_e, node.value)

    node.right = build_tree(inorder, postorder, index+1, in_e)
    node.left = build_tree(inorder, postorder, in_s, index-1)

    return node

# find index of target in inorder from start to end
def search(inorder, start, end, target):
    for i in range(start, end+1):
        if inorder[i] == target:
            return i

p_idx = 0
def main():
    global p_idx
    inorder = ['D', 'B', 'E', 'A', 'F', 'C']
    postorder = ['D', 'E', 'B', 'F', 'C', 'A']

    p_idx = len(postorder) - 1
    root = build_tree(inorder, postorder, 0, len(inorder)-1)

    preorder_travlesal(root)

def preorder_travlesal(node):
    if node:
        print(node.value, end=" ")
        preorder_travlesal(node.left)
        preorder_travlesal(node.right)


main()