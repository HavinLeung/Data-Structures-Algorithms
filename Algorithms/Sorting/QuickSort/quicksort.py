def quicksort(x):
    """
    Sorts the given list, returns a new list with all objects in order

    :param x: List to be sorted
    :type x: list
    :rtype : list
    """

    assert isinstance(x, list), "input should be a list"

    def _choose_pivot(m_list, left, right):
        """
        Chooses a pivot index in the given (restricted) list using the best of 3 method

        :return: index of chosen pivot
        """
        front = m_list[left]
        back = m_list[right]
        mid = m_list[(right+1-left)//2]

        if mid <= front <= back or back <= front <= mid:
            return left
        if front <= mid <= back or back <= mid <= front:
            return (right+1-left)//2
        return right

    def _partition(m_list, p, left, right):
        """
        Partitions m_list and returns an index i such that all items left of index i are <= m_list[i], and all
        items to the right of index i are >= m_list[i]. (We don't consider anything before left or after right)

        :param m_list: List to be partitioned
        :param p: index of pivot to be used
        :return: new index of the pivot
        """
        m_list[p], m_list[right] = m_list[right], m_list[p]  # swap pivot to the end
        i = left
        j = right-1
        v = m_list[right]
        while True:
            while i < right and m_list[i] <= v:
                i += 1
            while j > left and m_list[j] >= v:
                j -= 1
            if i >= j:
                break
            m_list[i], m_list[j] = m_list[j], m_list[i]
        m_list[i], m_list[right] = m_list[right], m_list[i]  # swap pivot back to "middle"
        return i

    def _sort(m_list, left, right):
        if left >= right:
            return
        pivot_index = _choose_pivot(m_list, left, right)
        i = _partition(m_list, pivot_index, left, right)
        _sort(m_list, left,i-1)
        _sort(m_list, i+1, right)

    # This is my first attempt - inefficient use of space

    # def _sort(m_list):
    #     if len(m_list) < 2:
    #         return m_list
    #     # initialize new lists and make the middle to be the pivot
    #     pivot = m_list[len(m_list) // 2]
    #     smaller, same, larger = [], [], []
    #     for i in range(len(m_list)):
    #         if m_list[i] < pivot:
    #             smaller.append(m_list[i])
    #         elif m_list[i] > pivot:
    #             larger.append(m_list[i])
    #         else:
    #             same.append(m_list[i])
    #
    #     return _sort(smaller) + same + _sort(larger)

    _sort(x, 0, len(x)-1)
