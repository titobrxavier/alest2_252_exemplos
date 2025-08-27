# Compiler and flags
CXX = g++
CXXFLAGS = -std=c++17 -Wall -Wextra -O2

# Target executable
btree = btree

# Source files
btree_src = btree.cpp

#INCLUDES = separatechaining_hashtable.h linearprobing_hashtable.h

# Build target
all: btree

btree: $(btree_src) #$(INCLUDES)
	$(CXX) $(btree_src) $(CXXFLAGS) -o btree

# Clean up build files
clean:
	rm -f btree

# Phony targets
.PHONY: all clean
