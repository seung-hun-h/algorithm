from typing import *
import collections

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        q = collections.deque([root])        
        res = ["#"]
        while q:
            node = q.popleft()
            if node:
                q.append(node.left)
                q.append(node.right)

                res.append(str(node.val))
            else:
                res.append("#")
        
        return ' '.join(res)
                
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if data == "# #":
            return None

        nodes = data.split()
        root = TreeNode(int(nodes[1]))
        q = collections.deque([root])
        index = 2

        while q:
            node = q.popleft()
            if nodes[index] is not "#":
                node.left = TreeNode(int(nodes[index]))
                q.append(node.left)
            index += 1

            if nodes[index] is not "#":
                node.right = TreeNode(int(nodes[index]))
                q.append(node.right)
            index += 1
        return root