#ifndef _MAXHEAP_H
#define _MAXHEAP_H

#include <iostream>
#include <vector>
#include <ctime>
#include <iomanip>
#include <stdexcept>

template <typename T>
class MaxHeap {
private:
    std::vector<T> heap;

    void swim(int k) {
        while (k > 1 && heap[k / 2] < heap[k]) {
            //std::cout << "Swap " << heap[k] << " with " << heap[k / 2] << std::endl;
            std::swap(heap[k], heap[k / 2]);
            k = k / 2;
        }
    }

    void sink(int k, int size) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && heap[j] < heap[j + 1])
                j++;
            if (heap[k] >= heap[j])
                break;
            //std::cout << "Swap " << heap[k] << " with " << heap[k / 2] << std::endl;
            std::swap(heap[k], heap[j]);
            k = j;
        }
    }

public:
    MaxHeap() {
        heap.push_back(T()); // Insere um elemento vazio no início
    }

    // Construtor que recebe um array e copia para dentro do vector
    // (não é o ideal mas garante a flexibilidade do tamanho variável
    // do vector em situações "normais" - isto aqui é usado apenas no heapsort)
    MaxHeap(T* entrada, int tam) {
      heap.assign(entrada, entrada+tam);
    }

    void put(T data) {
        heap.push_back(data);
        swim(heap.size() - 1);
    }

    T get() {
        if (heap.size() <= 1)
            throw std::out_of_range("Heap vazio!");
        T res = heap[1];
        heap[1] = heap.back();
        heap.pop_back();
        sink(1,heap.size());
        return res;
    }

    // Retorna um ponteiro para o array interno gerenciado
    // pelo vector (lembrando que esse ponteiro ficará inválido
    // quando o vector deixar de existir)
    T* getArray() {
      return heap.data();
    }

    void sort() {
      int n = heap.size()-1;
      for(int k=n/2; k>=1; k--) {
        sink(k,n);
      }

      // 2. Ordena "removendo" o maior N-1 vezes (pois o último já vai estar na 1a. posição!)
      while(n > 1) {
        T tmp = heap[1];
        heap[1] = heap[n];
        heap[n] = tmp;
        n--;
        sink(1,n);
      }
    }

    void print() const {
        int size = heap.size() - 1;
        int b = 1;
        int elem = 1;
        int sp = 32;

        for (int j = 1; j <= size; j++)
            std::cout << heap[j] << " ";
        std::cout << std::endl;

        while (true) {
            for (int j = 0; j <= sp / 2; j++)
                std::cout << " ";
            for (int i = b; i < b + elem; i++) {
                if (i > size) {
                    std::cout << std::endl;
                    return;
                }
                std::cout << heap[i];
                for (int j = 0; j < sp; j++)
                    std::cout << " ";
            }
            std::cout << std::endl;
            b = b + elem;
            elem = 2 * elem;
            sp = sp / 2;
        }
    }

    void printArray() const {
      for(int i=0; i<heap.size(); i++) {
        std::cout << heap[i] << " ";
      }
      std::cout << std::endl;
    }
};
#endif

