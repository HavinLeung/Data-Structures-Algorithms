# Document distance
I was inspired by **lecture #2 of MIT 6.006** to try out the described "Document Distance". The sample inputs are taken from the MIT OCW site.
This is a vector based similarity measure, defined by the angle between two vectors, where each vector represents one of the documents.

I have done a line by line time complexity analysis:
```
67: file1 = get_words('input.txt')
68: file2 = get_words('input2.txt')
69: wordMap = {}
70: add_to_dict(file1, file2, wordMap)
71: dotProduct = get_dot_product(wordMap)
72: totalSum = get_vector_product_size(wordMap)
```

Let W1 and W2 be the number of words in each document respectively. 
L1 and L2 will be the number of unique words in each document respectively.
```
67: The methods used in the function get_words are O(n)
    O(W1)
68: Same method as line 67
    O(W2)
69: Empty dictionary
    O(1)
70: Loop goes through every word in both documents and adds to dictionary
    O(W1+W2)
71: Loop goes through every unique word in the dictionary. Only performs action if word is in Doc 1
    O(L1)
72: Loop goes through every unique word in the dictionary
    O(L1+L2)
```
### The total time complexity is: O(W1) + O(W2) + ... + O(L1+L2)
### Since W >= L, the algorithm is O(W) where W is the number of words in both documents.
