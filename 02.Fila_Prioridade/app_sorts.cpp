#include <iostream>
#include <cstdlib>
#include <chrono>

#include "mergesort.h"
#include "quicksort.h"
#include "maxheap.h"

#define MAX 100000

using namespace std;

int main()
{
    int data[MAX];
    srand(time(NULL));
    for(int n=500; n<=MAX; n+=500) {
        for(int i=0; i<n; i++)
            data[i] = rand()%(MAX*10);
        //MergeSort<int> ms;
        QuickSort<int> qs;
        //MaxHeap<int> hs = MaxHeap(data, n);
        auto start = std::chrono::high_resolution_clock::now();
        //ms.sort(data, n);
        //hs.sort();
        qs.sort(data, n);
        //qsort(data, n, sizeof(int), compare); // usar com qsort
        auto end = std::chrono::high_resolution_clock::now();
        std::chrono::duration<float> duration = end - start;
        int* vet = data;
        //int* vet = hs.getArray(); // usar com heapsort
        for(int i=0; i<n; i++)
            cout << vet[i] << " ";
        cout << endl;

        cout << n << " " << setprecision(7) << fixed << duration.count() << endl;
        break;
    }
}

