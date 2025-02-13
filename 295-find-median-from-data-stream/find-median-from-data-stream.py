class MedianFinder:
    def __init__(self):
        self.maxHeap = [] # left side
        self.minHeap = [] # right side

    def addNum(self, num: int) -> None:
        # add a logic to add to right side or left side
        if len(self.minHeap) == len(self.maxHeap) == 0:
            heappush(self.minHeap, num)
        elif self.minHeap[0] >= num:
            heappush(self.maxHeap, -num)
        else:
            heappush(self.minHeap, num)

        # balance out the left and right side
        if len(self.minHeap) - len(self.maxHeap) > 1:
            heappush(self.maxHeap, -heappop(self.minHeap))

        if len(self.maxHeap) - len(self.minHeap) > 1:
            heappush(self.minHeap, -heappop(self.maxHeap))

    def findMedian(self) -> float:
        if (len(self.minHeap) + len(self.maxHeap)) % 2 == 1:
            if len(self.minHeap) > len(self.maxHeap):
                # minimum element from the right side
                return self.minHeap[0]
            else:
                # maximum element from the right side
                return -self.maxHeap[0]
        else:
            return (self.minHeap[0] - self.maxHeap[0]) / 2.0


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()