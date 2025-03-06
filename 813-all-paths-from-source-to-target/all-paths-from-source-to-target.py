from typing import List

class Solution:
    def findPaths(self, ans: List[List[int]], path: List[int], sr: int, des: int, adj: List[List[int]]):
        if sr == des:
            ans.append(list(path))  
            return
        for num in adj[sr]:
            path.append(num)
            self.findPaths(ans, path, num, des, adj)
            path.pop() 

    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        n = len(graph)
        sr = 0
        des = n - 1
        ans = []
        path = [sr]
        self.findPaths(ans, path, sr, des, graph)
        return ans