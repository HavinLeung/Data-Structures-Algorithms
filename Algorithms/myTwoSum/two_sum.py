# Two sum
# Given: "target" sum and a list of numbers
# Required: indices of numbers in your list that adds up to "target" sum


def two_sum(tgt, ins):
    required = {}  # Empty dict
    for x in range(len(ins)):
        if ins[x] in required:
            return 'The first pair that add to ' + str(tgt) + ' are at indices ' + str((required[ins[x]], x))
        required[target - ins[x]] = x
    return 'No pair that adds to ' + str(tgt) + ' found'


file = open('two_sum_input.txt')
target = int(file.readline())
inputs = list(map(int, file.read().split()))
file.close()
print(target)
print(inputs)
print(two_sum(target, inputs))
