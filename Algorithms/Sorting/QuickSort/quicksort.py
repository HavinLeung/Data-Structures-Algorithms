def quicksort(x):
    """
    Sorts the given list, returns a new list with all objects in order

    :param x: List to be sorted
    :type x: list
    :rtype : list
    """

    assert isinstance(x, list), "input should be a list"

    def _sort(y):
        if len(y) < 2:
            return y
        # initialize new lists and make the middle to be the pivot
        pivot = y[len(y) // 2]
        smaller, same, larger = [], [], []
        for i in range(len(y)):
            if y[i] < pivot:
                smaller.append(y[i])
            elif y[i] > pivot:
                larger.append(y[i])
            else:
                same.append(y[i])

        return _sort(smaller) + same + _sort(larger)

    return _sort(x)
