from quicksort import quicksort

assert quicksort([5, 4, 3, 2, 1]) == [1, 2, 3, 4, 5]
assert quicksort([1, 3, 5, 4, 2]) == [1, 2, 3, 4, 5]
assert quicksort([1, 5, 2, 3, 4]) == [1, 2, 3, 4, 5]
assert quicksort([1, 2, 3, 4, 5]) == [1, 2, 3, 4, 5]
assert quicksort([0, 26, 19, 1, 2, 5, -12, 999, 2]) == [-12, 0, 1, 2, 2, 5, 19, 26, 999]
assert quicksort([5]) == [5]
assert quicksort([]) == []
