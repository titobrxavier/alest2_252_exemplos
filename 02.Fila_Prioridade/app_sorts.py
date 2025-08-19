from maxheap import MaxHeap
from mergesort import Mergesort
from quicksort import Quicksort
from time import process_time

import random

if __name__ == "__main__":

    MAX = 100000
    for n in range(500, MAX, 1000):

        data = [random.randint(1,n*10) for x in range(n)]
        #print(data)

        #qs = Quicksort()
        ms = Mergesort()
        #hs = MaxHeap(data)
        #print(hs.heap)

        start = process_time()
        #qs.sort(data)
        ms.sort(data)
        #hs.sort()
        end = process_time()
        t = end-start
        print(f"{n} {t}")

