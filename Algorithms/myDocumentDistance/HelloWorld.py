import string
import math


# Reads entire file and returns a list
def get_words(filename):
    f = open(filename, 'r')
    file = f.read()
    file = file.lower()
    file = file.translate(str.maketrans('', '', string.punctuation))
    file = file.split()
    print(file)
    return file


# stores occurrences of some word in document A and B
class OccurrenceCounter:
    def __init__(self, a: int, b: int):
        self.a = a
        self.b = b

    def add_a(self):
        self.a += 1

    def add_b(self):
        self.b += 1

    def dot_product(self):
        if self.a != 0:
            return self.a * self.b
        return 0


# adds all words in list 1 and list 2 to a map(word, OccurrenceCounter)
def add_to_dict(word_list_1: list, word_list_2: list, word_map: dict):
    for word in word_list_1:
        if word in word_map:
            word_map[word].add_a()
        else:
            word_map[word] = OccurrenceCounter(1, 0)
    for word in word_list_2:
        if word in word_map:
            word_map[word].add_b()
        else:
            word_map[word] = OccurrenceCounter(0, 1)


# gets dot product from the 2 vectors in map
def get_dot_product(word_map):
    running_sum = 0
    for key in word_map:
        running_sum += word_map[key].dot_product()
    return running_sum


def get_vector_product_size(word_map):
    running_sum_a = 0
    running_sum_b = 0
    for key in word_map:
        running_sum_a += getattr(word_map[key], 'a')**2
        running_sum_b += getattr(word_map[key], 'b')**2
    running_sum_a = math.sqrt(running_sum_a)
    running_sum_b = math.sqrt(running_sum_b)
    return running_sum_b*running_sum_a


file1 = get_words('input.txt')                  # Let W1, W2, L1, L2 be # of words and unique words in each document
file2 = get_words('input2.txt')                 # O(W1+W2): get_words str methods are O(n)
wordMap = {}                                    # O(1): create an empty dictionary
add_to_dict(file1, file2, wordMap)              # O(W1+W2): runs through every word
dotProduct = get_dot_product(wordMap)           # O(L1): runs through every unique word
totalSum = get_vector_product_size(wordMap)     # O(L1+L2): runs through every unique word
print(dotProduct)                               # Total: O(W)+O(L)+O(1)... since L<=W, O(L) = O(W)
print(totalSum)                                 # Total complexity: O(W)
print(math.acos(dotProduct / totalSum) / math.pi * 180)

exit()
