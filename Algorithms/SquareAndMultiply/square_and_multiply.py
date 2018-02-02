def power(base, exponent):
    """
    Takes a base and an exponent and calculates the result using the square and multiply method.
    Exapmle usage:

    >>> power(2, 3)
    8

    :type base: numbers.Number
    :type exponent: int
    :rtype: numbers.Number
    """
    import numbers
    assert isinstance(base, numbers.Number), "Base must be a number"
    assert isinstance(exponent, int), "Exponent must be an integer"

    if exponent == 0:
        return 1
    if exponent < 0:
        return power(1 / base, -exponent)
    square = base
    value = 1

    # First try:

    # # Square step.
    # # Calculate all square up till length of the binary representation
    # squares = list()
    # for _ in (range(len(bin_rep))):
    #     squares.append(square)
    #     square **= 2
    #
    # # Multiply step.
    # for i in range(len(bin_rep)):
    #     if bin_rep[i] == '1':
    #         value *= squares[i]

    # Second try:

    # Square and multiply in same loop.
    # Improved space complexity from O(lg(n)) to O(1)
    # Improved constant factor of time complexity
    while exponent:
        if exponent & 1:
            value *= square
        exponent >>= 1
        square *= square

    return value
