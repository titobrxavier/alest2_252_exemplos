class Node:
    def __init__(self, key, x):
        self.key = key
        self.data = x
        
class DeadNode:
    pass

class LinearProbingHashTable:
    def __init__(self, size=10):
        if size <= 1:
            raise Exception('hash table size less than 1')
        self.hash_table = [None for _ in range(size)]
        self.size = size
        self.total_count = 0
        self.max_load_factor = 0.4
        
    def __repr__(self):
        ret = ''
        for idx, e in enumerate(self.hash_table):
            line = 'idx: {}, '.format(idx)
            if e is not None:
                if e is DeadNode:
                    line += 'Deadnode'
                else:
                    line += 'key: {}, val: {}'.format(e.key, e.data)
            else:
                line += 'None'
            ret += line + '\n'
        return ret
    
    def _get_threshold(self):
        return int(self.size * self.max_load_factor)
    
    def _hash_func(self, key):
        return hash(key) % self.size
    
    def _probing_func(self, hash_idx, count):
        offset = count + 0
        return (hash_idx + offset) % self.size
    
    def _expand_and_reallocate(self):
        self.size = self.size * 2
        pre_hash_table = self.hash_table
        self.hash_table = [None for _ in range(self.size)]
        for e in pre_hash_table:
            if e is not None:
                self.insert(e.key, e.data)
    
    def _insert(self, idx, node):
        self.hash_table[idx] = node
        self.total_count += 1
        if self.total_count > self._get_threshold():
            self._expand_and_reallocate()
        return
    
    def insert(self, key, value):
        hash_idx = self._hash_func(key)
        idx = hash_idx
        prob_term = 1
        idx_set = set()
        while 1:
            idx_set.add(idx)
            node = self.hash_table[idx]
            if node is None or node is DeadNode:
                self._insert(idx, Node(key, value))
                return
            elif node.key == key:
                node.data = value
                return
            idx = self._probing_func(hash_idx, prob_term)
            prob_term += 1
            if idx in idx_set: # chaos of cycles
                if len(prob_idx_set) == self.size:
                    self._expand_and_reallocate()
                    self.insert(key, value)
                    break
                else:
                    raise Exception('hash table issue: chaos of cycles')    
    
    def search(self, key, to_return_idx=False):
        hash_idx = self._hash_func(key)
        idx = hash_idx
        prob_term = 1
        idx_set = set()
        while 1: 
            idx_set.add(idx)
            node = self.hash_table[idx]
            if node is None:
                raise KeyError(key)
            elif node is not DeadNode:
                if node.key == key:
                    return node.data if not to_return_idx else idx
            idx = self._probing_func(hash_idx, prob_term)
            prob_term += 1
            if idx in idx_set:
                if len(idx_set) == self.size:
                    raise KeyError(key)
                else:
                    raise Exception('hash table issue: chaos of cycles')  
    
    def remove(self, key):
        idx = self.search(key, to_return_idx=True)
        self.hash_table[idx] = DeadNode

    def __len__(self): 
        return self.size 

    def __contains__(self, key): 
        try: 
            self.search(key) 
            return True
        except KeyError: 
            return False

if __name__ == '__main__': 

    # Create a hash table with 
    # a capacity of 5 
    ht = LinearProbingHashTable(5) 

    # Add some key-value pairs 
    # to the hash table 
    ht.insert("apple", 3) 
    ht.insert("banana", 2) 
    ht.insert("cherry", 5) 

    # Check if the hash table 
    # contains a key 
    print("apple?", "apple" in ht) # True 
    print("durian?", "durian" in ht) # False 

    # Get the value for a key 
    print("banana:",ht.search("banana")) # 2 

    # Update the value for a key 
    ht.insert("banana", 4) 
    print("new banana:",ht.search("banana")) # 4 

    ht.remove("apple") 
    # Check the size of the hash table 
    print("len:",len(ht)) # 3 

