class UnionFind:
    def __init__(self, n):
        self.arr = [i for i in range(n)]
    
    def find(self, i):
        if self.arr[i] != i:
            self.arr[i] = self.find(self.arr[i])
        return self.arr[i]
    
    def merge(self, x, y):
        x = self.find(x)
        y = self.find(y)
        self.arr[y] = x

    def unique(self):
        uniques = set()
        for i in range(len(self.arr)):
            uniques.add(self.find(i))
        return uniques
