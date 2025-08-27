#include <algorithm>
#include <fstream>
#include <iostream>
#include <string>
#include <time.h>

#include "linearprobing_hashtable.h"
#include "separatechaining_hashtable.h"

using namespace std;

int main() {
    // Inicializa a tabela hash
    LinearProbingHashTable<string, int> ht;
    //SeparateChainingHashTable<string, int> ht;

    // Este é BEM maior
    ifstream arq("mobydick.txt");

    string word;
    long start = clock();
    while (arq >> word) {
        word = word.substr(0, word.find_first_of(".,;:!?\"'()[]{}<>")); // remove pontuação
        // Jeito "simples" de transformar em minúsculas...
        std::transform(word.begin(), word.end(), word.begin(), [](unsigned char c) {
            return static_cast<char>(std::tolower(c));
        });                                                            // 
        if (!ht.contains(word)) {
            //cout << "New word: " << word << endl;
            ht.insert(word, 1);
        }
        ht.insert(word, ht.get(word) + 1);
    }
    long end = clock();
    double elapsed = (end - start) / (double)CLOCKS_PER_SEC;

    arq.close();

    cout << "Total: " << ht.size() << " palavras distintas." << endl;
    cout << "Tempo gasto: " << elapsed << " segundos." << endl;
    return 0;
}
