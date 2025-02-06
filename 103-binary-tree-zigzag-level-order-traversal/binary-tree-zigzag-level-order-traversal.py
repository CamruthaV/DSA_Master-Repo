# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        if not root:
            return result

        queue = deque([root])
        flag = True

        while queue:
            n = len(queue)
            level_values = [0] * n

            for i in range(n):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

                if flag:
                    level_values[i] = node.val
                else:
                    level_values[n - 1 - i] = node.val

            flag = not flag
            result.append(level_values)

        return result 