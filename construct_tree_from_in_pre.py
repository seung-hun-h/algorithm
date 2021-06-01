class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

"""
in_s: start index of inorder
in_e: end index of inorder
p_idx: current index of preorder
"""

def build_tree(inorder, preorder, in_s, in_e):
    global p_idx
    if in_s > in_e:
        return

    node = Node(preorder[p_idx])
    p_idx += 1

    index = search(inorder, in_s, in_e, node.value)

    node.left = build_tree(inorder, preorder, in_s, index-1)
    node.right = build_tree(inorder, preorder, index+1, in_e)

    return node

# find index of target in inorder from start to end
def search(inorder, start, end, target):
    for i in range(start, end+1):
        if inorder[i] == target:
            return i

p_idx = 0
def main():
    inorder = ['D', 'B', 'E', 'A', 'F', 'C']
    preorder = ['A', 'B', 'D', 'E', 'C', 'F']

    root = build_tree(inorder, preorder, 0, len(inorder)-1)

    postorder_travlesal(root)

def postorder_travlesal(node):
    if node:
        postorder_travlesal(node.left)
        postorder_travlesal(node.right)
        print(node.value, end=" ")


main()