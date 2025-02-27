import math

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dp = [math.inf]*n
        dp[src] = 0
        for _ in range(k+1):
            new_dp = dp[:]
            for a, b, c in flights:
                new_dp[b] = min(new_dp[b], dp[a] + c)
            dp = new_dp
        return -1 if dp[dst] == math.inf else dp[dst]

        