#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "mergesort.h"
#include "quicksort.h"
#include "maxheap.h"

#define MAX 100000

int main()
{
    int data[MAX];
    for(int n=500; n<=MAX; n+=500) {
        for(int i=0; i<n; i++)
            data[i] = rand()%(MAX*10);
        long start = clock();
        //MergeSort<int> ms;
        QuickSort<int> qs;
        //ms.sort(data, n);
        qs.sort(data, n);
        //quicksort(data, n);
        long end = clock();
        float tempo = (end-start)/(float)CLOCKS_PER_SEC;
        printf("%d %f\n", n, tempo);
    }
}

