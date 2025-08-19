#include <iostream>

#include "maxheap.h"

using namespace std;

int main()
{
    int total = 200;
    int data[201];

    for(int i=1; i<=total; i++)
        data[i] = rand()%(total*10);

    MaxHeap<int> maxheap(data, 201);

    // Obtém uma referência para o array interno do vector
    // (perigoso, usar com cuidado - quando o vector deixar de existir, o ponteiro ficará inválido!)
    int* vet = maxheap.getArray();

    for(int i=0; i<=total; i++)
        cout << vet[i] << " ";
    cout << endl;

    maxheap.sort();

    for(int i=0; i<=total; i++)
        cout << vet[i] << " ";
    cout << endl;
}

