from maxheap import MaxHeap
import random

if __name__ == "__main__":

    data = [random.randint(1,1000) for x in range(200)]
    print(data)
    hs = MaxHeap(data)
    hs.sort()
    print(hs.heap)
