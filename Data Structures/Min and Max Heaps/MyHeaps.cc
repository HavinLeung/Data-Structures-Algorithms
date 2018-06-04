#include "MyHeaps.h"

using namespace std;

maxHeap::maxHeap() = default;

int maxHeap::leftChild(int curr) {
    int left = curr * 2 + 1;
    return (left > last()) ? -1 : left;
}

int maxHeap::rightChild(int curr) {
    int right = curr * 2 + 2;
    return (right > last()) ? -1 : right;
}

int maxHeap::parent(int curr) {
    return floor((curr - 1) / 2);
}

int maxHeap::last() {
    return my_array_.size() - 1;
}

void maxHeap::swap(int i1, int i2) {
    std::swap(my_array_[i1], my_array_[i2]);
}

void maxHeap::fixUp(int index) {
    while (parent(index) > -1 && my_array_[parent(index)] < my_array_[index]) {
        swap(index, parent(index));
        index = parent(index);
    }
}

void maxHeap::fixDown(int index) {
    while (leftChild(index) != -1 || rightChild(index) != -1) { //while not a leaf.. i.e. has children
        int largerChild = leftChild(index);
        if (largerChild != last() && my_array_[largerChild + 1] > my_array_[largerChild]) {
            ++largerChild;
        }
        if (my_array_[index] > my_array_[largerChild]) break;
        swap(index, largerChild);
        index = largerChild;
    }
}


void maxHeap::insert(int item) {
    my_array_.push_back(item);
    fixUp(last());
}

int maxHeap::deleteMax() {
    if (size() == 0) {
        throw "ERROR: Tried to delete from an empty heap";
    }
    int prev_max = my_array_[0];
    my_array_[0] = my_array_[last()];
    my_array_.pop_back();
    fixDown(0);
    return prev_max;
}

int maxHeap::size() {
    return my_array_.size();
}

int maxHeap::max() {
    return my_array_[0];
}

minHeap::minHeap() = default;

void minHeap::insert(int item) {
    heap.insert(-item);
}

int minHeap::deleteMin() {
    return -heap.deleteMax();
}

int minHeap::size() {
    return heap.size();
}

int minHeap::min() {
    return -heap.max();
}

