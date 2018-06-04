#ifndef MYHEAPS_H
#define MYHEAPS_H

#include <vector>
#include <utility>
#include <cmath>

class maxHeap {
private:
    std::vector<int> my_array_;

    int leftChild(int curr);

    int rightChild(int curr);

    int parent(int curr);

    int last();

    void swap(int i1, int i2);

    void fixUp(int index);

    void fixDown(int index);

public:
    maxHeap();

    void insert(int item);

    int deleteMax();

    int size();

    int max();
};

class minHeap {
private:
    maxHeap heap;
public:
    minHeap();

    void insert(int item);

    int deleteMin();

    int size();

    int min();
};

#endif