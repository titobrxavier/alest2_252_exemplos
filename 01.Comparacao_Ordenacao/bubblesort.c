#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 30000

void bubblesort(int values[], int total);

void bubblesort(int values[], int total)
{
    for(int i=0; i<total; i++) {
        char trocou = 0;
        for(int j=0; j<total-i-1; j++) {
            if(values[j] > values[j+1]) {
               int temp = values[j];
               values[j] = values[j+1];
               values[j+1] = temp;
               trocou = 1;
            }
        }
        if(!trocou) break;
    }
}

int main()
{
    int data[MAX];
    for(int n=500; n<=MAX; n+=500) {
        for(int i=0; i<n; i++)
            data[i] = rand()%(n*10);
        long start = clock();
        bubblesort(data, n);
        long end = clock();
        float tempo = (end-start)/(float)CLOCKS_PER_SEC;
        printf("%d %f\n", n, tempo);
        //for(int i=0; i<n; i++)
        //    printf("%d ", data[i]);
        //printf("\n");
    }
}
