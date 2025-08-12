#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 100000

int helper[MAX];

void mergeSort(int values[], int total);
void mergesort2(int values[], int low, int high);
void merge(int values[], int low, int middle, int high);

void mergeSort(int values[], int total) {
    mergesort2(values, 0, total-1);
}

void mergesort2(int values[], int low, int high) {
// Check if low is smaller then high, if not then the array is sorted
    if (low < high) {
// Get the index of the element which is in the middle
        int middle = (low + high) / 2;
// Sort the left side of the array
        mergesort2(values, low, middle);
// Sort the right side of the array
        mergesort2(values, middle + 1, high);
// Combine them both
        merge(values, low, middle, high);
    }
}

void merge(int values[], int low, int middle, int high) {

    // Copy both parts into the helper array
    for (int i = low; i <= high; i++) {
        helper[i] = values[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;
    // Copy the smallest values from either the left or the right side back
    // to the original array
    while (i <= middle && j <= high) {
        if (helper[i] <= helper[j]) {
            values[k] = helper[i];
            i++;
        } else {
            values[k] = helper[j];
            j++;
        }
        k++;
    }
    // Copy the rest of the left side of the array into the target array
    while (i <= middle) {
        values[k] = helper[i];
        k++;
        i++;
    }
}

int main()
{
    int data[MAX];
    for(int n=500; n<=MAX; n+=500) {
        for(int i=0; i<n; i++)
            data[i] = rand()%(MAX*10);
        long start = clock();
        mergeSort(data, n);
        long end = clock();
        float tempo = (end-start)/(float)CLOCKS_PER_SEC;
        printf("%d %f\n", n, tempo);
    }
    //for(int i=0; i<MAX; i++)
    //    printf("%d ", data[i]);
    //printf("\n");
}
