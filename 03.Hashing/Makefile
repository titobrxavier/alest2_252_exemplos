# Compiler and flags
CXX = g++
CXXFLAGS = -std=c++17 -Wall -Wextra -O2

# Target executable
app_hashmap = app_hashmap
app_compara = app_compara

# Source files
app_hashmap_src = app_hashmap.cpp
app_compara_src = app_compara.cpp

INCLUDES = separatechaining_hashtable.h linearprobing_hashtable.h

# Build target
all: app_hashmap app_compara

app_hashmap: $(app_hashmap_src) $(INCLUDES)
	$(CXX) $(app_hashmap_src) $(CXXFLAGS) -o app_hashmap

app_compara: $(app_compara_src) $(INCLUDES)
	$(CXX) $(app_compara_src) $(CXXFLAGS) -o app_compara

# Clean up build files
clean:
	rm -f $(TARGET)

# Phony targets
.PHONY: all clean
