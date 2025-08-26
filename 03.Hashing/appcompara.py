from linearprobing import LinearProbingHashTable
from separatechaining import SeparateChainingHashTable
import sys

if __name__ == '__main__': 

    ht = LinearProbingHashTable() 
    # ht = SeparateChainingHashTable(100)

    with open("DomCasmurro_utf8.txt") as arq:
        for line in arq:
            linewords = [x.lower() for x in line.split()]
            print(linewords)
            for word in linewords:
                if word not in ht:
                    ht.insert(word, 1)
                ht.insert(word,ht.search(word)+1)

    print("Tamanho:",ht.total_count)
    # print(ht)


