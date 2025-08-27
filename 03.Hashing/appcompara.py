from linearprobing import LinearProbingHashTable
from separatechaining import SeparateChainingHashTable
import sys
from time import process_time

if __name__ == '__main__': 

    # Descomente a versão desejada abaixo
    ht = LinearProbingHashTable() 
    #ht = SeparateChainingHashTable()

    start = process_time()
    with open("mobydick.txt") as arq:
        for line in arq:
            linewords = [x.lower() for x in line.split()]
            #print(linewords)
            for word in linewords:
                if word not in ht:
                    #print("New word: ",word)
                    ht.insert(word, 1)
                ht.insert(word,ht.search(word)+1)
    end = process_time()
    delta = end-start

    print(f"Tamanho: {len(ht)}")
    print(f"Tempo: {delta} s")


