# Compiler and flags
CXX = g++
CXXFLAGS = -std=c++17 -Wall -Wextra -O2

all: app_maxheap app_sorts app_testeheapsort

app_maxheap = app_maxheap
app_maxheap_src = app_maxheap.cpp
app_maxheap_obj = $(app_maxheap_src:.cpp=.o)

app_sorts = app_sorts
app_sorts_src = app_sorts.cpp
app_sorts_obj = $(app_sorts_src:.cpp=.o)

app_testesort = app_testeheapsort
app_testesort_src = app_testeheapsort.cpp
app_testesort_obj = $(app_testesort_src:.cpp=.o)

$(app_maxheap): $(app_maxheap_obj)
	g++ $(CPPFLAGS) $(app_maxheap_obj) -o $@

$(app_sorts): $(app_sorts_obj)
	g++ $(CPPFLAGS) $(app_sorts_obj) -o $@

$(app_testsort): $(app_testesort_obj)
	g++ $(CPPFLAGS) $(app_testesort_obj) -o $@

# Clean up build files
clean:
	rm -f app_maxheap app_sorts app_testeheapsort app_maxheap.o app_sorts.o app_testeheapsort.o

# Phony targets
.PHONY: all clean
